package swea_failed.A형_2112_보호필름;

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
			
			minCnt = 0;
			complete = false;
//			insertMak(int[][] makOrgn, int[][] makCopy, int dStrt, int dTgt, int dCnt, int K)
			insertMak(makOrgn, makCopy, 0, 1, 0, K);
			
			System.out.println("#" + tc + " " + minCnt);
		}
		
	}
	
	static int minCnt;
	static boolean complete;
	
	static int[] rollBack(int[][] makOrgn, int[] makCopyD, int d) {
		int W = makCopyD.length;
		for (int w = 0; w < W; w++)
			makCopyD[w] = makOrgn[d][w];
		
		return makCopyD;
	}
	
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
	
	static boolean test(int[][] makCopy, int K) {
		int D = makCopy.length;
		int W = makCopy[0].length;
		for (int w = 0; w < W; w++) {			// w 칼럼 별로..
			int cnt = 1;						// 측정위치 -> cnt 1
			int max = 0;
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
	
//	static void insertMak(int[][] makOrgn, int[][] makCopy, int dStrt, int dTgt, int dCnt, int K) {
//		if (complete) return;			// 조건을 만족시키면 더 진행시키지 않기 위해... (dCnt == dTgt 조건 대신..)
//		if (dCnt == 0) {
//			if (test(makCopy, K)) {		// 아래 for문 = dTgt 1 ~ D-1
//				minCnt = dCnt;			// 최초 1번만 실행 -> 첫 기저조건에서 컷
//				complete = true;
//			}
//		}
//		if (dCnt == dTgt) {
//			if (test(makCopy, K)) {
//				minCnt = dCnt;			// 최초 1번만 실행 -> 첫 기저조건에서 컷
//				complete = true;
//			}
//			return;
//		}
//		
//		int D = makCopy.length;			// dStrt = 0, dTgt = 1, dCnt = 0
//		for (int ds = dStrt; ds < D; ds++) {
//			insertMak(makOrgn, makCopy, ds + 1, dTgt + 1, dCnt + 1, K);
//			insertA(makCopy[ds]);
//			insertMak(makOrgn, makCopy, ds + 1, dTgt + 1, dCnt + 1, K);
//			insertB(makCopy[ds]);
//			insertMak(makOrgn, makCopy, ds + 1, dTgt + 1, dCnt + 1, K);
//			rollBack(makOrgn, makCopy[ds], ds);
//		}
//	}
	
	static void insertMak(int[][] makOrgn, int[][] makCopy, int dStrt, int dTgt, int dCnt, int K) {
		if (complete) return;			// 조건을 만족시키면 더 진행시키지 않기 위해... (dCnt == dTgt 조건 대신..)
		if (dCnt == 0) {
			if (test(makCopy, K)) {		// 아래 for문 = dTgt 1 ~ D-1
				minCnt = dCnt;			// 최초 1번만 실행 -> 첫 기저조건에서 컷
				complete = true;
			}
		}
		if (dCnt == dTgt) {
			if (test(makCopy, K)) {
				minCnt = dCnt;			// 최초 1번만 실행 -> 첫 기저조건에서 컷
				complete = true;
			}
			System.out.println("*********************************************");
			return;
		}
		
		int D = makCopy.length;
		System.out.println("[0] dStrt: " + dStrt + "| dTgt: " + dTgt + "| dCnt: " + dCnt + "|============================");
		for (int dt = dTgt; dt < D; dt++) {	// dStrt = 0, dTgt = 1, dCnt = 0
			for (int ds = dStrt; ds < D; ds++) {
				insertMak(makOrgn, makCopy, ds + 1, dt, dCnt + 1, K);
				insertA(makCopy[ds]);
				System.out.println("[1] dStrt: " + dStrt + "| dTgt: " + dTgt + "| dCnt: " + dCnt + "| dt: " + dt + "| ds: " + ds);
																												testest(makCopy);
				insertMak(makOrgn, makCopy, ds + 1, dt, dCnt + 1, K);
				insertB(makCopy[ds]);
				System.out.println("[2] dStrt: " + dStrt + "| dTgt: " + dTgt + "| dCnt: " + dCnt + "| dt: " + dt + "| ds: " + ds);
																												testest(makCopy);
				insertMak(makOrgn, makCopy, ds + 1, dt, dCnt + 1, K);
				rollBack(makOrgn, makCopy[ds], ds);
				System.out.println("[3] dStrt: " + dStrt + "| dTgt: " + dTgt + "| dCnt: " + dCnt + "| dt: " + dt + "| ds: " + ds);
																												testest(makCopy);
																												System.out.println();
			}
		}
	}
	
	static void testest(int[][] makCopy) {
		for (int d = 0; d < makCopy.length; d++) {
			for (int w = 0; w < makCopy[0].length; w++) {
				System.out.print(makCopy[d][w] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
