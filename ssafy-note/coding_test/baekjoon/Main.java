package baekjoon;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] stk, dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			stk = new int[N][2];
			dp = new int[N][2];
			
			for (int r = 0; r < N; r++)
				for (int c = 0; c < 2; c++)
					stk[r][c] = sc.nextInt();
			
			dp[0][0] = stk[0][0];
			dp[0][1] = stk[0][1];
			
			for (int r = 1; r < N; r++) {
				dp[r][0] = Math.max(stk[r][0] + dp[r-1][1], Math.max(dp[r-1][0], dp[r-1][1]));
				dp[r][1] = Math.max(stk[r][1] + dp[r-1][0], Math.max(dp[r-1][0], dp[r-1][1]));
			}
			
			int maxScore1 = Math.max(dp[N-2][0], dp[N-2][1]);
			int maxScore2 = Math.max(dp[N-1][0], dp[N-1][1]);
			int maxScore = Math.max(maxScore1, maxScore2);
			
			System.out.println(maxScore);
		}// tc
	}
}
