package randy.web.domain;

import java.util.List;

import randy.core.spring.domain.AbstractDomain;

/**
 * 상품 도메인.
 * 
 * @author jace
 */
public class Product extends AbstractDomain {

	/** 카테고리 id */
	private List<Integer> cateIdList;

	/** 상품명 */
	private String prdName;
	/** 상품 URL */
	private String prdUrl;
	/** 상품 가격 */
	private String prdPrice;
	/** 썸네일 URL */
	private String prdThumbUrl;
	/** mall id */
	private Integer mallId;

	public List<Integer> getCateIdList() {
		return cateIdList;
	}

	public void setCateIdList(List<Integer> cateIdList) {
		this.cateIdList = cateIdList;
	}

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

	public String getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(String prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdThumbUrl() {
		return prdThumbUrl;
	}

	public void setPrdThumbUrl(String prdThumbUrl) {
		this.prdThumbUrl = prdThumbUrl;
	}

	public Integer getMallId() {
		return mallId;
	}

	public void setMallId(Integer mallId) {
		this.mallId = mallId;
	}

}
