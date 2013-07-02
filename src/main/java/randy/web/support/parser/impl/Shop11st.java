package randy.web.support.parser.impl;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import randy.web.domain.Event;
import randy.web.domain.Product;
import randy.web.domain.Promotion;
import randy.web.support.parser.AbstractShopParser;
import sun.org.mozilla.javascript.internal.NativeArray;
import sun.org.mozilla.javascript.internal.NativeObject;

/**
 * 11번가
 * 
 * @author jace
 */
public class Shop11st extends AbstractShopParser {

	@Override
	public Integer getMallId() {
		return 1;
	}

	@Override
	public String getEnconding() {
		return "euc-kr";
	}

	@Override
	public long getScheduleInterval() {
		return DEFAULT_SCHEDULE_INTERVAL;
	}

	@Override
	public List<Event> parseEvent() {
		return null;
	}

	@Override
	public List<Promotion> parsePromotion() {
		return null;
	}

	@Override
	public List<Product> parseProduct() {
		return null;
	}

	@Override
	public List<Product> parseTodaySpecial() {

		List<Product> resultList = new ArrayList<Product>();

		try {
			String script = this.getHtml("http://www.11st.co.kr/js/local/main5Ad.js");

			System.out.println("--> 응답값 : " + script);

			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine se = sem.getEngineByName("JavaScript");
			se.put("_dsSeverMode", "false");
			se.eval(script);

			NativeArray datas = (NativeArray)NativeObject.getProperty((NativeObject)se.get("FashionStoryAd"), "DATA");

			for (int i = 0, j = (int)datas.getLength(); i < j; i++) {
				NativeObject tempObj = (NativeObject)datas.get(i, null);
				Object[] objs = tempObj.getAllIds();

				Product prd = new Product();
				prd.setMallId(this.getMallId());

				String prdUrl = "http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&prdNo=";

				for (Object obj : objs) {
					String key = obj.toString();
					String value = NativeObject.getProperty(tempObj, key).toString();

					if (key.equals("TXT1")) {
						prd.setPrdName(value);
					} else if (key.equals("JURL1")) {
						String prdNo = NativeObject.getProperty(tempObj, "NUM1").toString();
						prdUrl += prdNo;

						// 상품 url세팅.
						prd.setPrdUrl(prdUrl);
						// 상품 원래 아이디 세팅.
						prd.setPrdOrgId(prdNo);

					} else if (key.equals("IMG1")) {
						prd.setPrdThumbUrl(value);
					} else if (key.equals("PRC1")) {
						// 통화단위를 삭제처리.
						value = StringUtils.replace(StringUtils.trim(value), ",", "");
						prd.setPrdPrice(Integer.parseInt(value));
					}
				}

				// 상세페이지를 호출하여 최상위 카테고리 분류값을 찾은다음 카테고리 tags에 match되는 카테고리 상품군에 정보 저장.
				String prdHtml = getProductInfoHtml(prdUrl, null);
				if (StringUtils.isNotEmpty(prdHtml)) {
					Document prdDetailDoc = Jsoup.parse(prdHtml);

					String categoryTag = prdDetailDoc.select("#headSel_1").text();
					logger.debug("--> 카테고리 태그명 : {} ", categoryTag);

					prd.setCategoryTag(categoryTag);
				}

				resultList.add(prd);

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		return resultList;
	}

	@Test
	public void test() {
		List<Product> pList = parseTodaySpecial();
		for (Product prd : pList) {
			System.out.println(prd.toString());
		}
	}
}
