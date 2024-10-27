package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	private final MovieDao movieDao;
	
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

	@Override
	@Transactional
	public int insert(Movie movie) {
		return movieDao.insert(movie);
	}

	@Override
	@Transactional
	public int delete(int id) {
		return movieDao.delete(id);

	}

	@Override
	public List<Movie> selectAll() {
		return movieDao.selectAll();
	}

	@Override
	public List<Movie> search(String title) {
		return movieDao.search(title);
	}

}
