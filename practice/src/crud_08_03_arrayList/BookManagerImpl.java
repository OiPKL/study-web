package crud_08_03_arrayList;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private List<Book> bookList = new ArrayList<>();
	
	// 싱글턴 패턴
	private static IBookManager instance = new BookManagerImpl();
	
	// 외부에서 객체 생성을 하지 못하도록 private 선언
	private BookManagerImpl() {
		
	}
	
	// 내부에서 생성한 인스턴스의 참조를 반환
	public static IBookManager getInstance() {
		return instance;
	}
	
	@Override
	public void addBook(Book book) {
		bookList.add(book);
	}

	@Override
	public Book[] getList() {
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Book[] result = new Book[bookList.size()];
		
		for (int i = 0; i < bookList.size(); i++) {
			result[i] = bookList.get(i);
		}
		
		return result;
		
	}

	@Override
	public Book[] getBooks() {
		
		List<Book> tempList = new ArrayList<Book>();
		
		for (Book b : bookList) {
			if (!(b instanceof Magazine))
				tempList.add(b);
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Book[] result = new Book[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++) {
			result[i] = tempList.get(i);
		}
		
		return result;
		
	}

	@Override
	public Book[] getMagazines() {
		
		List<Book> tempList = new ArrayList<Book>();
		
		for (Book b : bookList) {
			if (b instanceof Magazine)
				tempList.add((Magazine)b);
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Magazine[] result = new Magazine[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++) {
			result[i] = (Magazine)tempList.get(i);
		}
		
		return result;
		
	}

	@Override
	public void removeByIsbn(String isbn) {
		
		for (int i = bookList.size() - 1; i >= 0; i--) {
			if(bookList.get(i).getIsbn().equals(isbn)) {
				bookList.remove(i);
				System.out.println("삭제 완료 되었습니다!");
				break;
			}
		}
		
	}

	@Override
	public Book searchByIsbn(String isbn) {
		
		for (Book b : bookList) {
			// equals() : String 일치 여부 확인
			if (b.getIsbn().equals(isbn))
				return b;
		}
		
		return null;
		
	}

	@Override
	public Book[] searchByTitle(String title) {
		
		List<Book> tempList = new ArrayList<>();
		
		for (Book b : bookList) {
			// contains() : String 포함 여부 확인
			if (b.getTitle().contains(title)) {
				tempList.add(b);
			}
		}
	
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Book[] result = new Book[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++) {
			result[i] = tempList.get(i);
		}
		
		return result;
		
	}

	@Override
	public int getTotalPrice() {
		
		int total = 0;
		for (Book b : bookList) {
			total += b.getPrice();
		}
		
		return total;
		
	}

	@Override
	public double getPriceAvg() {

		double total = getTotalPrice();
		double avg = 0;
		avg = (double)total / bookList.size();
		
		return avg;
		
	}
}
