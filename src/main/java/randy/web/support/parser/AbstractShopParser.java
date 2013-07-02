package randy.web.support.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import randy.core.spring.dao.CommonDao;
import randy.web.domain.CategoryTag;
import randy.web.domain.CategoryTagUnreg;
import randy.web.domain.Product;
import randy.web.service.CategoryService;
import randy.web.service.ProductService;

public abstract class AbstractShopParser implements ShopParser {

	/** 기본 스케쥴러 실행 주기 */
	protected static final long DEFAULT_SCHEDULE_INTERVAL = 1L;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected CommonDao commonDao;

	/** 주기적으로 파싱을 처리하는 TimerTask킄래스 인스턴스 */
	private Timer parsingTimer;

	public Timer getParsingTimer() {
		return this.parsingTimer;
	}

	/**
	 * Parser 로직흐름을 처리한다.
	 * 
	 */
	public final void execute() {

		final AbstractShopParser parser = this;
		// 비 동기식으로 처리.
		new Thread(new Runnable() {
			@Override
			public void run() {
				parser.parse();
			}
		}).start();
	}

	/**
	 * 파싱처리.
	 */
	protected final void parse() {

		List<Product> todaySpecialList = this.parseTodaySpecial();
		// insert대상 오늘만 특가 상품 리스트.
		List<Product> insertTodaySpecialList = new ArrayList<Product>();

		for (Product item : todaySpecialList) {
			// 해당 아이템의 카테고리 태그 정보가 존재하는 판단.
			CategoryTag param = new CategoryTag();
			param.setTag(item.getCategoryTag());
			List<CategoryTag> tagList = this.commonDao.selectList(CategoryService.NAMESPACE, "getUniqueCategoryTagList", param);

			// 파서가 추출한 카테고리와 매치되는 카테고리 tag 정보를 호출하여 해당 건수만큼 상품정보를 등록한다. 
			if (tagList != null && tagList.size() > 0) {
				for (CategoryTag tagItem : tagList) {
					Product insertPrd = (Product)ObjectUtils.clone(item);
					insertPrd.setCateId(tagItem.getCateId());
					insertPrd.setUseYn("Y");

					insertTodaySpecialList.add(insertPrd);
				}
			} else {
				item.setUseYn("N");

				// unreg tag 테이블에 등록.
				CategoryTagUnreg tagUnreg = new CategoryTagUnreg();
				tagUnreg.setMallId(item.getMallId());
				tagUnreg.setPrdName(item.getPrdName());
				tagUnreg.setTag(item.getCategoryTag());
				// 미처리로 등록.
				tagUnreg.setProcYn("N");

				item.setCategoryTagUnreg(tagUnreg);

				insertTodaySpecialList.add(item);
			}
		}

		// 오늘의 특가 상품등록.
		for (Product item : insertTodaySpecialList) {
			// 오늘만 특가 상품유형 지정.
			item.setPrdType(ProductType.TODAY.getType());
			Integer prdSeq = (Integer)commonDao.insert(ProductService.NAMESPACE, "insertProduct", item);

			// 상품정보가 카테고리가 없는 상품정보의 경우 미등록 태그정보 등록.
			CategoryTagUnreg tagUnreg = item.getCategoryTagUnreg();
			if (tagUnreg != null) {
				tagUnreg.setPrdSeq(prdSeq);
				commonDao.insert(CategoryService.NAMESPACE, "insertCategoryTagUnreg", tagUnreg);
			}

		}
	}

	/**
	 * 파서 초기화 작업.
	 * 파서 스케쥴을 실행하는 TimerTask 등록.
	 * @param commonDao
	 */
	protected void init(CommonDao commonDao) {
		this.commonDao = commonDao;

		long scheduleInterval = (this.getScheduleInterval() * 60 * 1000);

		ParseTimerTask timerTask = new ParseTimerTask(this);
		// flush Timer 등록.
		parsingTimer = new Timer(this.getClass().getSimpleName(), true);
		parsingTimer.scheduleAtFixedRate(timerTask, scheduleInterval, scheduleInterval);
	}

	/**
	 * 주어진 url의 응답 html 문자열을 얻는다.
	 * 
	 * @param url
	 * @return String
	 * @throws Exception
	 */
	protected String getHtml(String url) throws Exception {
		HttpClient client = getHttpClient();
		HttpMethod method = new GetMethod(url);

		int statusCode = client.executeMethod(method);
		if (statusCode == HttpStatus.SC_OK) {
			return new String(method.getResponseBody(), this.getEnconding());
		}

		return "";
	}

	/**
	 * 상품의 상세정보 html 문자열을 얻는다.
	 * 
	 * @param url
	 * @param params
	 * @param encoding
	 * @return String
	 * @throws Exception
	 */
	protected String getProductInfoHtml(String url, Map<String, String> params) throws Exception {
		HttpClient client = getHttpClient();
		HttpMethod method = new GetMethod(url);

		if (params != null) {
			HttpMethodParams param = new HttpMethodParams();

			for (String key : params.keySet()) {
				param.setParameter(key, params.get(key));
			}

			method.setParams(param);
		}

		int statusCode = client.executeMethod(method);
		if (statusCode == HttpStatus.SC_OK) {
			return new String(method.getResponseBody(), this.getEnconding());
		}
		return "";
	}

	/**
	 * HttpClient객체를 얻는다.
	 * 
	 * @return HttpClient
	 */
	private HttpClient getHttpClient() {
		return new HttpClient();
	}
}
