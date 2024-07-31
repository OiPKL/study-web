package test_02;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 조건에 맞는 N을 입력받을때까지 다시 입력
		int N;
		while (true) {
			N = sc.nextInt();
			if (N >= 5 & N <= 99 & (N%2)!=0) {
				break;
			}
		}
		
		// 첫째줄
		for (int j = 0; j < N; j++)
			System.out.print("+");
		System.out.println();
		
		// 둘째줄 ~ 가운데줄
		for (int i = 2; i <= (N/2)+1; i++) {
			for (int j = 0; j < (N/2)-i+2; j++)
				System.out.print("+");
			for (int j = 0; j < 2*(i-1)-1; j++)
				System.out.print(" ");
			for (int j = 0; j < (N/2)-i+2; j++)
				System.out.print("+");
		System.out.println();
		}
		
		// 가운데+1번째줄 ~ 마지막-1번째줄
		for (int i = (N/2); i >= 2; i--) {
			for (int j = 0; j < (N/2)-i+2; j++)
				System.out.print("+");
			for (int j = 0; j < 2*(i-1)-1; j++)
				System.out.print(" ");
			for (int j = 0; j < (N/2)-i+2; j++)
				System.out.print("+");
		System.out.println();
		}
		
		// 마지막줄
		for (int j = 0; j < N; j++)
			System.out.print("+");
		System.out.println();
		
		sc.close();
		
	}
}
