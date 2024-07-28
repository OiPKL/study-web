package com.ssafy.ws.step2;

public interface IMovieManager {
	
	public boolean add(Movie movie);
	
	public Movie[] getList();
	
	public Movie[] searchByTitle(String title);
	
	public Movie[] getMovies();
	
	public SeriesMovie[] getSeriesMovies();
	
	public double getRunningTimeAvg();
	
}
