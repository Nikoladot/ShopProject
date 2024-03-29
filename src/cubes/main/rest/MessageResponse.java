package cubes.main.rest;


public class MessageResponse {
	
	private int code;
	private String message;
	private long time;
	
	
	public MessageResponse() {
		
	}

	public MessageResponse(int code, String message, long time) {
		
		this.code = code;
		this.message = message;
		this.time = time;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		
		return message+"-"+code;
	}

}
