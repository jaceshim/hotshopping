package randy.web.parser;

import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import randy.web.front.service.FrontService;

@Component
public abstract class AbstractShopParser implements ShopParser {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FrontService frontService;	

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
