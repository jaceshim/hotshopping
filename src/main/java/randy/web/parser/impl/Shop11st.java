package randy.web.parser.impl;

import java.util.ArrayList;
import java.util.List;

import randy.web.domain.Event;
import randy.web.domain.Product;
import randy.web.domain.Promotion;
import randy.web.parser.AbstractShopParser;

/**
 * 11번가
 * 
 * @author jace
 */
public class Shop11st extends AbstractShopParser {

	@Override
	public String getEventUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPromotionUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getItemUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getEnconding() {
		return "euc-kr";
	}	
	

	@Override
	public List<Event> parseEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> parsePromotion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> parseProduct() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Product> parseTodaySpecial() {
		
		List<Product> resultList = new ArrayList<Product>();
		
		try {
			String result = this.getHtml("http://www.11st.co.kr/html/main.html", getEnconding());
			System.out.println("--> 응답값 : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		return resultList;
	}
}
