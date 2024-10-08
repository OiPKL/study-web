package practice_crud.ssafy_07_03_interface;

public interface IBookManager {
	
	public void addBook(Book book);
	
	public Book[] getList();
	
	public Book[] getBooks();
	
	public Book[] getMagazines();
	
	public void removeByIsbn(String isbn);
	
	public Book searchByIsbn(String isbn);
	
	public Book[] searchByTitle(String title);
	
	public int getTotalPrice();
	
	public double getPriceAvg();
	
}