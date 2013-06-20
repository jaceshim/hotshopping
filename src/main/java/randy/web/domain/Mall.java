package randy.web.domain;

import randy.core.spring.domain.AbstractDomain;

/**
 * Mall 도메인.
 * 
 * @author jace
 */
public class Mall extends AbstractDomain {

	/** 몰 아이디 */
	private int mallId;
	/** 몰 이름 */
	private String mallName;
	/** 몰 URL */
	private String mallUrl;
	/** 몰 아이콘 URL */
	private String mallIconUrl;

	public int getMallId() {
		return mallId;
	}

	public void setMallId(int mallId) {
		this.mallId = mallId;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getMallUrl() {
		return mallUrl;
	}

	public void setMallUrl(String mallUrl) {
		this.mallUrl = mallUrl;
	}

	public String getMallIconUrl() {
		return mallIconUrl;
	}

	public void setMallIconUrl(String mallIconUrl) {
		this.mallIconUrl = mallIconUrl;
	}

}
