package View;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Model.Review;

public class ReviewManagerImpl implements IReviewManager {
    private List<Review> reviewList = new ArrayList<Review>();
    
    private static IReviewManager instance = new ReviewManagerImpl();

    private ReviewManagerImpl() {
    	loadReviewsFromJson("data/review.json");
    }

    public static IReviewManager getInstance() {
        if (instance == null) {
            instance = new ReviewManagerImpl();
        }
        return instance;
    }
    
    @Override
    public List<Review> getReviewList() {
    	List<Review> result = new ArrayList<Review>();
    	
    	for (int i = 0; i < reviewList.size(); i++)
    		result.add(reviewList.get(i));
    	
    	return result;
    }
    
    @Override
    public int insertReview(Review review) {
        reviewList.add(review);
        saveReviewsToJson("data/review.json");
        return review.getReviewNo();
    }
    
    @Override
    public List<Review> selectReview(int videoNo){
    	List<Review> result = new ArrayList<>();
    	
    	for (Review review : reviewList)
    		if (review.getVideoNo() == videoNo)
    			result.add(review);
    	
    	return result;
    }
    
    @Override
    public void loadReviewsFromJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type reviewListType = new TypeToken<ArrayList<Review>>() {}.getType();
            reviewList = gson.fromJson(reader, reviewListType);
            if (reviewList == null) {
                reviewList = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            reviewList = new ArrayList<>();
        }
    }

    @Override
    public void saveReviewsToJson(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(reviewList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}