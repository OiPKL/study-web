package baekjoon;

import java.util.Scanner;

public class Main {
	
	static int mod = 1_000_000_000;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// k개 pick ~ 합이 n
		int[][] dp = new int[K+1][N+1];
		dp[0][0] = 1;
		// 머리 빠개지는 중............
		for (int d = 1; d <= K; d++)
			for (int p = d; p <= N; p++)
				for (int i = 0; i <= d - 1; i++)
					for (int j = 0; j <= p; j++)
						dp[d][p] += dp[i][j];		// --> [o-o] 로 수정해야함
					
		for (int d = 0; d <= K; d++) {
			for (int p = 0; p <= N; p++)
				System.out.printf("%3d" + " ", dp[d][p]);
			System.out.println();
		}
		
		System.out.println(dp[K][N]);
	}
}