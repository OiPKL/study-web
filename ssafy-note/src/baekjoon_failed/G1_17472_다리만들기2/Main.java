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
		
//		// *************************************************************************
//		for (List<int[]> island : islandList) {
//			for (int[] num : island)
//				System.out.println(num[0] + ", " + num[1]);
//			System.out.println();
//		}
//		// *************************************************************************
		
		// 다리 찾기
		/*
		 * 어떤 for문을 안쪽에 넣을지 고민하다 더 오래걸려도 이게 쉬울 것 같아서 일단 이걸로..
		 * 이거를 최적화하는게 B형의 능력 아닐까??
		 * 시간초과가 두렵긴 하지만 N과 M이 크지 않아서 가능할 것 같긴 해서 일단 진행..
		 * 
		 * 섬 목록들을 받아와서 from섬, to섬 pick
		 * from섬의 블럭마다 델타배열 돌려서 한칸씩 전진하면서 length++ (+length = 1 컷)
		 * to섬의 블럭과 만나게 되면 length를 비교해 가장 짧은 값을 인접리스트에 추가
		 * adjList 인덱스에는 from 값에는 to 저장 (from-to to-from 둘 다 저장)
		 */
		
		int islands = islandList.size();
		List<int[]>[] adjList = new ArrayList[islands];
		for (int i = 0; i < islands; i++)
			adjList[i] = new ArrayList<>();
		
		for (int f = 0; f < islands - 1; f++) {
			List<int[]> islandFrom = islandList.get(f);
			
			for (int t = f + 1; t < islands; t++) {
				List<int[]> islandTo = islandList.get(t);
				
				for (int ff = 0; ff < islandFrom.size(); ff++) {
					int[] islandFromBlock = islandFrom.get(ff);
					int islandFBN_now = islandFromBlock[0];
					int islandFBM_now = islandFromBlock[1];

					int minLength = Integer.MAX_VALUE;
					for (int d = 0; d < 4; d++) {
						
						int length = 0;
						int islandFBN_check = islandFBN_now;	// 원본 복사
						int islandFBM_check = islandFBM_now;
						
						calLength:
						while(true) {
							islandFBN_check += dn[d];
							islandFBM_check += dm[d];
							length++;
							
							if (islandFBN_check < 0 || N <= islandFBN_check) break calLength;
							if (islandFBM_check < 0 || M <= islandFBM_check) break calLength;
							
							if (bada[islandFBN_check][islandFBM_check] == 1) {
								
								for (int tt = 0; tt < islandTo.size(); tt++) {
									int[] islandToBlock = islandTo.get(tt);
									int islandTBN = islandToBlock[0];
									int islandTBM = islandToBlock[1];
									
									if (islandFBN_check == islandTBN && islandFBM_check == islandTBM) {
										if (length > 1)
											minLength = Math.min(minLength, length);
										break calLength;
									} 
								}
								
							} else
								break calLength;	// 섬을 찾긴 찾았는데 islandTo 가 아닌 경우
						}
					}
					
//					System.out.println(minLength);
					adjList[f].add(new int[] {t, minLength});
					adjList[t].add(new int[] {f, minLength});
				}
			}
		}
		
//		// 최소 연결 다리길이 구하기
//		int minSum = Integer.MAX_VALUE;
//		isConnected:
//		for (int i = 0; i < islands; i++) {
//			Queue<Integer> bfs = new LinkedList<>();
//			boolean[] visiteed = new boolean[islands];
//
//			bfs.add(i);
//			visiteed[i] = true;
//			
//			int sum = 0;
//			while(!bfs.isEmpty()) {
//				List<int[]> bridges = adjList[bfs.poll()];
//				
//				for (int j = 0; j < bridges.size(); j++) {
//					int[] bridge = bridges.get(j);
//					
//					if (visiteed[bridge[0]]) continue;
//					bfs.add(bridge[0]);
//					visiteed[bridge[0]] = true;
//					sum += bridge[1];
//				}
//			}
//			
//			for (int j = 0; j < islands; j++)
//				if (!visiteed[j]) continue isConnected;
//			
//			minSum = Math.min(minSum, sum);
//		}
//		
//		System.out.println(minSum);
	}
}