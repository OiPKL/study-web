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
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int R, C, maxTime;
	static char[][] map;
	static List<int[]>swans;
	static int[] swan1, swan2;
	static int[][] meltingMap;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		swans = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == 'L')
					swans.add(new int[] {r, c});
			}
		}
		
		swan1 = swans.get(0);
		swan2 = swans.get(1);
		
		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				if (map[r][c] == 'X')
					calMeltingTime(r, c);
		
		meltingMap = new int[R][C];
		
    }
	
	static void calMeltingTime(int r, int c) {
			
		
		if (map[rWay][cWay] == 'X') {
			
			Queue<int[]> bfs = new LinkedList<>();
			visited = new boolean[R][C];
			
			bfs.add(new int[] {rWay, cWay, 0});
			visited[rWay][cWay][0] = 1;
			
			while (!bfs.isEmpty()) {
				
				int[] now = bfs.poll();
				int rNow = now[0];
				int cNow = now[1];
				int cnt = now[2];
				
				if (map[rNow][cNow] != 'X') {
					maxTime = Math.max(maxTime, cnt);
					break;
				}
				
			    for (int d = 0; d < 4; d++) {
			    	
					int rNext = rNow + dr[d];
					int cNext = cNow + dc[d];
					
					if (rNext < 0 || R <= rNext || cNext < 0 || C <= cNext ||
						visited[rNext][cNext]) continue;
			    
					bfs.add(new int[] {rNext, cNext, cnt + 1});
					visited[rNext][cNext] = true;
			    }
			}
		}
	}
}