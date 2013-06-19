package randy.web.parser;

/**
 * shop parsing 인터페이스
 * 
 * @author jace
 */
public interface ShopParser {

	
	/**
	 * event 페이지 url
	 * 
	 * @return String
	 */
	String getEventUrl();
	
	/**
	 * 기획전 페이지 url
	 * 
	 * @return String
	 */
	String getPromotionUrl();
	
	/**
	 * 상품페이지 url
	 * 
	 * @return
	 */
	String getItemUrl();
	
	
}
