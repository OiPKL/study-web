package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.ArticleDao;
import com.ssafy.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao dao;
	
	@Override
	public List<Article> getArticleList() {
		// TODO Auto-generated method stub
		return dao.getArticleList();
	}

}
