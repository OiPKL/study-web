package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.MovieService;
import com.ssafy.ws.model.service.UserService;


@RestController
@RequestMapping("/movieapi")
@CrossOrigin("*")
public class MovieRestController {
	@Autowired
	MovieService ms;

	@Autowired
	UserService us;

	// GetMapping
	// search(READ)
	@GetMapping("/movie/{title}")
	public ResponseEntity<?> select(@PathVariable String title) {
		return null;
	}

	@GetMapping("/movie")
	public ResponseEntity<?> selectAll() {
		return null;
	}

	// PostMapping
	// insert(CREATE)
	@PostMapping("/movie")
	public ResponseEntity<?> insert(Movie movie, @RequestPart(required = false) MultipartFile file) {
		return null;
	}

	// DeleteMapping
	// delete(DELETE)
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		return null;
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// GetMapping
	// select(READ)
	@GetMapping("/user/{id}")
	public ResponseEntity<?> selectUser(@PathVariable String id) {
		return null;
	}
}
