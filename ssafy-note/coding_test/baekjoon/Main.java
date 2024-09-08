package baekjoon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R = 12, C = 6;
	static char[][] ppuyo;
	static int combo;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ppuyo = new char[R][C];
		for (int r = 0; r < R; r++) {
			char[] blocks = sc.nextLine().toCharArray();
			for (int c = 0; c < C; c++)
				ppuyo[r][c] = blocks[c];
		}
		
		combo = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				char block = ppuyo[r][c];
				
				if (block != '.') {
					
					Queue<int[]> bfs = new LinkedList<>();
					boolean[][] visited = new boolean[R][C];
					List<Integer>[] boom = new ArrayList[C];
					for (int cc = 0; cc < C; cc++)
						boom[cc] = new ArrayList<>();
					bfs.add(new int[] {r, c});
					visited[r][c] = true;
					int cnt = 0;
					
					while(!bfs.isEmpty()) {
						int[] now = bfs.poll();
						int rNow = now[0];
						int cNow = now[1];
						
						boom[cNow].add(rNow);
						cnt++;
						
						for (int d = 0; d < 4; d++) {
							int rNext = rNow + dr[d];
							int cNext = cNow + dc[d];
							
							if (rNext < 0 || R <= rNext) continue;
							if (cNext < 0 || C <= cNext) continue;
							if (ppuyo[rNext][cNext] != block) continue;
							if (visited[rNext][cNext]) continue;
							
							bfs.add(new int[] {rNext, cNext});
							visited[rNext][cNext] = true;
						}//for d
					}//while
					
					if (cnt >= 4) {
						
						for (int cc = 0; cc < C; cc++) {
							if (!boom[cc].isEmpty()) {
								Deque<Integer> dq = new LinkedList<>();
								
								
							}// if isEmpty
						}//for cc
						
					}// if cnt
					
				}//if .
			}//for c
		}//for r
		
	}//main
}