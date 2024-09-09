package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};	// 상좌하우 : 이유 있음
	static int[] dc = {0, -1, 0, 1};
	
	static int N, aliveTime;
	static int[][] map;
	static int[] shark;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 9)
					shark = new int[] {r, c, 2, 0};
			}
		}//input
		
		aliveTime = 0;
		
		alive:
		while (true) {
			
			int rNow = shark[0];
			int cNow = shark[1];
			int size = shark[2];
			int exp = shark[3];
			int rNext = -1;
			int cNext = -1;
			int time = 0;
			
			// 탐색
			Queue<int[]> bfs = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			
			bfs.add(new int[] {rNow, cNow, time});
			visited[rNow][cNow] = true;
			
			/*
			 * 수정해야 할 것
			 * 
			 * 가장가까운 물고기 리스트로 반환 후 (minTime 비교)
			 * 상좌하우 순으로 물고기 고르기
			 * 
			 * rNext == -1 && cNext == -1 -> break alive
			 */
			
			search:
			while (true) {
				
				if (bfs.isEmpty())
					break alive;					// 엄마소환
				
				int[] now = bfs.poll();
				rNow = now[0];
				cNow = now[1];
				time = now[2];
				
				for (int d = 0; d < 4; d++) {
					
					rNext = rNow + dr[d];
					cNext = cNow + dc[d];
					
					if (rNext < 0 || N <= rNext) continue;
					if (cNext < 0 || N <= cNext) continue;
					if (visited[rNext][cNext]) continue;
					if (map[rNext][cNext] > size) continue;
					
					if (map[rNext][cNext] == 0) {
						bfs.add(new int[] {rNext, cNext, time + 1});
						visited[rNext][cNext] = true;
					} else {
						time++;
						break search;				// 탐색완료
					}
				}//d
			}//bfs
			
			// 이동 & 냠냠
			map[rNow][cNow] = 0;
			map[rNext][cNext] = 9;
			aliveTime += time;
			
			if (++exp == size) {
				size++;
				exp = 0;
			} else
				exp++;
			
			shark = new int[] {rNext, cNext, size, exp};
			
		}//alive
		
		System.out.println(aliveTime);
		
	}//main
}//Main