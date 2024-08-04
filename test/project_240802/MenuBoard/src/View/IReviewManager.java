package View;

import java.util.List;

import Model.Review;

public interface IReviewManager {
	
	List<Review> getReviewList();
	
	int insertReview(Review review);

	List<Review> selectReview(int videoNo);
	
	void loadReviewsFromJson(String filePath);
	
	void saveReviewsToJson(String filePath);

}
