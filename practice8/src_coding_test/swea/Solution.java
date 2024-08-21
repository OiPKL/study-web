package swea;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int D = sc.nextInt();
			int W = sc.nextInt();
			int K = sc.nextInt();
			int[][] makOrgn = new int[D][W];
			int[][] makCopy = new int[D][W];
			for (int d = 0; d < D; d++) {		// A=0 B=1
				for (int w = 0; w < W; w++) {
					int yak = sc.nextInt();
					makOrgn[d][w] = yak;
					makCopy[d][w] = yak;
				}
			}
		
		minCnt = 9999;
		complete = false;
		insertMak(makOrgn, makCopy, 0, 0, 0, K);
		
		System.out.println("#" + tc + " " + minCnt);
		}
	}
	
	static int minCnt;
	static boolean complete;
	
	static int[] insertA(int[] makCopyD) {
		int W = makCopyD.length;
		for (int w = 0; w < W; w++)
			makCopyD[w] = 0;
		
		return makCopyD;
	}
	
	static int[] insertB(int[] makCopyD) {
		int W = makCopyD.length;
		for (int w = 0; w < W; w++)
			makCopyD[w] = 1;

		return makCopyD;
	}
	
	static int[] rollBack(int[][] makOrgn, int[] makCopyD, int d) {
		int W = makCopyD.length;
		for (int w = 0; w < W; w++)
			makCopyD[w] = makOrgn[d][w];
		
		return makCopyD;
	}
	
	static boolean test(int[][] makCopy, int K) {
		int D = makCopy.length;
		int W = makCopy[0].length;
		for (int w = 0; w < W; w++) {			// w 칼럼 별로..
			int cnt = 1;						// 측정위치 -> cnt 1
			int max = 1;
			int yak = makCopy[0][w];			// 측정위치 시작 = 맨 위
			for (int d = 1; d < D; d++) {
				if (makCopy[d][w] == yak) {
					cnt++;						// 연속된 약 -> cnt++
					max = Math.max(max, cnt);	// 최대 연속 측정
				} else {
					cnt = 1;					// 불연속 -> cnt 1 초기화
					yak = makCopy[d][w];		// 측정위치 시작 재설정
				}
			}
			if (max < K) return false;			// 기준 미달 시 false 반환
		}
		return true;							// 모두 통과 시 true 반환
	}
	
	static void insertMak(int[][] makOrgn, int[][] makCopy, int dStrt, int dTgt, int dCnt, int K) {
		if (complete) return;
		
		if (dTgt == 0) {
			if (test(makCopy, K)) {
				minCnt = Math.min(minCnt, dCnt);
				complete = true;
			} else {
				insertMak(makOrgn, makCopy, 0, 1, 0, K);	// dTgt = 1 부터 시작
			}
			return;
		}
		
		if (dCnt == dTgt) {
			if (test(makCopy, K)) {
				minCnt = Math.min(minCnt, dCnt);
				complete = true;
			}
			return;
		}
		
		int D = makCopy.length;
		for (int ds = dStrt; ds < D; ds++) {
			insertA(makCopy[ds]);
			insertMak(makOrgn, makCopy, ds + 1, dTgt + 1, dCnt + 1, K);
			insertB(makCopy[ds]);
			insertMak(makOrgn, makCopy, ds + 1, dTgt + 1, dCnt + 1, K);
			rollBack(makOrgn, makCopy[ds], ds);
		}
		
	}
	
}