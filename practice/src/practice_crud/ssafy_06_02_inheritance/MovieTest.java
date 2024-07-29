package practice_crud.ssafy_06_02_inheritance;

public class MovieTest {
	
	public static void main(String[] args) {
		
		MovieManager mm = new MovieManager();
		
		Movie movie1 = new Movie(1, "Banana", "Tom", "A", 120);
		Movie movie2 = new Movie(2, "Banata", "Jim", "B", 105);
		SeriesMovie Smovie1 = new SeriesMovie(1, "Avengers1", "Kim", "C", 105, 1, "good");
		SeriesMovie Smovie2 = new SeriesMovie(2, "Avengers2", "Kim", "C", 115, 2, "good");
		
		mm.addMovie(movie1);
		mm.addMovie(movie2);
		mm.addMovie(Smovie1);
		mm.addMovie(Smovie2);
		
		System.out.println("------------------------- getList");
		Movie[] result1 = mm.getList();
		for (Movie m : result1)
			System.out.println(m);

		System.out.println();
		System.out.println("------------------------- getMovies");
		Movie[] result2 = mm.getMovies();
		for (Movie m : result2)
			System.out.println(m);
		
		System.out.println();
		System.out.println("------------------------- getSeriesMovies");
		SeriesMovie[] result3 = mm.getSeriesMovies();
		for (SeriesMovie m : result3)
			System.out.println(m);
		
		System.out.println();
		System.out.println("------------------------- searchByTitle");
		Movie[] result4 = mm.searchByTitle("Avengers");
		for (Movie m : result4)
			System.out.println(m);
		
		System.out.println();
		System.out.println("------------------------- getRunningTimeAvg");
		System.out.println(mm.getRunningTimeAvg());
		
	}
}
