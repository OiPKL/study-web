package com.ssafy.ws.step2;

import java.util.Scanner;

public class AppleTree {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] intArr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				intArr[i][j] = sc.nextInt();
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = intArr[i][j];
				
				if ((i-1) >= 0)
					sum += intArr[i-1][j];
				if ((i+1) < N)
					sum += intArr[i+1][j];
				if ((j-1) >= 0)
					sum += intArr[i][j-1];
				if ((j+1) < N)
					sum += intArr[i][j+1];
				
				if (sum > max) max = sum;
			}
		}
		
		System.out.println(max);
		
	}
}
