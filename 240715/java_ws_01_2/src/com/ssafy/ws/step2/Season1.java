package com.ssafy.ws.step2;

import java.util.Scanner;

public class Season1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (;;) {
			System.out.print("월을 입력하세요: ");
			int month = sc.nextInt();
			
			if (month >= 3 & month <= 5) {
				System.out.println(month + "월은 봄입니다");
			} else if (month >= 6 & month <= 8) {
				System.out.println(month + "월은 여름입니다");
			} else if (month >= 9 & month <= 11) {
				System.out.println(month + "월은 가을입니다");
			} else if (month == 12 | month <= 2) {
				System.out.println(month + "월은 겨울입니다");
			} else {
				System.out.println("다시 입력하세요");
			}
		}
	}

}
