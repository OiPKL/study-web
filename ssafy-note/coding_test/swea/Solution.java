package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static int N, K, top, secondTop, maxCnt;
	static int[][] map;
	static List<int[]> topList, secondList;
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			top = 0;
			secondTop = 0;
			maxCnt = 0;
			map = new int[N][N];
			topList = new ArrayList<>();
			secondList = new ArrayList<>();
			
			for (int n = 0; n < N; n++) {
			    for (int m = 0; m < N; m++) {
			        int num = sc.nextInt();
			        map[n][m] = num;
			        if (num > top) {
			            top = num;
			            topList = new ArrayList<>();
			            topList.add(new int[] {n, m});
			        } else if (num == top) {
			            topList.add(new int[] {n, m});
				    }
				}
			}

//			for (int n = 0; n < N; n++) {
//			    for (int m = 0; m < N; m++) {
//			        int num = sc.nextInt();
//			        map[n][m] = num;
//			        if (num > top) {
//			            secondTop = top;
//			            top = num;
//			            secondList = new ArrayList<>(topList);
//			            topList = new ArrayList<>();
//			            topList.add(new int[] {n, m});
//			        } else if (num == top) {
//			            topList.add(new int[] {n, m});
//			        }
//			        else if (num > secondTop) {
//			            secondTop = num;
//			            secondList = new ArrayList<>();
//			            secondList.add(new int[] {n, m});
//			        } else if (num == secondTop) {
//			            secondList.add(new int[] {n, m});
//			        }
//			    }
//			}
			
//			System.out.println(topList.size());
//			for (int[] top : topList) {
//				for (int t : top)
//					System.out.print(t + " ");
//				System.out.println();
//			}
//			System.out.println(secondList.size());
//			for (int[] top : secondList) {
//				for (int t : top)
//					System.out.print(t + " ");
//				System.out.println();
//			}
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {

					for (int k = 1; k <= K; k++) {
						map[n][m] -= k;
						
							for (int[] top : topList) {
								if (map[top[0]][top[1]] < 0) continue;
								makeRoad(top);
							}
						
						map[n][m] += k;
					}
				}
			}
			
			System.out.println("#" + tc + " " + maxCnt);
			
		}
	}
	
	static void makeRoad(int[] point) {

		Stack<int[]> dfs = new Stack<>();
		boolean[][] visited = new boolean[N][N];
		int nNow, mNow, nNext, mNext;

		nNow = point[0];
		mNow = point[1];
		dfs.add(new int[] {nNow, mNow, 1});
		visited[nNow][mNow] = true;
		
		while (!dfs.isEmpty()) {
			
			int[] top = dfs.pop();
			nNow = top[0];
			mNow = top[1];
			int cnt = top[2];

			maxCnt = Math.max(maxCnt, cnt);

			for (int d = 0; d < 4; d++) {
				nNext = nNow + dn[d];
				mNext = mNow + dm[d];
				
				if (nNext < 0 || N <= nNext) continue;
				if (mNext < 0 || N <= mNext) continue;
				if (visited[nNext][mNext]) continue;
				if (map[nNow][mNow] <= map[nNext][mNext]) continue;
				
                visited[nNext][mNext] = true;
				dfs.add(new int[] {nNext, mNext, cnt + 1});
			}
		}
		
		
	}
	
}
