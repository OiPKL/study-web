package practice_crud.ssafy_09_02_exception;

public class MovieTest {

	public static void main(String[] args) {
		
		IMovieManager mm = MovieManagerImpl.getInstance();

		Movie movie1 = new Movie(1, "Banana", "Kim", "A", 100);
		Movie movie2 = new Movie(2, "Banata", "Tom", "D", 90);
		Movie movie3 = new Movie(3, "BaBaBa", "Jim", "C", 120);
		SeriesMovie Smovie1 = new SeriesMovie(1, "Avengers1", "MM", "X", 135, 1, "good");
		SeriesMovie Smovie2 = new SeriesMovie(2, "Avengers2", "MM", "X", 120, 2, "good");
		
		mm.addMovie(movie1);
		mm.addMovie(movie2);
		mm.addMovie(movie3);
		mm.addMovie(Smovie1);
		mm.addMovie(Smovie2);
		
		System.out.println();
		Movie[] result1 = mm.getList();
		for (Movie m : result1)
			System.out.println(m);
		
		System.out.println();
		try {
			Movie[] result2 = mm.searchByTitle("Avengers");
			for (Movie m : result2)
				System.out.println(m);
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println();
		Movie[] result3 = mm.getMovies();
		for (Movie m : result3)
			System.out.println(m);

		System.out.println();
		SeriesMovie[] result4 = mm.getSeriesMovies();
		for (SeriesMovie m : result4)
			System.out.println(m);
		
		System.out.println();
		System.out.println(mm.getRunningTimeAvg());
		
	}
	
}
