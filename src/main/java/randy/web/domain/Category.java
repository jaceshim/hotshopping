package randy.web.domain;

import randy.core.spring.domain.AbstractDomain;

public class Category extends AbstractDomain {

	/** 카테고리 아이디 */
	private int cateId;
	/** 부모 카테고리 아이디 */
	private int parentCateId;
	/** 카테고리 명 */
	private String cateName;
	/** 카테고리 토큰 ( 콤마를 구분자로 해당 카테고리에 속하는 문자열을 기술한다. ) */
	private String cateTokens;

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public int getParentCateId() {
		return parentCateId;
	}

	public void setParentCateId(int parentCateId) {
		this.parentCateId = parentCateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateTokens() {
		return cateTokens;
	}

	public void setCateTokens(String cateTokens) {
		this.cateTokens = cateTokens;
	}

}
