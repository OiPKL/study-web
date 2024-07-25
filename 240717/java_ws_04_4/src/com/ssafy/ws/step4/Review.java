package com.ssafy.ws.step4;

/**
 * 리뷰 정보를 나타내는 클래스
 */
public class Review {
	int reviewId;
	int resId;
	String writer;
	String content;
	
	public Review() {
		
	}
	
	public Review(
		int reviewId,
		int resId,
		String writer,
		String content) {
		
		this.reviewId = reviewId;
		this.resId = resId;
		this.writer = writer;
		this.content = content;
		
	}
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", resId=" + resId + ", writer=" + writer + ", content=" + content + "]";
	}
	
}