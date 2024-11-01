package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.ReviewDao;
import com.ssafy.mvc.model.dto.Review;

@Service
public class ReviewService {
	private final ReviewDao reviewDao;

	public ReviewService(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	public List<Review> getReviews(int id) {
		return reviewDao.selectAllReview(id);
	}

	public Review getReview(int id) {
		return reviewDao.selectReview(id);
	}

	public boolean addReview(Review review) {
		try {
			int res = reviewDao.insertReview(review);
			return res == 1;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean modifyReview(Review review, int reviewId, String userId) {
		if (review.getReviewId() != reviewId || review.getUserId() != userId) {
			return false;
		}

		try {
			int res = reviewDao.updateReview(review);
			return res == 1;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeReview(int reviewId, String userId) {
		Review review = reviewDao.selectReview(reviewId);

		if (review == null || review.getUserId() != userId) {
			return false;
		}

		try {
			int res = reviewDao.deleteReview(reviewId);
			return res == 1;
		} catch (Exception e) {
			return false;
		}
	}
}
