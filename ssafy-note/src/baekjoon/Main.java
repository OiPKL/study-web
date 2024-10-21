package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, maxHeads;
	static int[] heads;
	static List<Integer>[] roads;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		heads = new int[N + 1];
		roads = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			roads[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			heads[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int city1 = Integer.parseInt(st.nextToken());
			int city2 = Integer.parseInt(st.nextToken());
			
			roads[city1].add(city2);
			roads[city2].add(city1);
		}
		
		maxHeads = 0;
		dp = new int[N + 1][2];
		// 1번도시 우수마을 X
		getDp(1, 1, 0, 0);
		// 1번도시 우수마을 O = 1번도시 인접마을들 우수마을 X
		for (int selected : roads[1])
			getDp(selected, selected, 0, 0);
		
		System.out.println(maxHeads);
	}
	
	static void getDp(int memo, int selected, int isBestCity, int cnt) {
		
		System.out.println(memo + " | "  + selected + " | " + isBestCity + " | " + cnt);
		for (int i = 1; i <= N; i++)
			System.out.print(dp[i][0] + " ");
		System.out.println();
		for (int i = 1; i <= N; i++)
			System.out.print(dp[i][1] + " ");
		System.out.println();
		
		if (cnt > N) {
			maxHeads = Math.max(maxHeads, dp[memo][0]);
			return;
		}
		
		if (dp[selected][isBestCity] != 0)
			return;
		
		cnt++;
		
		
		for (int adjCity : roads[selected]) {
			if (dp[adjCity][1-isBestCity] == 0) {
				
			}
		}
		
		
		
		
		
		for (int selected2 : roads[selected]) {
			if (dp[selected2][1-isBestCity] == 0) {
				getDp(memo, selected2, 1 - isBestCity, cnt + 1);
				dp[selected][isBestCity] += dp[selected2][1-isBestCity];
			} else {
				getDp(memo, selected2, 1 - isBestCity, cnt);
				dp[selected][isBestCity] += dp[selected2][1-isBestCity];
			}
		}
	}
}