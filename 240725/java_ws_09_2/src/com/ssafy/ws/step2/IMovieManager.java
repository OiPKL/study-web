package com.ssafy.ws.step2;

public interface IMovieManager {
	
	public void add(Movie movie);
	
	public Movie[] getList();
	
	public Movie[] searchByTitle(String title) throws TitleNotFoundException;
	
	public Movie[] getMovies();
	
	public SeriesMovie[] getSeriesMovies();
	
	public double getRunningTimeAvg();
	
}