package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int N, M;
	static int[][] map;
	static List<Integer>[] cctv;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cctv = new ArrayList[6];
		for (int i = 1; i <= 5; i++)
			cctv[i] = new ArrayList<>();
		
		map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[n][m] = tmp;
				
				if (1 <= tmp && tmp <= 5) {
					int key = 10 * n + m;
					cctv[tmp].add(key);
				}
			}
		}
		
		
	}
}