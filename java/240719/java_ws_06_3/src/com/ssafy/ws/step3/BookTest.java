package com.ssafy.ws.step3;

public class BookTest {
	public static void main(String[] args) {
		
		Book book1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book book3 = new Book("35355", "Java Master", "소나무", "jaen.kr", 30000, "SW 모델링");
		Magazine magazine1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);
		
		BookManager bm = new BookManager();
		
		bm.addBook(book1);
		bm.addBook(book2);
		bm.addBook(book3);
		bm.addBook(magazine1);
		
		System.out.println("******************** 도서 전체 목록 ********************");
		Book[] totalList1 = bm.getList();
		for (Book b : totalList1)
			System.out.println(b);
		
		System.out.println("******************** 일반 도서 목록 ********************");
		Book[] bookList = bm.getBooks();
		for (Book b : bookList)
			System.out.println(b);
		
		System.out.println("********************** 잡지 목록 **********************");
		Book[] magazineList = bm.getMagazines();
		for (Book b : magazineList)
			System.out.println(b);
		
		System.out.println("******************** 도서 ISBN 검색 ********************");
		Book result1 = bm.searchByIsbn("21425");
		System.out.println(result1);
		
		System.out.println("******************** 도서 Title 검색 ********************");
		Book[] result2 = bm.searchByTitle("Pro22");
		for (Book b : result2)
			System.out.println(b);
		
		System.out.println();
		
		System.out.println("도서 가격 총합: " + bm.getTotalPrice());
		System.out.println("도서 가격 평균: " + bm.getPriceAvg());
		
		System.out.println();
		
		System.out.println("******************** 도서 ISBN 삭제 ********************");
		bm.removeByIsbn("35355");
		
		System.out.println("******************** 도서 전체 목록 ********************");
		Book[] totalList2 = bm.getList();
		for (Book b : totalList2)
			System.out.println(b);
		
	}
}