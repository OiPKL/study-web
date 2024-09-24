package baekjoon_failed.G3_16235_나무재테크;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static int N, M, K;
	static int[][] foodMap, foodPlan;
	static Set<Integer> greenSet;
	static List<Integer>[][] treeAgeMap;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		foodMap = new int[N][N];				// 양분지도
		foodPlan = new int[N][N];				// 겨울양분지도
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				foodMap[r][c] = 5;
				foodPlan[r][c] = sc.nextInt();
			}
		}
		
		greenSet = new HashSet<>();				// 녹지목록(나무>=1 좌표목록), key: N*r + c
		treeAgeMap = new ArrayList[N][N];		// 나무나이지도
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				treeAgeMap[r][c] = new ArrayList<>();
		
		for (int m = 0; m < M; m++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			treeAgeMap[r][c].add(sc.nextInt());
			
			int key = N * r + c;
			greenSet.add(key);
		}
		
		for (int k = 1; k <= K; k++) {
			
			// 봄 & 여름
			Set<Integer> newGreenSet = new HashSet<>();
			for (int key : greenSet) {
				int r = key / N;
				int c = key % N;
				int food = foodMap[r][c];
				
                List<Integer> treeAgeList = treeAgeMap[r][c];
                Collections.sort(treeAgeList);
                
                List<Integer> newTreeAgeList = new ArrayList<>();
				
				int energy = 0;
				boolean enough = true;
				for (int treeAge : treeAgeList) {
					
					if (enough) {
						if (food >= treeAge) {
							food -= treeAge;
							newTreeAgeList.add(treeAge + 1);
						} else {
							energy += treeAge / 2;
							enough = false;
						}
					} else
						energy += treeAge / 2;
				}
				
				foodMap[r][c] = food + energy;
				
			    treeAgeMap[r][c].clear(); 
			    treeAgeMap[r][c].addAll(newTreeAgeList);
				
				if (!newTreeAgeList.isEmpty())
					newGreenSet.add(key);
			}
			
            greenSet = new HashSet<>(newGreenSet);
			
			// 가을
            newGreenSet = new HashSet<>();
            for (int key : greenSet) {
				int r = key / N;
				int c = key % N;

				newGreenSet.add(key);
				
			    for (int treeAge : treeAgeMap[r][c]) {
					if (treeAge % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int rn = r + dr[d];
							int cn = c + dc[d];
							
							if (rn < 0 || N <= rn || cn < 0 || N <= cn) continue;
							
							treeAgeMap[rn][cn].add(1);
							
							int keyN = rn * N + cn;
							newGreenSet.add(keyN);
						}
					}
				}
			}
			
            greenSet = new HashSet<>(newGreenSet);
			
			// 겨울
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++)
					foodMap[r][c] += foodPlan[r][c];
		}
		
		int cnt = 0;
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				cnt += treeAgeMap[r][c].size();
		
		System.out.println(cnt);
	}
}