package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static long sum;
	static int[][] adj;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sum = 0;
		
		adj = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (i != j)
					adj[i][j] = 1_000_000_000;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken()) - 1;
			int node2 = Integer.parseInt(st.nextToken()) - 1;
			
			if (i == K - 1) {
				adj[node1][node2] = 1;
				adj[node2][node1] = 1;
			} else {
				adj[node1][node2] = 0;
				adj[node2][node1] = 0;
			}
		}
		
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
		
//		for (int i = 0; i < N; i++)
//			System.out.println(Arrays.toString(adj[i]));
		
		for (int i = 0; i < N; i++)
			for (int j = i+1; j < N; j++)
				sum += adj[i][j];
		
		System.out.println(sum);
	}
}