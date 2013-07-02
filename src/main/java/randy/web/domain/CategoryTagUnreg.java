package randy.web.domain;

import randy.core.spring.domain.AbstractDomain;

/**
 * 카테고리 미 등록 태그.
 * 
 * @author jace
 */
public class CategoryTagUnreg extends AbstractDomain {

	/** 순번 */
	private Integer seq;
	/** 미등록 태그를 발생시킨 상푼순번 */
	private Integer prdSeq;
	/** 몰 아이디 */
	private Integer mallId;
	/** 상품명 */
	private String prdName;
	/** 태그 */
	private String tag;
	/** 처리여부 */
	private String procYn;
	/** 등록일시 */
	private String regDt;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getPrdSeq() {
		return prdSeq;
	}

	public void setPrdSeq(Integer prdSeq) {
		this.prdSeq = prdSeq;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getProcYn() {
		return procYn;
	}

	public void setProcYn(String procYn) {
		this.procYn = procYn;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

}
