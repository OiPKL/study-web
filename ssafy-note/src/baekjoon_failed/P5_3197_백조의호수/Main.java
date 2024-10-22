package baekjoon_failed.P5_3197_백조의호수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int R, C, wayCnt;
	static char[][] map;
	static List<int[]>swans;
	static int[] swan1, swan2;
	static int[][][] visited;
	static Stack<int[]> validWay;
	static boolean complete;
	
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
		
		visited = new int[R][C][2];
		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				visited[r][c][0] = Integer.MAX_VALUE;
//				visited[r][c][0] = 9;
		
		
		// 1. 최소 얼음 부수기
		wayCnt = -1;
		bfs();

		
//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++)
//				System.out.printf("%2d ", visited[r][c][0]);
//			System.out.println();
//		}
//		System.out.println();
//		
//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++)
//				System.out.printf("%2d ", visited[r][c][1]);
//			System.out.println();
//		}
//		System.out.println(wayCnt);
		
		
		// 2. 최적 경로 역추적
		complete = false;
		validWay = new Stack<>();
		btk(swan2[0], swan2[1], wayCnt - 1);
		
		
//		while (!validWay.isEmpty())
//			System.out.println(Arrays.toString(validWay.pop()));

		
		// 3. L~L 얼음 녹는 시간 구하기
		int cnt = 0;
		int maxCnt = 0;
		while (!validWay.isEmpty()) {
			
			int[] now = validWay.pop();
			int rNow = now[0];
			int cNow = now[1];
			
			if (map[rNow][cNow] == 'X')
				cnt++;
			else {
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 0;
			}
		}
		
		System.out.println((maxCnt + 1) / 2);
    }

	static void bfs() {
		PriorityQueue<int[]> bfs = new PriorityQueue<>((a, b) -> a[3] - b[3]);
		
		bfs.add(new int[] {swan1[0], swan1[1], 0, 0});
		visited[swan1[0]][swan1[1]][0] = 0;
		
		while (!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int rNow = now[0];
			int cNow = now[1];
			int cnt = now[2];
			int ice = now[3];
			
//			System.out.println(rNow + " | " + cNow + " | " + cnt + " | " + ice);
			
			if (rNow == swan2[0] && cNow == swan2[1]) {
				wayCnt = cnt;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				
				int rNext = rNow + dr[d];
				int cNext = cNow + dc[d];
				
				if (rNext < 0 || R <= rNext || cNext < 0 || C <= cNext) continue;
				
				if (map[rNext][cNext] == 'X') {
					if (ice + 1 < visited[rNext][cNext][0]) {
						bfs.add(new int[] {rNext, cNext, cnt + 1, ice + 1});
						visited[rNext][cNext][0] = ice + 1;
						visited[rNext][cNext][1] = cnt + 1;
					}
				} else {	// . or L
					if (ice < visited[rNext][cNext][0]) {
						bfs.add(new int[] {rNext, cNext, cnt + 1, ice});
						visited[rNext][cNext][0] = ice;
						visited[rNext][cNext][1] = cnt + 1;
					}
				}
			}
		}
	}
	
	static void btk(int rNow, int cNow, int target) {

		if (rNow == swan1[0] && cNow == swan1[1]) {
	        validWay.add(new int[]{rNow, cNow});
	        complete = true;
	        return;
	    }
	    
	    if (complete) return;
	    
	    validWay.add(new int[]{rNow, cNow});
	    
	    List<int[]> nextWay = new ArrayList<>();

	    for (int d = 0; d < 4; d++) {
	    	
			int rNext = rNow + dr[d];
			int cNext = cNow + dc[d];
			
			if (rNext < 0 || R <= rNext || cNext < 0 || C <= cNext) continue;

	        if (visited[rNext][cNext][1] == target)
	        	nextWay.add(new int[] {rNext, cNext});
	    }
	    
	    nextWay.sort((a, b) -> {
	    	return visited[a[0]][a[1]][0] - visited[b[0]][b[1]][0];
	    });
	    
	    for (int[] next : nextWay)
	    	btk(next[0], next[1], target - 1);

	    if (!complete) validWay.pop();
	}
}


/*

1 7
LXX.XXL
= 1

1 8
LXX.XX.L
= 1

1 8
L.XXXXXL
= 3

1 9
LX.X.X.XL
= 1

1 9
LX.X.X.XL
= 1

 */