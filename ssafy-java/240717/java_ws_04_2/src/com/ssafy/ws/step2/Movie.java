package com.ssafy.ws.step2;

public class Movie {
	
	int id;
	String title;
	String director;
	String genre;
	int runningTime;
	
	Movie(){
		
	}
	
	Movie(int id, String title, String director, String genre, int runningTime){
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}
	
	void showInformation() {
		System.out.println("아이디는 " + id);
		System.out.println("제목은 " + title);
		System.out.println("감독은 " + director);
		System.out.println("장르는 " + genre);
		System.out.println("상영시간은 " + runningTime);
	}
	
}