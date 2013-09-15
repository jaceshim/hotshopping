package randy.web.domain;

import randy.core.j2ee.domain.AbstractPageDomain;

/**
 * 상품 도메인.
 * 
 * @author jace
 */
public class Product extends AbstractPageDomain {

	/** 몰 */
	private Mall mall;

	/** 카테고리 */
	private Category category;

	private CategoryTagUnreg categoryTagUnreg;

	private String categoryTag;

	/** 상품순번 */
	private Integer prdSeq;
	/** 상품유형 ( 1: 인기상품, 2: 오늘 특가 상품 ) */
	private Integer prdType;
	/** 카테고리 아이디 */
	private Integer cateId;
	/** mall id */
	private Integer mallId;
	/** 상품명 */
	private String prdName;
	/** 상품 본 아이디 */
	private String prdOrgId;
	/** 상품 URL */
	private String prdUrl;
	/** 상품 가격 */
	private Integer prdPrice;
	/** 썸네일 URL */
	private String prdThumbUrl;
	/** 사용여부 */
	private String useYn;

	public Mall getMall() {
		return mall;
	}

	public void setMall(Mall mall) {
		this.mall = mall;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryTagUnreg getCategoryTagUnreg() {
		return categoryTagUnreg;
	}

	public void setCategoryTagUnreg(CategoryTagUnreg categoryTagUnreg) {
		this.categoryTagUnreg = categoryTagUnreg;
	}

	public String getCategoryTag() {
		return categoryTag;
	}

	public void setCategoryTag(String categoryTag) {
		this.categoryTag = categoryTag;
	}

	public Integer getPrdSeq() {
		return prdSeq;
	}

	public void setPrdSeq(Integer prdSeq) {
		this.prdSeq = prdSeq;
	}

	public Integer getPrdType() {
		return prdType;
	}

	public void setPrdType(Integer prdType) {
		this.prdType = prdType;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public Integer getMallId() {
		return mallId;
	}

	public void setMallId(Integer mallId) {
		this.mallId = mallId;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdOrgId() {
		return prdOrgId;
	}

	public void setPrdOrgId(String prdOrgId) {
		this.prdOrgId = prdOrgId;
	}

	public String getPrdUrl() {
		return prdUrl;
	}

	public void setPrdUrl(String prdUrl) {
		this.prdUrl = prdUrl;
	}

	public Integer getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(Integer prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdThumbUrl() {
		return prdThumbUrl;
	}

	public void setPrdThumbUrl(String prdThumbUrl) {
		this.prdThumbUrl = prdThumbUrl;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

}
