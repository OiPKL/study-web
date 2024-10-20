package com.ssafy.ws.dto;

public class Book {
	private int id;
	private String title;
	private String author;

	public Book() {
	}

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("SET ID : " + id);
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		System.out.println("SET TITLE : " + title);
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		System.out.println("SET AUTHOR : " + author);
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

}