package src_240912.pr_05_backpack;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N + 1];
		int[] cost = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N + 1][W + 1];
		
		// 물건은 한개씩만 존재
		for (int i = 1; i <= N; i++) {
			// w는 임시무게
			for (int w = 0; w <= W; w++) {
				// 내가 고려할 물건의 무게가 임시무게보다 작다면..
				if (weights[i] <= W) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]+cost[i]]);
				} else {
					// 아니라면 이전까지 고민한게 최적값
					dp[i][w] = dp[i - 1][w];
				}
			}
			
		}//물건 고려
		
		System.out.println(dp[N][W]);
		
	}
}
