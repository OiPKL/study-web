package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int N, aliveTime;
	static int[][] map;
	static int[] shark;
	static List<int[]>[] fishList;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		fishList = new List[7];
		for (int i = 1; i <= 6; i++)
			fishList[i] = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int pos = sc.nextInt();
				map[r][c] = pos;
				if (pos == 9)
					shark = new int[] {r, c, 2, 0};			// r, c, 레벨=필요경험치, 획득경험치
				else if (1 <= pos && pos <= 6)
					fishList[pos].add(new int[] {r, c});	// 섭취 -> {99, 99}
			}
		}//input
		
		aliveTime = 0;
		while (true) {
			
			int rNowShark = shark[0];
			int cNowShark = shark[1];
			int sizeShark = shark[2];
			int minTime = Integer.MAX_VALUE;
			
			// 탐색
			for (int i = 1; i <= sizeShark; i++) {
				List<int[]> fishListBySize = fishList[i];
				
				for (int[] fish : fishListBySize) {
					
					int rTargetFish = fish[0];
					int cTargetFish = fish[1];
					int time = 0;
					
					Queue<int[]> bfs = new LinkedList<>();
					boolean[][] visited = new boolean[N][N];
					
					bfs.add(new int[] {rNowShark, cNowShark, time});
					visited[rNowShark][cNowShark] = true;
					
					search:
					while (!bfs.isEmpty()) {
						
						int[] nowShark = bfs.poll();
						rNowShark = nowShark[0];
						cNowShark = nowShark[1];
						time = nowShark[2];
						
						for (int d = 0; d < 4; d++) {
							int rNextShark = rNowShark + dr[d];
							int cNextShark = cNowShark + dc[d];
							
							if (rNextShark < 0 || N <= rNextShark) continue;
							if (cNextShark < 0 || N <= cNextShark) continue;
							if (visited[rNextShark][cNextShark]) continue;
							if (map[rNextShark][cNextShark] > sizeShark) continue;
							
							if (rNextShark == rTargetFish && cNextShark == cTargetFish) break search;
							
							bfs.add(new int[] {rNextShark, cNextShark, time + 1});
							visited[rNextShark][cNextShark] = true;
						}
						
					}//bfs
					
					/*
					 * #####################   아이디어 정리   #####################
					 * == 탐색
					 * bfs 수정 -> 탐색하면서 가장 가까운 물고기를 찾으면 break
					 * dr dc : 상좌하우 로 수정 필요
					 * 
					 * == 종료
					 * 중간에 break search 가 안되고 종료된다면 엄마 소환
					 * 
					 * == 이동
					 * map & List 둘 다 업데이트!
					 * 
					 * == 섭취
					 * map -> 0 & List -> 99?
					 * if (fish = 99?) continue 기저조건 추가?
					 * 레벨업 = 필요경험치 충족 -> 크기+1 & 필요경험치 초기화
					 */
					
				}//fish
			}//fishListBySize
			
			// 종료
			// 이동
			// 섭취
			// 레벨업
			
			
		}
		
	}//main
}//Main
