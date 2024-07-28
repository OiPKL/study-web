package com.ssafy.ws.step2;

public class MovieManagerImpl implements IMovieManager {
	private final int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	
	// 싱글턴 패턴
	private static MovieManagerImpl instance = new MovieManagerImpl();
	
	// 외부에서 객체 생성을 하지 못하도록 private 선언
	private MovieManagerImpl() {
		
	}
	
	// 내부에서 생성한 객체의 참조를 반환
	public static IMovieManager getInstance() {
		return instance;
	}
	
	@Override
	public boolean add(Movie movie) {
		
		if (size != MAX_SIZE) {
			movieList[size++] = movie;
			return true;
		}
		return false;
		
	}
	
	@Override
	public Movie[] getList() {
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Movie[] result = new Movie[size];
		
		for (int i = 0; i < this.size; i++) {
			result[i] = movieList[i];
		}
		
		return result;
		
	}
	
	@Override
	public Movie[] searchByTitle(String title) {
		
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			// contains() : String 포함 여부 확인
			if (movieList[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		
		// 기존의 배열은 바뀌지 않도록 새로운 배열을 생성!!
		Movie[] result = new Movie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				result[idx] = movieList[i];
				idx++;
			}
		}
		
		return result;
		
	}
	
	@Override
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

	
	@Override
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

	
	@Override
	public double getRunningTimeAvg() {
		
		double total = 0.0;
		double avg = 0.0;
		
		for (int i = 0; i < this.size; i++) {
			total += movieList[i].getRunningTime();
		}
		
		avg = total / this.size;
		
		return avg;
		
	}

	
}
