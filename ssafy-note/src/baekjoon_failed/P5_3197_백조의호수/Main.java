package baekjoon_failed.P5_3197_백조의호수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		List<int[]>swans = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == 'L')
					swans.add(new int[] {r, c});
			}
		}
		
		int[] swan1 = swans.get(0);
		int[] swan2 = swans.get(1);
		
		int[][] visited = new int[R][C];
		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				visited[r][c] = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> bfs = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		bfs.add(new int[] {swan1[0], swan1[1], 0});
		visited[swan1[0]][swan1[1]] = 0;
		
		int answer = -1;
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int rNow = now[0];
			int cNow = now[1];
			int cnt = now[2];
			
			System.out.println(rNow + " | " + cNow + " | " + cnt);
			
			if (rNow == swan2[0] && cNow == swan2[1]) {
				answer = cnt;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				
				int rNext = rNow + dr[d];
				int cNext = cNow + dc[d];
				
				if (rNext < 0 || R <= rNext || cNext < 0 || C <= cNext) continue;
				
				if (map[rNext][cNext] == 'X') {
					if (cnt + 1 < visited[rNext][cNext]) {
						bfs.add(new int[] {rNext, cNext, cnt + 1});
						visited[rNext][cNext] = cnt + 1;
					}
				} else {	// . or L
					if (cnt < visited[rNext][cNext]) {
						bfs.add(new int[] {rNext, cNext, cnt});
						visited[rNext][cNext] = cnt;
					}
				}
			}
		}
		
		System.out.println((answer + 1) / 2);
    }
}


/*

1 7
LXX.XXL
2 -> 1

1 8
LXX.XX.L
2 -> 2

1 8
L.XXXXXL
3 -> 3

1 9
LX.X.X.XL
2 -> 1

1 9
LX.X.X.XL
2 -> 1

 */