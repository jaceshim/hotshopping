package randy.web.support.api;

public enum ApiStatus {

	/** 성공 */
	SUCCESS("success"),
	/** 에러 */
	ERROR("error");

	private String status;

	private ApiStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
}
