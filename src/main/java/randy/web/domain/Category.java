package randy.web.domain;

import java.util.List;

import randy.core.j2ee.domain.AbstractDomain;

/**
 * 카테고리 도메인.
 * 
 * @author jace
 */
public class Category extends AbstractDomain {

	/** 카테고리 태그 목록 */
	private List<CategoryTag> cateTagList;

	/** 카테고리 아이디 */
	private Integer cateId;
	/** 부모 카테고리 아이디 */
	private Integer pcateId;
	/** 카테고리 명 */
	private String cateName;
	/** 사용여부 */
	private String useYn;
	/** tree구조 표현시 레벨 */
	private int level;

	public List<CategoryTag> getCateTagList() {
		return cateTagList;
	}

	public void setCateTagList(List<CategoryTag> cateTagList) {
		this.cateTagList = cateTagList;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public Integer getPcateId() {
		return pcateId;
	}

	public void setPcateId(Integer pcateId) {
		this.pcateId = pcateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
