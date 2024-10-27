package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.service.MovieService;


@RestController
@RequestMapping("/movieapi")
@CrossOrigin("*")
public class MovieRestController {
	
	private final MovieService movieService;
	
	public MovieRestController(MovieService movieService) {
		this.movieService = movieService;
	}

	// GetMapping
	// search(READ)
	@GetMapping("/movie/{title}")
	public ResponseEntity<?> select(@PathVariable("title") String title) {
		
		List<Movie> movies = movieService.search(title);
		
		if (movies == null || movies.size() == 0)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(movies);
	}

	@GetMapping("/movie")
	public ResponseEntity<?> selectAll() {
		
		List<Movie> movies = movieService.selectAll();
		
		if (movies == null || movies.size() == 0)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(movies);
	}

	// PostMapping
	// insert(CREATE)
	@PostMapping("/movie")
	public ResponseEntity<?> insert(@ModelAttribute Movie movie) {
//	public ResponseEntity<?> insert(@RequestBody Movie movie) {
		
		int result = movieService.insert(movie);
		
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}

	// DeleteMapping
	// delete(DELETE)
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		
		int result = movieService.delete(id);
		
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
	}
	
}
