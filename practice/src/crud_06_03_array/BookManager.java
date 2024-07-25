package crud_06_03_array;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] bookList = new Book[MAX_SIZE];
	private int size = 0;

	public BookManager() {
		
	}
	
	public void addBook(Book book) {
		if (size != MAX_SIZE)
			bookList[size++] = book;
	}

	public Book[] getList() {

		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Book[] result = new Book[size];
		
		for (int i = 0; i < size; i++) {
			result[i] = bookList[i];
		}
		
		return result;
		
	}

	public Book[] getBooks() {

		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (!(bookList[i] instanceof Magazine))
				cnt++;
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Book[] result = new Book[cnt];
		
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (!(bookList[i] instanceof Magazine))
				result[idx++] = bookList[i];
		}
		
		return result;
		
	}

	public Book[] getMagazines() {

		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (bookList[i] instanceof Magazine)
				cnt++;
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Book[] result = new Book[cnt];
		
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (bookList[i] instanceof Magazine)
				result[idx++] = bookList[i];
		}
		
		return result;
		
	}

	public void removeByIsbn(String isbn) {

		for (int i = 0; i < size; i++) {
			if (bookList[i].getIsbn().equals(isbn)) {
				for (int j = i; j < size - 1; j++) {
					bookList[j] = bookList[j + 1];
				}
				size--;
				System.out.println("삭제 완료 되었습니다!");
				break;
			}
		}
		
	}

	public Book searchByIsbn(String isbn) {

		for (int i = 0; i < size; i++) {
			// equals() : String 일치 여부 확인
			if (bookList[i].getIsbn().equals(isbn)) {
				return bookList[i];
			}
		}
		
		return null;
		
	}

	public Book[] searchByTitle(String title) {
		
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			// contains() : String 포함 여부 확인
			if (bookList[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Book[] result = new Book[cnt];
		
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (bookList[i].getTitle().contains(title)) {
				result[idx] = bookList[i];
				idx++;
			}
		}
		
		return result;

	}

	public int getTotalPrice() {

		int total = 0;
		for (int i = 0; i < size; i++) {
			total += bookList[i].getPrice();
		}
		
		return total;
		
	}

	public double getPriceAvg() {

		double total = getTotalPrice();
		double avg = 0;
		avg = (double)total / this.size;
		
		return avg;
		
	}
	
}
