package swea_failed.A형_4013_특이한자석;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int[] mag0 = new int[8];		// 맨위부터 0~7
			int[] mag1 = new int[8];
			int[] mag2 = new int[8];
			int[] mag3 = new int[8];
			
			for (int m = 0; m < 8; m++)		// N극 0
				mag0[m] = sc.nextInt();	// S극 1
			for (int m = 0; m < 8; m++)
				mag1[m] = sc.nextInt();
			for (int m = 0; m < 8; m++)
				mag2[m] = sc.nextInt();
			for (int m = 0; m < 8; m++)
				mag3[m] = sc.nextInt();
			
			// 마주보는 자성이 다른 경우 반시계 회전
			// 마주보는 자성이 같은 경우 그대로
			
			int K = sc.nextInt();
			int[][] quest = new int[K][2];
			for (int k = 0; k < K; k++) {
				quest[k][0] = sc.nextInt();	// magnet No
				quest[k][1] = sc.nextInt();	// 시계1 반시계-1
			}
			
			for (int k = 0; k < K; k++) {
				if (quest[k][0] == 0) {
					
				} else if (quest[k][0] == 1) {
					
				} else if (quest[k][0] == 2) {
					
				} else {
					
				}

			}
			
			int score = 0;	// 왼쪽부터 1 2 4 8 점
			
			System.out.println("#" + tc + " " + score);
		}
		
	}
	
	static int[] clock(int[] mag) {
		int tmp = mag[7];
		mag[7] = mag[6];
		mag[6] = mag[5];
		mag[5] = mag[4];
		mag[4] = mag[3];
		mag[3] = mag[2];
		mag[2] = mag[1];
		mag[1] = mag[0];
		mag[0] = tmp;
		
		return mag;
	}
	
	static int[] unclock(int[] mag) {
		int tmp = mag[0];
		mag[7] = mag[0];
		mag[6] = mag[7];
		mag[5] = mag[6];
		mag[4] = mag[5];
		mag[3] = mag[4];
		mag[2] = mag[3];
		mag[1] = mag[2];
		mag[0] = mag[1];
		
		return mag;
	}
}
