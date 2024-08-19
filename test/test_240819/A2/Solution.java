package A2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[][] bada = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					bada[r][c] = sc.nextInt();
				}
			}
			
			int bridge = 9999;
			islandList = new ArrayList<>();
			
			findIsland(bada);
			
//			// TEST -----------------------------------------------------
//			for (int i = 0; i < islandList.size(); i++) {
//				System.out.print("island: ");
//				for (int j = 0; j < 4; j++) {
//					System.out.print(islandList.get(i)[j] + " ");
//				}
//				System.out.println();
//			}
//			// TEST -----------------------------------------------------
			
			outer:
			for (int i = 0; i < islandList.size(); i++) {
				int[] island1 = islandList.get(i);
				
				int min = 9999;
				inner:
				for (int j = i+1; j < islandList.size(); j++) {
					int[] island2 = islandList.get(j);
					
					int cnt = isConnected(island1, island2);
					if (cnt == 9999) continue inner;
					else {
						min = Math.min(min, cnt);
					}
				}
				if (min == 9999) {
					bridge = -1;
					break outer;
				} else {
					bridge += min;
				}
			}

			System.out.println("#" + tc + " " + bridge);
		}
		
	}
	
	static List<int[]> islandList = new ArrayList<>();
	
	static void findIsland(int[][] bada) {
		int N = bada.length;
		for (int r = 0; r < N; r++) {
			inner:
			for (int c = 0; c < N; c++) {
				// �ߺ� �� ����
				for (int i = 0; i < islandList.size(); i++) {
					int R = islandList.get(i)[0];
					int C = islandList.get(i)[1];
					int X = islandList.get(i)[2];
					int Y = islandList.get(i)[3];
					
					if (R <= r && r < R+X && C <= c && c < C+Y)
						continue inner;
				}
				
				if (bada[r][c] == 1) {
					int cntX = 1;
					int cntY = 1;
					int tmpR = r;
					int tmpC = c;
					if (r+1 < N && bada[r+1][c] == 1)
						while (true) {
							r += 1;
							if (r == N || bada[r][c] == 0) break;
							cntX++;
						}
					r = tmpR;
					if (c+1 < N && bada[r][c+1] == 1)
						while (true) {
							c += 1;
							if (c == N || bada[r][c] == 0) break;
							cntY++;
						}
					c = tmpC;
					
					islandList.add(new int[] {r, c, cntX, cntY});
				}
				
			}
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int isConnected(int[] island1, int[] island2) {
		int R1 = island1[0]; int tmpR1 = R1;
		int C1 = island1[1]; int tmpC1 = C1;
		int X1 = island1[2];
		int Y1 = island1[3];
		int R2 = island2[0];
		int C2 = island2[1];
		int X2 = island2[2];
		int Y2 = island2[3];
		
		int min = 9999;
		
		return 9999;
	}
}