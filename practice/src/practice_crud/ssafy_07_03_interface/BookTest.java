package practice_crud.ssafy_07_03_interface;

public class BookTest {
	public static void main(String[] args) {
		
		IBookManager bm = BookManagerImpl.getInstance();

		Book book1 = new Book("10001", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("10002", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book book3 = new Book("10003", "Java Master", "소나무", "jaen.kr", 30000, "SW 모델링");
		Magazine magazine1 = new Magazine("20001", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2024, 1);
		Magazine magazine2 = new Magazine("20002", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "2월 알고리즘", 2024, 2);
		
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
		
		System.out.println();
		
		System.out.println("******************** 도서 ISBN 검색 *******************");
		Book resultF1 = bm.searchByIsbn("99999");
		System.out.println(resultF1);
		
		System.out.println("******************** 도서 ISBN 검색 *******************");
		Book resultT1 = bm.searchByIsbn("10003");
		System.out.println(resultT1);
		
		System.out.println();
		
		System.out.println("******************** 도서 제목 검색 ********************");
		Book[] resultF2 = bm.searchByTitle("Python");
		for (Book b : resultF2)
			System.out.println(b);
		
		System.out.println("******************** 도서 제목 검색 ********************");
		Book[] resultT2 = bm.searchByTitle("Master");
		for (Book b : resultT2)
			System.out.println(b);

		System.out.println();
		System.out.println();
		
		System.out.println("도서 가격 총합: " + bm.getTotalPrice());
		System.out.println("도서 가격 평균: " + bm.getPriceAvg());
		
		System.out.println();
		System.out.println();
		
		System.out.println("******************** 도서 ISBN 삭제 *******************");
		bm.removeByIsbn("99999");
		
		System.out.println("******************** 도서 ISBN 삭제 *******************");
		bm.removeByIsbn("10003");
		
		System.out.println();
		
		System.out.println("******************** 도서 전체 목록 ********************");
		Book[] totalList2 = bm.getList();
		for (Book b : totalList2)
			System.out.println(b);
		
	}
}
