package crud_08_02_arrayList;

public interface IMovieManager {
	
	public void addMovie(Movie movie);
	
	public Movie[] getList();
	
	public Movie[] getMovies();

	public SeriesMovie[] getSeriesMovies();
	
	public Movie[] searchByTitle(String title);
	
	public double getRunningTimeAvg();
	
}
