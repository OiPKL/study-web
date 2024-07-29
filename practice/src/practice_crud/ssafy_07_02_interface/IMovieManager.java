package practice_crud.ssafy_07_02_interface;

public interface IMovieManager {

	public void addMovie(Movie movie);
	
	public Movie[] getList();
	
	public Movie[] searchByTitle(String title);
	
	public Movie[] getMovies();
	
	public SeriesMovie[] getSeriesMovies();
	
	public double getRunningTimeAvg();
	
}
