package randy.web.front.support.api;

/**
 * API 응답처리 도메인.
 * 
 * @author jace
 *
 */
public class ApiResult {

	private String status;

	private String message;

	private Object data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
