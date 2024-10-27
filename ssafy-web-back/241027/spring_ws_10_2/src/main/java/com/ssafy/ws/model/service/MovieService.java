package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;

public interface MovieService {

	int insert(Movie movie);

	int delete(int id);

	List<Movie> search(String title);

	List<Movie> selectAll();
}
