package com.ssafy.hw.step4;

import java.util.Scanner;

public class SpiderWeb {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		// n * n 크기 배열 선언 ( 지도 )
		int[][] map = new int[n][n];
		
		// 지도 정보 입력 받기
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int maxWeb = 0;
		int maxI = 0;
		int maxJ = 0;
		int web;
		
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				
				if ( map[i][j] == 0 ) {
					
					web = 1;
					
					// 동쪽
					for (int d = 1; d <= n - i - 1; d++) {
						if (i <= n - 2) {
							if (map[i+d][j] == 1) {
							} else web++;
						}
					}
					
					if (maxWeb != Math.max(maxWeb, web)) {
						maxWeb = Math.max(maxWeb, web);
						maxI = i;
						maxJ = j;
					}
					
//					// 서쪽
//					for (int d = 1; d <= i; d++) {
//						if (i >= 1) {
//							if (map[i-d][j] == 0) {
//								web++;
//							} else {
//								if (map[i+d][j] == 1) break;
//								else continue;
//							}
//						} else break;
//					}
//					
//					// 북쪽					
//					for (int d = 1; d <= j; d++) {
//						if (j >= 1) {
//							if (map[i][j-d] == 0) {
//								web++;
//							} else {
//								if (map[i][j-d] == 1) break;
//								else continue;
//							}
//						} else break;
//					}
//					
//					// 남쪽
//					for (int d = 1; d <= n - j - 1; d++) {
//						if (j <= n - 2) {
//							if (map[i][j+d] == 0) {
//								web++;
//							} else {
//								if (map[i][j+d] == 1) break;
//								else continue;
//							}
//						} else break;
//					}
//					
//					// 북동쪽
//					for (int d = 1; d <= Math.min(n-i-1, j); d++) {
//						if (i <= n - 2 && j >= 1 && map[i+d][j-d] == 0) {
//							web++;
//						} else {
//							if (i > n - 2 ^ j < 1 ^ map[i+d][j-d] == 1) {
//								break;
//							}
//						}
//					}
//					
//					// 북서쪽
//					for (int d = 1; d <= Math.min(i, j); d++) {
//						if (i >= 1 && j >= 1 && map[i-d][j-d] == 0) {
//							web++;
//						} else {
//							if (i < 1 ^ j < 1 ^ map[i-d][j-d] == 1) {
//								break;
//							}
//						}
//					}
//					
//					// 남동쪽
//					for (int d = 1; d <= Math.min(n-i-1, n-j-1); d++) {
//						if (i <= n - 2 && j <= n - 2 && map[i+d][j+d] == 0) {
//							web++;
//						} else {
//							if (i > n - 2 ^ j > n - 2 ^ map[i+d][j+d] == 1) {
//								break;
//							}
//						}
//					}
//					
//					// 남서쪽
//					for (int d = 1; d <= Math.min(i, n-j-1); d++) {
//						if (i >= 1 && j <= n - 2 && map[i-d][j+d] == 0) {
//							web++;
//						} else {
//							if (i < 1 ^ j > n - 2 ^ map[i-d][j+d] == 1) {
//								break;
//							}
//						}
//					}
				}
			}
		}
		System.out.println(maxWeb);
		System.out.println(maxI + "," + maxJ);
	}
}



/*
10
0 0 0 0 0 0 0 0 0 0
0 1 0 1 0 1 0 1 0 1
0 1 0 1 0 1 0 1 0 1
0 0 1 0 1 0 1 0 1 0
0 0 0 1 0 1 0 1 0 1
0 1 0 0 0 1 0 0 0 1
0 0 1 0 0 0 0 0 1 0
0 1 0 0 0 1 0 0 0 0
0 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
 */
