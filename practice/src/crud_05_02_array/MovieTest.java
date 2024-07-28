package crud_05_02_array;

public class MovieTest {

		public static void main(String[] args) {
		
		MovieManager mm = new MovieManager();
		
		Movie movie1 = new Movie(1, "Banada", "Tom", "A", 120);
		Movie movie2 = new Movie(2, "Banata", "John", "B", 105);
		Movie movie3 = new Movie(3, "Apple", "Jim", "C", 135);

		System.out.println("--------------------- addMovie");
		mm.addMovie(movie1);
		mm.addMovie(movie2);
		mm.addMovie(movie3);
		
		System.out.println();
		System.out.println("--------------------- getMovie");
		Movie[] result1 = mm.getMovie();
		for (Movie m : result1)
			System.out.println(m);
		
		System.out.println();
		System.out.println("--------------------- searchByTitle : Bana");
		Movie[] result2 = mm.searchByTitle("Bana");
		for (Movie m : result2)
			System.out.println(m);
		
		}
}
