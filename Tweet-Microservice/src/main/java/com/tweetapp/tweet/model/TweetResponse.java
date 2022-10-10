package com.tweetapp.tweet.model;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class TweetResponse {

	private int code;
	private String message;

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

	public TweetResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public TweetResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TweetResponse [code=" + code + ", message=" + message + "]";
	}

}
