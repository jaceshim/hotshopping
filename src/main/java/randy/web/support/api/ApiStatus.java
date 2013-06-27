package randy.web.support.api;

public enum ApiStatus {

	/** 에러 */
	SUCCESS("success"),
	/** 성공 */
	ERROR("error");

	private String status;

	private ApiStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
}
