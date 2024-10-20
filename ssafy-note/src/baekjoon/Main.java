package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] heads = new int[N];
		int[][] road = new int[N][2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			heads[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++)
				road[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}