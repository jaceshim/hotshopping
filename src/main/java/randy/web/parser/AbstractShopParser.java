package randy.web.parser;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractShopParser implements ShopParser {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 주어진 url의 응답 html 문자열을 얻는다.
	 * 
	 * @param url
	 * @return String
	 * @throws Exception
	 */
	protected String getHtml(String url, String encoding) throws Exception {
		
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		
		int statusCode = client.executeMethod(method);
		if (statusCode == HttpStatus.SC_OK) {
			return new String(method.getResponseBody(), encoding);
		}
		
		return "";
	}
}
