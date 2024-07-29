package com.ssafy.ws.step2;

public class MovieTest {
	public static void main(String[] args) {

		Movie movie1 = new Movie(1001, "바나나는 길어", "김씨", "호러", 120);
		Movie movie2 = new Movie(1002, "사과는 빨갈까?", "박씨", "힐링", 135);
		Movie movie3 = new Movie(1003, "비행기는 높아", "홍씨", "SF", 105);
		SeriesMovie sMovie1 = new SeriesMovie(2001, "Avengers1", "마블", "호러", 150, 1, "ABCDEF");
		SeriesMovie sMovie2 = new SeriesMovie(2002, "Avengers2", "마블", "호러", 150, 2, "가나다라마");
		
		IMovieManager mm = MovieManagerImpl.getInstance();
		
		mm.add(movie1);
		mm.add(movie2);
		mm.add(movie3);
		mm.add(sMovie1);
		mm.add(sMovie2);
		
		System.out.println("******************** 영화 전체 목록 ********************");
		Movie[] totalList = mm.getList();
		for (Movie m : totalList)
			System.out.println(m);
		
		System.out.println("******************** 일반 영화 목록 ********************");
		Movie[] movieList = mm.getMovies();
		for (Movie m : movieList)
			System.out.println(m);
		
		System.out.println("******************** 시리즈영화 목록 ********************");
		Movie[] seriesMovieList = mm.getSeriesMovies();
		for (Movie m : seriesMovieList)
			System.out.println(m);
		
		System.out.println("******************* 영화 Title 검색 *******************");
		Movie[] result = mm.searchByTitle("Avengers");
		for (Movie m : result)
			System.out.println(m);
		
		System.out.println();
		System.out.println();
		System.out.println("평균 상영시간: " + mm.getRunningTimeAvg());
		
	}
}