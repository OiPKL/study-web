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
				int[] island = islandList.get(i);
				
				int min = 9999;
				
				
				
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
		// 가장 왼쪽 위 (r,c) 좌표, 가로사이즈, 세로사이즈 -> islandList 추가
		int N = bada.length;
		for (int r = 0; r < N; r++) {
			inner:
			for (int c = 0; c < N; c++) {
				for (int i = 0; i < islandList.size(); i++) {
					int R = islandList.get(i)[0];
					int C = islandList.get(i)[1];
					int Rlength = islandList.get(i)[2];
					int Clength = islandList.get(i)[3];
					
					if (R <= r && r < R+Rlength && C <= c && c < C+Clength)
						continue inner;
				}
				
				if (bada[r][c] == 1) {
					int cntR = 1;
					int cntC = 1;
					int tmpR = r;
					int tmpC = c;
					if (r+1 < N && bada[r+1][c] == 1)
						while (true) {
							r += 1;
							if (r == N || bada[r][c] == 0) break;
							cntR++;
						}
					r = tmpR;
					if (c+1 < N && bada[r][c+1] == 1)
						while (true) {
							c += 1;
							if (c == N || bada[r][c] == 0) break;
							cntC++;
						}
					c = tmpC;
					
					islandList.add(new int[] {r, c, cntR, cntC});
				}
				
			}
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int isConnected(int[] bada, int[] island1) {
		int R = island1[0];
		int C = island1[1];
		int tmpR1 = R;
		int tmpC1 = C;
		int Rlength = island1[2];
		int Clength = island1[3];
		
		int min = 9999;
		
		return 9999;
	}
}