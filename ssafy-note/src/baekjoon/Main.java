package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dn = { -1, 0, 1, 0 };
	static int[] dm = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int total = 0;
		List<int[]> starts = new ArrayList<>();
		
		int[][] visited = new int[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				visited[n][m] = Integer.MAX_VALUE;
		
		int[][] map = new int[N][M];
		for (int n = 0; n < N; n++) {
			
			int m = 0;
			st = new StringTokenizer(br.readLine());
			int tomato = Integer.parseInt(st.nextToken());
			
			if (tomato == 0) total++;
			else if (tomato == 1) starts.add(new int[] {n, m, 0});
			
			map[n][m] = tomato;
			visited[n][m++] = 0;
		}
		
		for (int[] start : starts) {
			
			Queue<int[]> bfs = new LinkedList<>();
			bfs.add({start[0], start[1], start[2]});
			
			while (!bfs.isEmpty()) {
				
				int[] now = bfs.poll();
				int nNow = now[0];
				int mNow = now[1];
				int cnt = now[2];
				
				for (int d = 0; d < 4; d++) {
					
					int nNext = nNow + dn[d];
					int mNext = mNow + dm[d];
					
					if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
							) continue;
					
				}
			}
			
		}
	}
}