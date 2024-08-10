package practice_crud.ssafy_06_02_inheritance;

public class MovieManager {

	private final int MAX_SIZE = 100;
	private int size = 0;
	
	private Movie[] movieList = new Movie[MAX_SIZE];
	
	public MovieManager() {

	}
	
	public void addMovie(Movie movie) {
		if (size < MAX_SIZE)
			movieList[size++] = movie;
	}
	
	public Movie[] getList() {
		
		Movie[] result = new Movie[size];
		
		for (int i = 0; i < size; i++)
			result[i] = movieList[i];
		
		return result;
		
	}
	
	public Movie[] getMovies() {
		
		int cnt = 0;
		for (int i = 0; i < size; i++)
			if (!(movieList[i] instanceof SeriesMovie))
				cnt++;
		
		Movie[] result = new Movie[cnt];

		int idx = 0;
		for (int i = 0; i < size; i++)
			if (!(movieList[i] instanceof SeriesMovie))
				result[idx++] = movieList[i];
		
		return result;
		
	}
	
	public SeriesMovie[] getSeriesMovies() {
		
		int cnt = 0;
		for (int i = 0; i < size; i++)
			if (movieList[i] instanceof SeriesMovie)
				cnt++;
		
		SeriesMovie[] result = new SeriesMovie[cnt];

		int idx = 0;
		for (int i = 0; i < size; i++)
			if (movieList[i] instanceof SeriesMovie)
				result[idx++] = (SeriesMovie) movieList[i];
		
		return result;
		
	}

	public Movie[] searchByTitle(String title) {
		
		int cnt = 0;
		for (int i = 0; i < size; i++)
			if (movieList[i].getTitle().contains(title))
				cnt++;
		
		Movie[] result = new Movie[cnt];
		
		int idx = 0;
		for (int i = 0; i < size; i++)
			if (movieList[i].getTitle().contains(title))
				result[idx++] = movieList[i];
		
		return result;
		
	}
	
	public double getRunningTimeAvg() {
		
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < size; i++)
			sum += movieList[i].getRunningTime();
		
		avg = (double)sum / size;
		
		return avg;
		
	}
	
}