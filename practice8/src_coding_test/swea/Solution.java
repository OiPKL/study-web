package swea;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int cnt = 0;
			
			int D = sc.nextInt();
			int W = sc.nextInt();
			int K = sc.nextInt();
			int[][] yak = new int[D][W];
			for (int d = 0; d < D; d++) {
				for (int w = 0; w < W; w++) {
					yak[d][w] = sc.nextInt();
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
}