package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static int N, M, K, cnt = 0;
	static int[][] foodMap, foodPlan;
	static List<Integer> greenList;
	static PriorityQueue<Integer>[][] treeAgeMap;
	
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
		
		greenList = new ArrayList<>();			// 녹지목록(나무>=1 좌표목록), key: 10*r + c
		treeAgeMap = new PriorityQueue[N][N];	// 나무나이지도
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				treeAgeMap[r][c] = new PriorityQueue<>();
		
		for (int m = 0; m < M; m++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			treeAgeMap[r][c].add(sc.nextInt());
			cnt++;
			
			int key = 10*r + c;
			if (!greenList.contains(key))
				greenList.add(key);
		}
		
		for (int k = 1; k <= K; k++) {
			
			// ********************************************************************************************
			System.out.println(k + "년: ");
			System.out.println("foodMap");
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++)
					System.out.print(foodMap[r][c] + " ");
				System.out.println();
			}
			
			System.out.println("treeAgeMap");
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++)
					System.out.print(treeAgeMap[r][c].size() + " ");
				System.out.println();
			}
			
			System.out.println("greenList");
			for (int num : greenList)
				System.out.print(num + " ");
			System.out.println();
			// ********************************************************************************************
			
			// 봄 & 여름
			List<Integer> newGreenList = new ArrayList<>();
			for (int g = 0; g < greenList.size(); g++) {
				int key = greenList.get(g);
				int r = key / 10;
				int c = key % 10;
				int food = foodMap[r][c];
				
				List<Integer> treeAgeList = new ArrayList<>();
				Queue<Integer> newTreeAgeList = new LinkedList<>();
				while (!treeAgeMap[r][c].isEmpty())
					treeAgeList.add(treeAgeMap[r][c].poll());
				
				int energy = 0;
				boolean enough = true;
				for (int ta = 0; ta < treeAgeList.size(); ta++) {
					int treeAge = treeAgeList.get(ta);
					
					if (enough) {
						if (food >= treeAge) {
							food -= treeAge;
							newTreeAgeList.add(treeAge + 1);
						} else {
							energy += treeAge / 2;
							enough = false;
							cnt--;
						}
					} else {
						energy += treeAge / 2;
						cnt--;
					}
				}
				
				foodMap[r][c] = food + energy;
				if (!newTreeAgeList.isEmpty()) {
					newGreenList.add(key);
					
					while (!newTreeAgeList.isEmpty())
						treeAgeMap[r][c].add(newTreeAgeList.poll());
				}
			}
			
			greenList = new ArrayList<>();
			greenList = List.copyOf(newGreenList);
			
			// ********************************************************************************************
			System.out.print("여름: ");
			for (int num : greenList)
				System.out.print(num + " ");
			System.out.println();
			// ********************************************************************************************
			
			// 가을
			newGreenList = new ArrayList<>();
			for (int g = 0; g < greenList.size(); g++) {
				int key = greenList.get(g);
				int r = key / 10;
				int c = key % 10;

				newGreenList.add(key);
				
				List<Integer> treeAgeList = new ArrayList<>();
				while (!treeAgeMap[r][c].isEmpty())
					treeAgeList.add(treeAgeMap[r][c].poll());
				
				for (int ta = 0; ta < treeAgeList.size(); ta++) {
					int treeAge = treeAgeList.get(ta);
					
					if (treeAge % 5 == 0) {
						
						for (int d = 0; d < 8; d++) {
							int rn = r + dr[d];
							int cn = c + dc[d];
							
							if (rn < 0 || N <= rn) continue;
							if (cn < 0 || N <= cn) continue;
							
							treeAgeMap[rn][cn].add(1);
							cnt++;
							
							int keyN = rn * 10 + cn;
							if (!greenList.contains(keyN))
								newGreenList.add(keyN);
						}
					}
				}
			}
			
			greenList = new ArrayList<>();
			greenList = List.copyOf(newGreenList);
			
			// ********************************************************************************************
			System.out.print("가을: ");
			for (int num : greenList)
				System.out.print(num + " ");
			System.out.println();
			System.out.println();
			System.out.println();
			// ********************************************************************************************
			
			// 겨울
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++)
					foodMap[r][c] += foodPlan[r][c];
		}
		
		System.out.println(cnt);
	}
}
