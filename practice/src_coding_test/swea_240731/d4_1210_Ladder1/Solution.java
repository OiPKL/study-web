package swea_240731.d4_1210_Ladder1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			
			int T = sc.nextInt();
			int[][] ladder = new int[100][100];
			
			// 델타배열 : 상(0) 좌(1) 우(2)
			int[] rWay = {1, 0, 0};
			int[] cWay = {0, -1, 1};
			// 방향 설정에 사용
			int way = 0;
			// 좌표 설정에 사용
			int rNow = 0;
			int cNow = 0;
			int rNext = 0;
			int cNext = 0;
			
			// 출발점
			int X1 = 0;
			// 도착점
			int X2 = 0;
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					ladder[r][c] = sc.nextInt();
				}
			}
			
			for (int c = 0; c < 100; c++) {
				if (ladder[99][c] = 2)
					
			}
			

			while (int )
			
			System.out.println("#" + t + " " + X);
		}
		
	}
}
