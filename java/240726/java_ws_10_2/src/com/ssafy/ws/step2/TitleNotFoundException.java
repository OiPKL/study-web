package com.ssafy.ws.step2;

public class TitleNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String title;
	
	public TitleNotFoundException(String title) {
		super(title + " 제목을 포함하는 영화가 존재하지 않습니다.");
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}

}
