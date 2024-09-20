package baekjoon_failed.G4_1261_알고스팟;

import java.util.Scanner;

public class Main {
	
	static int[] dn = {0, 1, 0, -1};
	static int[] dm = {1, 0, -1, 0};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.nextLine();
		
		int[][] miro = new int[N][M];
		for (int n = 0; n < N; n++) {
			String line = sc.nextLine();
			for (int m = 0; m < M; m++) {
				char ch = line.charAt(m);
				miro[n][m] = ch - '0';
			}
		}
		
		int[][] dp = new int[N][M];
		dp[0][0] = miro[0][0];
		
//		for (int nNow = 0; nNow < N; nNow++) {
//			for (int mNow = 0; mNow < M; mNow++) {
//				
//				for (int d = 0; d < 4; d++) {
//					int nPrev = nNow + dn[d];
//					int mPrev = mNow + dm[d];
//				}
//			}
//		}
		
		for (int n = 1; n < N; n++)
			dp[n][0] = dp[n-1][0] + miro[n][0];
		
		for (int m = 1; m < M; m++)
			dp[0][m] = dp[0][m-1] + miro[0][m];
		
		for (int n = 1; n < N; n++)
			for (int m = 1; m < M; m++)
				dp[n][m] = Math.min(dp[n-1][m], dp[n][m-1]) + miro[n][m];
		
		System.out.println(dp[N-1][M-1]);
		
	}
}