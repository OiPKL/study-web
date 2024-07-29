package com.ssafy.ws.step2;

public class MovieTest {

	public static void main(String[] args) {
		
		Movie movie1 = new Movie(1, "ABC", "abc", "SF", 120);
		Movie movie2 = new Movie(2, "DEF", "def", "Adventure", 100);
		
		System.out.println("-------------toStirng-------------");
		System.out.println(movie1);
		System.out.println(movie2);
		
		MovieManager mm = new MovieManager();
		
		mm.add(movie1);
		mm.add(movie2);
		
		System.out.println("-------------getList-------------");
		Movie[] movieList = mm.getList();
		for(Movie m : movieList)
			System.out.println(m);
		
		System.out.println("-------------searchByTitle(ABC가 들어가는 제목)-------------");
		Movie[] searchList = mm.searchByTitle("ABC");
		for(Movie m : searchList)
			System.out.println(m);
		
	}
}
