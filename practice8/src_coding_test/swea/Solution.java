package swea;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int great = Integer.MAX_VALUE;
			
			int N = sc.nextInt();
			int[][] SNJ = new int[N][N];
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					SNJ[n][m] = sc.nextInt();
				}
			}
			
			// SNJ[1][3] + SNJ[3][1] .. 미리 더한 뒤에
			// 4C2 = 6 -> 3개 합 / 3개 합 의 차이가 작은 경우가 great
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (n == m) 
				}
			}
			
			System.out.println("#" + tc + " " + great);
		}
	}
}