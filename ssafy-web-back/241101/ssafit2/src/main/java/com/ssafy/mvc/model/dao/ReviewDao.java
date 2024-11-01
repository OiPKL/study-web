package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Review;

public interface ReviewDao {
	public List<Review> selectAllReview(int id);

	public Review selectReview(int id);

	public int insertReview(Review review);

	public int updateReview(Review review);

	public int deleteReview(int id);
}
