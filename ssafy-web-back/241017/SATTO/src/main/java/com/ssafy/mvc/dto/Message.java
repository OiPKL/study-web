package com.ssafy.mvc.dto;

public class Message {
	String status, body;
	
	public Message() {
	}

	public Message(String status, String body) {
		this.status = status;
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Msg [status=" + status + ", body=" + body + "]";
	}
}
