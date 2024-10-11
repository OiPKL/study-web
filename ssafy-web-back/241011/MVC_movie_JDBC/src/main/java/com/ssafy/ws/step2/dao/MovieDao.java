package com.ssafy.ws.step2.dao;

import java.util.List;

import com.ssafy.ws.step2.dto.Movie;

public interface MovieDao {
	
	List<Movie> selectAllMovies();
	
	Movie selectOne(String id);
	
	int insertMovie(Movie movie);

	void deleteMovie(String id);
	
	void updateMovie(Movie movie);
}