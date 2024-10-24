package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		int[][] visited = new int[N][N];
		Queue<int[]> bfs = new LinkedList<>();
		bfs.add(new int[] {0, 1, 0});
		
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int rNow = now[0];
			int cNow = now[1];
			int dWay = now[2];
			
			visited[rNow][cNow]++;

			System.out.println("now: " + Arrays.toString(now));
			for (int r = 0; r < N; r++)
				System.out.println(Arrays.toString(visited[r]));
			System.out.println();
			
			for (int d = 0; d < 3; d++) {
				
				if (dWay == 0) {
					if (d == 2) continue;
				} else if (dWay == 1) {
					if (d == 0) continue;
				}
				
				int rNext = rNow + dr[d];
				int cNext = cNow + dc[d];
				
				if (rNext < 0 || N <= rNext || cNext < 0 || N <= cNext ||
						map[rNext][cNext] == 1) continue;
				
				bfs.add(new int[] {rNext, cNext, d});
			}
		}
		
		System.out.println(visited[N-1][N-1]);
	}
}