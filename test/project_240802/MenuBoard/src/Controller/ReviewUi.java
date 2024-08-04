package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Review;
import Model.User;
import View.IReviewManager;
import View.IUserManager;
import View.ReviewManagerImpl;
import View.UserManagerImpl;

public class ReviewUi {
    private static ReviewUi instance;

    private ReviewUi() {}
    
    public static ReviewUi getInstance() {
        if (instance == null) {
            instance = new ReviewUi();
        }
        return instance;
    }

	public static IUserManager um = UserManagerImpl.getInstance();
	public static IReviewManager rm = ReviewManagerImpl.getInstance();
	public static List<User> userList;
    public static List<Review> reviewList;
    
    static {
    	rm.loadReviewsFromJson("data/review.json");
    	reviewList = rm.getReviewList();
    }
    
    static int reviewNo = reviewList.size() + 1;
    
    public static int 리뷰상세화면(int videoNo) {
    	List<Review> result = new ArrayList<>();
    	result = rm.selectReview(videoNo);
    	
    	Util.printLine();
    	System.out.println("영상리뷰 : " + result.size() + "개");
    	Util.printLine();
    	
    	for(Review r : result)
    		System.out.println(" " + r.getReviewNo() + " " + r.getNickName() + " " + r.getContent());
    	
    	return videoNo;
    }
    
    public static void 리뷰메뉴화면(int videoNo, String nickname) {
    	Util.printLine();
    	System.out.println("1. 리뷰등록");
    	System.out.println("0. 이전으로");
    	Util.printLine();
    	int menu = Util.inputInt("메뉴를 선택하세요: ");
    	
		switch (menu) {
	    	case 1: 
	    		리뷰등록화면(videoNo);
	    		break;
	    	case 0:
	    		VideoUi.영상정보메인화면(nickname);
	    		break;
	    	default:
	            System.out.println("다시 고르세요");
	            리뷰메뉴화면(videoNo, nickname);
	            break;
		}
    }
    
    public static void 리뷰등록화면(int videoNo) {

    	String nickName = "";
    	for (User user : um.getUserList()) {
    		if (user.isLogin() == true) {
    			nickName = user.getNickName();
    			break;
    		}
    	}
    	
    	String content = Util.input("리뷰 내용을 입력하세요: ");
    	
    	Review newReview = new Review();
    	
    	newReview.setReviewNo(reviewNo++);
		newReview.setVideoNo(videoNo);
		newReview.setNickName(nickName);
		newReview.setContent(content);
    	
    	rm.insertReview(newReview);
    	System.out.println("리뷰가 성공적으로 등록되었습니다");
    	VideoUi.영상정보메인화면(nickName);
    }
	
}
