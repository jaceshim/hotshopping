package randy.web.domain;

import randy.core.spring.domain.AbstractDomain;

/**
 * Mall 도메인.
 * 
 * @author jace
 */
public class Mall extends AbstractDomain {

	/** 몰 아이디 */
	private Integer mallId;
	/** 몰 이름 */
	private String mallName;
	/** 몰 URL */
	private String mallUrl;
	/** 스케쥴 주기 */
	private Integer scheduleInterval;

	public Integer getMallId() {
		return mallId;
	}

	public void setMallId(Integer mallId) {
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

	public Integer getScheduleInterval() {
		return scheduleInterval;
	}

	public void setScheduleInterval(Integer scheduleInterval) {
		this.scheduleInterval = scheduleInterval;
	}

}
