package com.ssafy.ws.step3;

public class BookTest {
	public static void main(String[] args) {

		Book book1 = new Book("10001", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본", 10);
		Book book2 = new Book("10002", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20);
		Book book3 = new Book("10003", "Java Master", "소나무", "jaen.kr", 30000, "SW 모델링", 10);
		Magazine magazine1 = new Magazine("20001", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월알고", 10, 2024, 1);
		Magazine magazine2 = new Magazine("20002", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "2월알고", 20, 2024, 2);
	
		IBookManager bm = BookManagerImpl.getInstance();
		
		bm.addBook(book1);
		bm.addBook(book2);
		bm.addBook(book3);
		bm.addBook(magazine1);
		bm.addBook(magazine2);
		
		System.out.println("******************** 도서 전체 목록 ********************");
		Book[] totalList1 = bm.getList();
		for (Book b : totalList1)
			System.out.println(b);
		
		System.out.println("******************** 일반 도서 목록 ********************");
		Book[] bookList = bm.getBooks();
		for (Book b : bookList)
			System.out.println(b);
		
		System.out.println("******************** 잡지 도서 목록 ********************");
		Book[] magazineList = bm.getMagazines();
		for (Book b : magazineList)
			System.out.println(b);
		
		System.out.println("******************** 도서 ISBN 검색 *******************");
		Book result1 = bm.searchByIsbn("10003");
		System.out.println(result1);
		
		System.out.println("******************** 도서 제목 검색 ********************");
		Book[] result2 = bm.searchByTitle("Master");
		for (Book b : result2)
			System.out.println(b);
		
		System.out.println("******************** 도서 제목 검색 ********************");
		Book[] result3 = bm.searchByTitle("Python");
		for (Book b : result3)
			System.out.println(b);

		System.out.println();
		System.out.println();
		
		System.out.println("도서 가격 총합: " + bm.getTotalPrice());
		System.out.println("도서 가격 평균: " + bm.getPriceAvg());
		
		System.out.println();
		System.out.println();
		
		System.out.println("******************** 도서 ISBN 삭제 *******************");
		bm.removeByIsbn("10003");
		
		System.out.println("******************** 도서 전체 목록 ********************");
		Book[] totalList2 = bm.getList();
		for (Book b : totalList2)
			System.out.println(b);
		
		System.out.println();
		System.out.println();
		
		System.out.println("******************** 도서 판매 : 10 *******************");
		try {
			bm.sell("10002", 10);		// 20 -> 10
		} catch (ISBNNotFoundException | QuantityException e) {
			e.printStackTrace();
		}
		
		Book result4 = bm.searchByIsbn("10002");
		System.out.println(result1);
		
		System.out.println("******************** 도서 구매 : 20 *******************");
		try {
			bm.buy("10002", 20);		// 10 -> 30
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}
		
		Book result5 = bm.searchByIsbn("10002");
		System.out.println(result1);
		
		System.out.println("******************** 도서 판매 : 30 *******************");
		try {
			bm.sell("10002", 50);		// 30 -> -1
		} catch (ISBNNotFoundException | QuantityException e) {
			e.printStackTrace();
		}
		
		Book result6 = bm.searchByIsbn("10002");
		System.out.println(result1);
		
	}
}