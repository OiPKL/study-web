package com.ssafy.ws.step2;

public class MovieManager {
	private Movie[] movieList = new Movie[100];
	private int size = 0;
	
	public void add(Movie movie) {
		
		if(size < 100) {
			movieList[size] = movie;
			size++;
		}
	}
	
	public Movie[] getList() {
		
		Movie[] result = new Movie[size];
		
		for (int i = 0; i < size; i++) {
			result[i] = movieList[i];
		}
		
		return result;
		
	}
	
	public Movie[] searchByTitle(String title) {
		
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title))
				cnt++;
		}
		
		Movie[] result = new Movie[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title))
				result[idx] = movieList[i];
		}
		return result;
		
	}
}
