package com.ssafy.ws.step1;

import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;

		System.out.print("숫자를 입력하세요: ");
		num = sc.nextInt();
		
		sc.close();
		int ans = 0;
		
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				ans += i;
			}
		}
		
		System.out.println(ans);
		
	}

}