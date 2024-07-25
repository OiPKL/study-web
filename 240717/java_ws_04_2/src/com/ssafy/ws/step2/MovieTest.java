package com.ssafy.ws.step2;

public class MovieTest {

	public static void main(String[] args) {
		Movie movie1 = new Movie();
		
		movie1.showInformation();
		
		Movie movie2 = new Movie(1, "ABC", "Tom", "Action", 240);
		
		movie2.showInformation();
	}

}
