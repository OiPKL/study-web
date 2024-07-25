package com.ssafy.hw.step4;

import java.util.Scanner;

public class DayCount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("월과 일을 입력하세요: ");
		int month = sc.nextInt();
		int day = sc.nextInt();
		int tmp = 0;
		int ans = 0;
		
		sc.close();

		switch (month) {
		case 1:
			tmp = 0;
			ans = tmp + day;
			break;
		case 2:
			tmp = 31;
			ans = tmp + day;
			break;
		case 3:
			tmp = 31 + 28;
			ans = tmp + day;
			break;
		case 4:
			tmp = 31 + 28 + 31;
			ans = tmp + day;
			break;
		case 5:
			tmp = 31 + 28 + 31 + 30;
			ans = tmp + day;
			break;
		case 6:
			tmp = 31 + 28 + 31 + 30 + 31;
			ans = tmp + day;
			break;
		case 7:
			tmp = 31 + 28 + 31 + 30 + 31 + 30;
			ans = tmp + day;
			break;
		case 8:
			tmp = 31 + 28 + 31 + 30 + 31 + 30 + 31;
			ans = tmp + day;
			break;
		case 9:
			tmp = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
			ans = tmp + day;
			break;
		case 10:
			tmp = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
			ans = tmp + day;
			break;
		case 11:
			tmp = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
			ans = tmp + day;
			break;
		case 12:
			tmp = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
			ans = tmp + day;
			break;
		default:
			System.out.println("다시 입력하세요");
		}
		System.out.println(month + "월 " + day + "일은 " + ans + "번째 날입니다");
		
	}

}
