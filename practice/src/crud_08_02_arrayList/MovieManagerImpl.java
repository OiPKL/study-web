package crud_08_02_arrayList;

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
	public void addMovie(Movie movie) {

		movieList.add(movie);
		
	}

	@Override
	public Movie[] getList() {
		
		Movie[] result = new Movie[movieList.size()];
		
		for (int i = 0; i < movieList.size(); i++)
			result[i] = movieList.get(i);
		
		return result;
		
	}

	@Override
	public Movie[] getMovies() {
		
		List<Movie> tempList = new ArrayList<>();
		
		for (Movie m : movieList)
			if (!(m instanceof SeriesMovie))
				tempList.add(m);
		
		Movie[] result = new Movie[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++)
			result[i] = movieList.get(i);
		
		return result;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		
		List<Movie> tempList = new ArrayList<>();
		
		for (Movie m : movieList)
			if (m instanceof SeriesMovie)
				tempList.add(m);
		
		SeriesMovie[] result = new SeriesMovie[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++)
			result[i] = (SeriesMovie)movieList.get(i);
		
		return result;
	}

	@Override
	public Movie[] searchByTitle(String title) {

		List<Movie> tempList = new ArrayList<>();
		
		for (Movie m : movieList)
			if (m.getTitle().contains(title))
				tempList.add(m);
		
		Movie[] result = new Movie[tempList.size()];
		
		for (int i = 0; i < tempList.size(); i++)
			result[i] = movieList.get(i);
		
		return result;
	}

	@Override
	public double getRunningTimeAvg() {
		
		int sum = 0;
		double avg = 0.0;
		
		for (Movie m : movieList)
			sum += m.getRunningTime();
		
		avg = (double)sum / movieList.size();
		return avg;
		
	}

}
