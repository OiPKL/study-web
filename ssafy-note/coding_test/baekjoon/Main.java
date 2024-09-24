package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static int N, M, K, cnt;
	static int[][] foodMap, foodPlan; 
	static List<int[]> greenList;
	static PriorityQueue<Integer>[][] treeAgeMap;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		foodMap = new int[N][N];				// 양분지도
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				foodMap[r][c] = 5;
		
		foodPlan = new int[N][N];				// 겨울양분지도
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				foodPlan[r][c] = sc.nextInt();
		
		greenList = new ArrayList<>();			// 녹지목록(몇그룬진모름)
		treeAgeMap = new PriorityQueue[N][N];	// 나무나이지도
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				treeAgeMap[r][c] = new PriorityQueue<>();
		
		for (int m = 0; m < M; m++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			treeAgeMap[r][c].add(sc.nextInt());
			greenList.add(new int[] {r, c});
		}
		
		cnt = 0;
		for (int k = 1; k <= K; k++) {
			
			// 봄 & 여름
			for (int g = 0; g < greenList.size(); g++) {
				int r = greenList.get(g)[0];
				int c = greenList.get(g)[1];
				int food = foodMap[r][c];
				
				List<Integer> treeAgeList = new ArrayList<>();
				while (!treeAgeMap[r][c].isEmpty())
					treeAgeList.add(treeAgeMap[r][c].poll());
				
				boolean enough = true;
				for (int t = 0; t < treeAgeList.size(); t++) {
					int treeAge = treeAgeList.get(t);

					if (enough) {
						if (food >= treeAge) {
							food -= treeAge;
							treeAgeList.set(t, treeAge + 1);
						} else {
							food += treeAge / 2;
							treeAgeList.remove(t);
							enough = false;
						}
					} else {
						food += treeAge / 2;
						treeAgeList.remove(t);
					}
				}
				
				foodMap[r][c] = food;
				if (treeAgeList.isEmpty())
					greenList.remove(g);
				for (int treeAge : treeAgeList)
					treeAgeMap[r][c].add(treeAge);
			}
			
			// 가을
			for (int g = 0; g < greenList.size(); g++) {
				int r = greenList.get(g)[0];
				int c = greenList.get(g)[1];
				
				List<Integer> treeAgeList = new ArrayList<>();
				while (!treeAgeMap[r][c].isEmpty())
					treeAgeList.add(treeAgeMap[r][c].poll());
				
				for (int t = 0; t < treeAgeList.size(); t++) {
					int treeAge = treeAgeList.get(t);
					
					if (treeAge % 5 == 0) {
						
						for (int d = 0; d < 8; d++) {
							int rn = r + dr[d];
							int cn = c + dc[d];
							
							if (rn < 0 || N <= rn) continue;
							if (cn < 0 || N <= cn) continue;
							
							treeAgeMap[rn][cn].add(1);
							for (int g2 = 0; g2 < greenList.size(); g2++) {
								int r2 = greenList.get(g)[0];
								int c2 = greenList.get(g)[1];
							}
						}
						
					}
				}
			}
			
			// 겨울
			
		}//K년후
		
		System.out.println(cnt);
	}
}
