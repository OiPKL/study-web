package baekjoon;

import java.util.Scanner;

public class Main {
	
	static int max, score, N;
	static int[][] stk, dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			max = 0;
			score = 0;
			N = sc.nextInt();
			stk = new int[2][N];
			dp = new int[2][N];
			
			for (int r = 0; r < 2; r++)
				for (int c = 0; c < N; c++)
					stk[r][c] = sc.nextInt();
			
			dp[0][0] = stk[0][0];
			dp[0][1] = stk[0][1];
			
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < N; c++) {
					
				}
			}
			
		}// tc
	}
}
