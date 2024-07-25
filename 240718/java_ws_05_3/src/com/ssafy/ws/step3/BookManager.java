package com.ssafy.ws.step3;

public class BookManager {
	
	private Book[] bookList = new Book[100];
	private int size = 0;
	
	public void add(Book book) {
		
		if (size < 100) {
			bookList[size] = book;
			size++;
		}

	}

	public Book[] getList() {
		
		Book[] result = new Book[size];
		
		for (int i = 0; i < size; i++) {
			result[i] = bookList[i];
		}
		
		return result;
		
	}
	
	public void deleteByIsbn(String isbn) {
		
		Book[] result = new Book[size-1];
		
		for (int i = 0; i < size - 1; i++) {
			if (i == Integer.valueOf(isbn)) continue;
			result[i] = bookList[i];
		}
		
	}
	
	public Book[] searchByIsbn(String isbn) {
		
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			// 05_1 model 포함 여부 => contains(modelName) 사용
			if (bookList[i].getIsbn().equals(isbn))
				cnt++;
		}
		
		Book[] result = new Book[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (bookList[i].getIsbn().equals(isbn))
				result[idx] = bookList[i];
		}
		
		return result;
		
	}
	
}
