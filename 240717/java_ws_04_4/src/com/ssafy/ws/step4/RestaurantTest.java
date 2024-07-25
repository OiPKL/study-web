package com.ssafy.ws.step4;

/**
 * 맛집 객체를 생성하고 정보를 출력하는 클래스
 */
public class RestaurantTest {
	public static void main(String[] args) {
		Restaurant restaurant1 = new Restaurant(101, "을밀대", "서울", "냉면", 4);
		Restaurant restaurant2 = new Restaurant(410, "도마29", "대구", "연어초밥", 3);
		
		Review review1 = new Review(1, 101, "김싸피", "너무 맛있네요.");
		Review review2 = new Review(2, 401, "나싸피", "연어초밥은 여기가 최고!");
		
		System.out.println("*********************맛집목록*********************");
		System.out.println(restaurant1.toString());
		System.out.println(restaurant2.toString());
		System.out.println("*********************맛집목록*********************");
		System.out.println(review1.toString());
		System.out.println(review2.toString());
		
	}
}
