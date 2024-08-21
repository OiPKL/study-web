package swea_failed.A형_2112_보호필름;

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
			int[][] yakOrgn = new int[D][W];
			int[][] yakCopy = new int[D][W];
			for (int d = 0; d < D; d++) {		// A=0 B=1
				for (int w = 0; w < W; w++) {
					int yak = sc.nextInt();
					yakOrgn[d][w] = yak;
					yakCopy[d][w] = yak;
				}
			}
			
			cnt = 0;
			
			
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	static int cnt = 0;
	
	static void insertA(int[] yakCopyD) {
		int W = yakCopyD.length;
		for (int w = 0; w < W; w++)
			yakCopyD[w] = 0;
	}
	
	static void insertB(int[] yakCopyD) {
		int W = yakCopyD.length;
		for (int w = 0; w < W; w++)
			yakCopyD[w] = 1;
	}
	
	static boolean test(int[][] yakCopy, int K) {
		int D = yakCopy.length;
		int W = yakCopy[0].length;
		for (int w = 0; w < W; w++) {
			int cnt = 1;
			int max = 0;
			int yak = yakCopy[w][0];
			for (int d = 1; d < D; d++) {
				if (yakCopy[w][d] == yak) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					cnt = 1;
					yak = yakCopy[w][d];
				}
			}
			if (max < K) return false;
		}
		return true;
	}

	static void insertMak(int[][] yakCopy, int[] yakCopyD int start, int K) {
		if (!(test(yakCopy, K))) return;
		
		int D = yakCopy.length;
		for (int d = start; d < D; d++) {
			insertMark(yakCopy, insertA(yakCopy[d]), d, K);
		}
	}
	
}
