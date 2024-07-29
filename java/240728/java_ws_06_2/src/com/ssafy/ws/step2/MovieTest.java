package com.ssafy.ws.step2;

public class MovieTest {
	public static void main(String[] args) {
		Movie movie1 = new Movie(1001, "DoDoAvengers", "abcdef", "Horror", 90);
		Movie movie2 = new Movie(1002, "AvengersLetsGo", "bbbbbb", "SF", 100);
		Movie movie3 = new Movie(1003, "GOGOLetsGo", "gggggg", "SF", 110);
		SeriesMovie smovie1 = new SeriesMovie(2003, "Avengers3", "Marvel", "SF", 140, 3, "인피니티워");
		
		MovieManager mm = new MovieManager();
		
		mm.addMovie(movie1);
		mm.addMovie(movie2);
		mm.addMovie(movie3);
		mm.addMovie(smovie1);
		
		System.out.println("---------------------------getList---------------------------");
		Movie[] movieList = mm.getList();
		for (Movie m : movieList)
			System.out.println(m);
		
		System.out.println("--------------------------getMovies--------------------------");
		for (Movie m : mm.getMovies())
			System.out.println(m);
		
		System.out.println("-----------------------getSeriesMovies------------------------");
		for (SeriesMovie sm : mm.getSeriesMovies())
			System.out.println(sm);
		
		System.out.println("-------------------------searchByTitle-------------------------");
		Movie[] searchList1 = mm.searchByTitle("Avengers");
		for (Movie m : searchList1)
			System.out.println(m);
		
		System.out.println("-------------------------searchByTitle-------------------------");
		Movie[] searchList2 = mm.searchByTitle("Revengers");
		for (Movie m : searchList2)
			System.out.println(m);
		
		System.out.println("-----------------------getRunningTimeAvg-----------------------");
		System.out.println("평균 상영시간 : " + mm.getRunningTimeAvg());
	}
}
