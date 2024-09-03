package baekjoon_failed.G1_17472_다리만들기2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] bada = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++)
				bada[n][m] = sc.nextInt();
		
		// 섬 찾기
		List<List<int[]>> islandList = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (!visited[n][m] && bada[n][m] == 1) {
					List<int[]> island = new ArrayList<>();
					Queue<int[]> bfs = new LinkedList<>();
					
					island.add(new int[] {n, m});
					bfs.add(new int[] {n, m});
					visited[n][m] = true;
					
					while (!bfs.isEmpty()) {
						
						int[] map = bfs.poll();
						int nNow = map[0];
						int mNow = map[1];
						
						for (int d = 0; d < 4; d++) {
							int nNext = nNow + dn[d];
							int mNext = mNow + dm[d];
							
							if (nNext < 0 || N <= nNext) continue;
							if (mNext < 0 || M <= mNext) continue;
							if (bada[nNext][mNext] == 0) continue;
							if (visited[nNext][mNext]) continue;
							
							island.add(new int[] {nNext, mNext});
							bfs.add(new int[] {nNext, mNext});
							visited[nNext][mNext] = true;
						}
					}
					islandList.add(new ArrayList<>(island));
				}
			}
		}
		
		// *************************************************************************
		for (List<int[]> island : islandList) {
			for (int[] num : island)
				System.out.println(num[0] + ", " + num[1]);
			System.out.println();
		}
		// *************************************************************************
		
		// 다리 찾기
		// 다리 길이 > 1 !!!!!!!!!
		int islands = islandList.size();
		List<Integer>[] adjList = new ArrayList[islands];
		for (int i = 0; i < islands; i++)
			adjList[i] = new ArrayList<>();
		
		for (List<int[]> island : islandList) {
			
			
			
		}
		
		
	}
}