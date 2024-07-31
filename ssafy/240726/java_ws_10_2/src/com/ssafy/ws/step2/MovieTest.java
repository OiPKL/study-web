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
		for (Movie m : mm.getList())
			System.out.println(m);
		
		System.out.println("******************** 일반 영화 목록 ********************");
		for (Movie m : mm.getMovies())
			System.out.println(m);
		
		System.out.println("******************** 시리즈영화 목록 ********************");
		for (Movie m : mm.getSeriesMovies())
			System.out.println(m);
		
		System.out.println("******************* 영화 Title 검색 *******************");
		
		try {
			for (Movie m : mm.searchByTitle("Avengers")) {
				System.out.println(m);
			}
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("******************* 영화 Title 검색 *******************");
		
		try {
			for (Movie m : mm.searchByTitle("Superman")) {
				System.out.println(m);
			}
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("평균 상영시간: " + mm.getRunningTimeAvg());
		
		System.out.println();
		System.out.println();
		mm.saveData();
		
	}
}