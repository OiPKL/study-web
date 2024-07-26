package com.ssafy.ws.step3;

public class ISBNNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String isbn;
	
	public ISBNNotFoundException(String isbn) {
		super(isbn + "고유번호는 존재하지 않습니다.");
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}
}
