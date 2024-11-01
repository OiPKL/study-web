package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Review;
import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.ReviewService;

import jakarta.servlet.http.HttpSession;

/*
 * 1. 세션에 저장된 유저와 작성자가 같은지는 Controller와 Service중 어디서 확인할까
 */

@RestController
@RequestMapping("/review")
public class ReviewController {
	private final ReviewService rService;

	public ReviewController(ReviewService rService) {
		this.rService = rService;
	}

	@GetMapping("/list/{id}")
	public ResponseEntity<List<Review>> reviews(@PathVariable("id") int id) {
		List<Review> reviews = rService.getReviews(id);

		if (reviews == null || reviews.size() == 0) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(reviews);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> regist(@RequestBody Review review) {
		boolean success = rService.addReview(review);

		if (success) {
			return ResponseEntity.ok("리뷰가 등록되었습니다");
		}

		return ResponseEntity.internalServerError().body("리뷰 등록에 실패했습니다");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> modify(@PathVariable("id") int id, @RequestBody Review review, HttpSession session) {
		String userId = ((User) session.getAttribute("loginUser")).getUserId();
		boolean success = rService.modifyReview(review, id, userId);

		if (success) {
			return ResponseEntity.ok("리뷰가 수정되었습니다");
		}

		return ResponseEntity.internalServerError().body("리뷰 수정에 실패했습니다");
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Review> reivew(@PathVariable("id") int id) {
		Review review = rService.getReview(id);

		if (review == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(review);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id, HttpSession session) {
		String userId = ((User) session.getAttribute("loginUser")).getUserId();
		boolean success = rService.removeReview(id, userId);

		if (success) {
			return ResponseEntity.ok("리뷰가 삭제되었습니다");
		}

		return ResponseEntity.internalServerError().body("리뷰 삭제에 실패했습니다");
	}
}
