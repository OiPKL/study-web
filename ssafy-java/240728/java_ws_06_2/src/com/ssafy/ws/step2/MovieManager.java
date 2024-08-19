package com.ssafy.ws.step2;

public class MovieManager {
	
	private final int MAX_SIZE = 100;
	private Movie[] movieList;
	private int size = 0;
	
	public MovieManager() {
		movieList = new Movie[MAX_SIZE];
	}
	
	public void addMovie(Movie movie) {
		
		if (size < MAX_SIZE) {
			movieList[size++] = movie;
		}
		
	}
	
	public Movie[] getList() {
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Movie[] result = new Movie[size];
		
		for (int i = 0; i < size; i++) {
			result[i] = movieList[i];
		}
		
		return result;
		
	}
	
	public Movie[] getMovies() {
		
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (!(movieList[i] instanceof SeriesMovie))
				cnt++;
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Movie[] result = new Movie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (!(movieList[i] instanceof SeriesMovie))
				result[idx++] = movieList[i];
		}
		
		return result;
		
	}
	
	public SeriesMovie[] getSeriesMovies() {
		
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i] instanceof SeriesMovie)
				cnt++;
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		SeriesMovie[] result = new SeriesMovie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i] instanceof SeriesMovie)
				result[idx++] = (SeriesMovie) movieList[i];
		}
		
		return result;
		
	}
	
	public Movie[] searchByTitle(String title) {
		
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			// contains 연산자 : String 포함 여부 확인
			// equals 연산자 : String 일치 여부 확인
			// Integer.valueOf(String) : String -> int
			if (movieList[i].getTitle().contains(title))
				cnt++;
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Movie[] result = new Movie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title))
				result[idx++] = movieList[i];
		}
		
		return result;
						
	}
	
	public int getRunningTimeAvg() {
		int total = 0;
		int avg = 0;
		
		for (int i = 0; i < this.size; i++) {
			total += movieList[i].getRunningTime();
		}
		
		avg = total / this.size;
		return avg;
		
	}
	
}
