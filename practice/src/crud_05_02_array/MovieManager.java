package crud_05_02_array;

public class MovieManager {

	private final int MAX_SIZE = 100;
	private int size = 0;
	
	private Movie[] movieList = new Movie[MAX_SIZE];
	
	public void addMovie(Movie movie) {
		
		if (size < MAX_SIZE)
			movieList[size++] = movie;
		
	}
	
	public Movie[] getMovie() {
		
		Movie[] result = new Movie[size];
		
		for (int i = 0; i < size; i++)
			result[i] = movieList[i];

		return result;
		
	}
	
	public Movie[] searchByTitle(String title) {
		
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().contains(title))
				cnt++;
		}
		
		Movie[] result = new Movie[cnt];
		
		int idx = 0;
		for (int i = 0; i < cnt; i++) {
			if (movieList[i].getTitle().contains(title))
				result[idx++] = movieList[i];
		}
		
		return result;
	}
	
}
