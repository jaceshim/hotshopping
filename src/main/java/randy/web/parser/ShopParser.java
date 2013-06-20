package randy.web.parser;

import java.util.List;

import randy.web.domain.Event;
import randy.web.domain.Product;
import randy.web.domain.Promotion;

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
	 * @return String
	 */
	String getItemUrl();
	
	/**
	 * 인코딩
	 * 
	 * @return String
	 */
	String getEnconding();
	
	/**
	 * 이벤트 parse
	 * 
	 * @return String
	 */
	List<Event> parseEvent();
	
	/**
	 * 기획전 parse
	 * 
	 * @return String
	 */
	List<Promotion> parsePromotion();
	
	/**
	 * 상품 parse
	 * 
	 * @return String
	 */
	List<Product> parseProduct();
	
	/**
	 * 오늝 특가 parse
	 * 
	 * @return String
	 */
	List<Product> parseTodaySpecial();
	
}
