package com.ssafy.ws.step2;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {
	private List<Movie> movieList = new ArrayList<>();
	
	private static IMovieManager instance = new MovieManagerImpl();
	
	private MovieManagerImpl() {
		
	}
	
	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		movieList.add(movie);
	}

	@Override
	public Movie[] getList() {
		Movie[] result = new Movie[movieList.size()];
		
		for (int i = 0; i < movieList.size(); i++) {
			result[i] = movieList.get(i);
		}
		
		return result;
	
	}

	@Override
	public Movie[] searchByTitle(String title) throws TitleNotFoundException {
		
		List<Movie> tempList = new ArrayList<>();
	
		for (Movie m : movieList) {
			if (m.getTitle().contains(title))
				tempList.add(m);
		}
		
		if (tempList.size() == 0)
			throw new TitleNotFoundException(title);
		
		Movie[] result = new Movie[tempList.size()];
		for (int i = 0; i < tempList.size(); i++) {
			result[i] = tempList.get(i);
		}
		return result;

	}

	@Override
	public Movie[] getMovies() {
		List<Movie> tempList = new ArrayList<Movie>();
		
		for (Movie m : movieList) {
			if (!(m instanceof SeriesMovie))
				tempList.add(m);
		}
		
		Movie[] result = new Movie[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++) {
			result[i] = tempList.get(i);
		}
		
		return result;
		
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		
		List<Movie> tempList = new ArrayList<Movie>();
		
		for (Movie m : movieList) {
			if (m instanceof SeriesMovie)
				tempList.add((SeriesMovie)m);
		}
		
		SeriesMovie[] result = new SeriesMovie[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++) {
			result[i] = (SeriesMovie) tempList.get(i);
		}
		
		return result;
		
	}

	@Override
	public double getRunningTimeAvg() {
		
		double total = 0.0;
		double avg = 0.0;
		
		for (Movie m : movieList) {
			total += m.getRunningTime();
		}
		
		avg = total / movieList.size();
		
		return avg;
		
	}
	
}
