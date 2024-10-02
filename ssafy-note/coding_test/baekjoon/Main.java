package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int W = sc.nextInt();
		int[] answer = new int[T+1];
		for (int t = 1; t <= T; t++)
			answer[t] = sc.nextInt() % 2;
		
		// w 이동횟수
		// w 짝수 = 1번나무
		// w 홀수 = 2번나무
		int[][] dp = new int[W+1][T+1];
		for (int w = 1; w <= W; w++) {
			for (int t = 1; t <= T; t++) {
				if (w % 2 != answer[t])
					dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t] + 1);
				else
					dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t]);
			}
		}
		
		System.out.println(dp[W][T]);
	}
}