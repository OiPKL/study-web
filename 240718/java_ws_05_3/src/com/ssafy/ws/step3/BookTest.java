package com.ssafy.ws.step3;

public class BookTest {

	public static void main(String[] args) {

		Book book1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book book3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		
		System.out.println("*******************도서목록*******************");
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(book3.toString());
		
		BookManager bm = new BookManager();
		
		bm.add(book1);
		bm.add(book2);
		bm.add(book3);

		System.out.println("****************도서조회:21424****************");
		Book[] searchList = bm.searchByIsbn("21424");
		for(Book b : searchList)
			System.out.println(b);
		
		System.out.println("****************도서삭제:21424****************");
		bm.deleteByIsbn("21424");
		
		System.out.println("*******************도서목록*******************");
		Book[] bookList = bm.getList();
		for(Book b : bookList)
			System.out.println(b);
		
	}
}