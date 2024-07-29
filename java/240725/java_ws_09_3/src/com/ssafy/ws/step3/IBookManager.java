package com.ssafy.ws.step3;

public interface IBookManager {
	
	public void addBook(Book book);
	
	public Book[] getList();
	
	public Book[] getBooks();
	
	public Book[] getMagazines();
	
	public void removeByIsbn(String isbn);
	
	public Book searchByIsbn(String isbn);
	
	public Book[] searchByTitle(String title);
	
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
	
	public void buy(String isbn, int quantity) throws ISBNNotFoundException;

	public int getTotalPrice();
	
	public double getPriceAvg();
	
}