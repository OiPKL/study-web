package com.ssafy.ws.step3;

/**
 * 모래시계 모양의 숫자 출력하는 클래스
 */
public class DigitTest2 {

	public static void main(String[] args) {
		
		int num = 1;
		
		for (int i = 1; i <= 5; i++) {
			if (i == 1 | i == 5) {
				for (int j = 1; j <= 5; j++) {
					System.out.printf("%4d", num);
					num++;
				}
			} else if (i == 2 | i == 4) {
				System.out.print("    ");
				for (int k = 1; k <= 3; k++) {
					System.out.printf("%4d", num);
					num++;
				}
				System.out.print("    ");
			} else {
				System.out.print("    ");
				System.out.print("    ");
				System.out.printf("%4d", num);
				num++;
				System.out.print("    ");
				System.out.print("    ");
			}
			System.out.print("\n");
		}
	}
}