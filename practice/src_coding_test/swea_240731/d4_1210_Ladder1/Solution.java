package swea_240731.d4_1210_Ladder1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			
			// 델타배열 : 상(0) 좌(1) 우(2)
			int[] rWay = {-1, 0, 0};
			int[] cWay = {0, -1, 1};
			int way = 0;
			int rNow = 0;
			int cNow = 0;
			int rNext = 0;
			int cNext = 0;
			int X1 = 0;
			int X2 = 0;
			
			int T = sc.nextInt();
			int[][] ladder = new int[100][100];
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					ladder[r][c] = sc.nextInt();
				}
			}
			
			// X2 확인 ~ 역주행 ~ X1 찾기
			for (int c = 0; c < 100; c++) {
				if (ladder[99][c] == 2)
					X2 = c;
			}
			
			rNow = 99;
			cNow = X2;
			
			while (true) {
				
				if (rNow == 0) {
					X1 = cNow;
					break;
				}
				
				way = 0; 			// 상(기본)
				rNext = rNow + rWay[way];
				cNext = cNow + cWay[way];
				
				// 방향 설정 (Short Circuit 사용)
				if (cNext > 0 && ladder[rNext][cNext] == 0) {
					way = 1; 		// 좌
					rNext = rNow + rWay[way];
					cNext = cNow + cWay[way];
					if (cNext < 99 && ladder[rNext][cNext] == 0) {
						way = 2;	// 우
						rNext = rNow + rWay[way];
						cNext = cNow + cWay[way];
					}
				}
				
				rNow += rWay[way];
				cNow += cWay[way];
			}
			
			System.out.println("#" + T + " " + X1);
		}
		
	}
}
