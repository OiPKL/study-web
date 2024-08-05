package practice_crud.ssafy_09_02_exception;

public interface IMovieManager {

	public void addMovie(Movie movie);
	
	public Movie[] getList();
	
	public Movie[] getMovies();
	
	public SeriesMovie[] getSeriesMovies();
	
	public Movie[] searchByTitle(String title) throws TitleNotFoundException;
	
	public double getRunningTimeAvg();
	
}
