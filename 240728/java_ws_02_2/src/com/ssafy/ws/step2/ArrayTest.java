package com.ssafy.ws.step2;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numArray = new int[] {1, 3, 5, 4, 2, 5, 4, 3, 2, 3};
		
		for (int num : numArray) {
			System.out.print(num);
		}
		System.out.println();

		System.out.print("숫자 n 입력: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] strArray = new String[n];
		
		for (int i = 0; i < strArray.length; i++) {
			System.out.print((i+1) + " 번째 - 총 " + strArray.length + "개 입력: ");
			strArray[i] = sc.nextLine();
		}
		
		for (String str : strArray) {
			System.out.println(str);
		}
		
	}
}
