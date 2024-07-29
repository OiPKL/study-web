package com.ssafy.ws.step3;

/**
 * 직각삼각형 모양의 숫자 출력하는 클래스
 */
public class DigitTest1 {

	public static void main(String[] args) {

		int num = 1;
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i - 1; j++) {
				System.out.print("    ");
			}
			for (int k = 1; k <= 6 - i; k++) {
				System.out.printf("%4d", num);
				num++;
			}
			System.out.print("\n");
		}
	}
}