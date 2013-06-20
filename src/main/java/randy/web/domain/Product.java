package randy.web.domain;

import randy.core.spring.domain.AbstractDomain;

/**
 * 상품 도메인.
 * 
 * @author jace
 */
public class Product extends AbstractDomain {

	/** 상품명 */
	private String prdName;
	/** 상품 URL */
	private String prdUrl;
	/** 상품 가격 */
	private int prdPrice;
	/** 썸네일 URL */
	private String prdThumbUrl;
	/** mall id */
	private int mallId;
	/** 카테고리 id */
	private int cateId;

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdUrl() {
		return prdUrl;
	}

	public void setPrdUrl(String prdUrl) {
		this.prdUrl = prdUrl;
	}

	public int getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdThumbUrl() {
		return prdThumbUrl;
	}

	public void setPrdThumbUrl(String prdThumbUrl) {
		this.prdThumbUrl = prdThumbUrl;
	}

	public int getMallId() {
		return mallId;
	}

	public void setMallId(int mallId) {
		this.mallId = mallId;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

}
