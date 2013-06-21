package randy.web.parser.impl;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

import randy.web.domain.Event;
import randy.web.domain.Product;
import randy.web.domain.Promotion;
import randy.web.parser.AbstractShopParser;
import sun.org.mozilla.javascript.internal.NativeArray;
import sun.org.mozilla.javascript.internal.NativeObject;

/**
 * 11번가
 * 
 * @author jace
 */
public class Shop11st extends AbstractShopParser {
	
	@Override
	public int getMallId() {
		return 1;
	}
	

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
			String script = this.getHtml("http://www.11st.co.kr/js/local/main5Ad.js", getEnconding());
			
			System.out.println("--> 응답값 : " + script);
			
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine se = sem.getEngineByName("JavaScript");
			se.put("_dsSeverMode", "false");
			se.eval(script);
			
			NativeArray datas = (NativeArray) NativeObject.getProperty((NativeObject)se.get("FashionStoryAd"), "DATA");
			
			for (int i = 0, j = (int) datas.getLength() ; i < j ; i++) {
				NativeObject tempObj = (NativeObject) datas.get(i, null);
				Object[] objs = tempObj.getAllIds();
				
				Product prd = new Product();
				prd.setMallId(this.getMallId());
				
				for (Object obj : objs) {
					String key = obj.toString();
					String value = NativeObject.getProperty(tempObj, key).toString();
					
					if (key.equals("TXT1")) {
						prd.setPrdName(value);
					} else if (key.equals("JURL1")) {
						String prdNo = NativeObject.getProperty(tempObj, "NUM1").toString(); 
						String prdUrl = "http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&prdNo=" + prdNo;
						prd.setPrdUrl(prdUrl);
						
					} else if (key.equals("IMG1")) {
						prd.setPrdThumbUrl(value);
					} else if (key.equals("PRC1")) {
						prd.setPrdPrice(value);
					}
				}
				
				// TODO: 상세페이지를 호출하여 최상위 카테고리 분류값을 찾은다음 카테고리 tags에 match되는 카테고리 상품군에 정보 저장.
				
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
