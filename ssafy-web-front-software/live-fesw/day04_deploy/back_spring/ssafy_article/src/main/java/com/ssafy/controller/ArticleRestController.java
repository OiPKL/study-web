package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Article;
import com.ssafy.model.service.ArticleService;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
	
	@Autowired
	ArticleService as;
	
	@GetMapping("/list")
	public ResponseEntity<?> getArticleList() {
		try {
			List<Article> al = as.getArticleList();
			System.out.println(al);
			return new ResponseEntity<List<Article>> (al, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
