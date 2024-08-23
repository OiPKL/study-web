package baekjoon;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int minCnt;

	// 하 우 상 좌
	static int[] dn = {1, 0, -1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		// (0,0) 출발 ~ (N,M) 도착
		int[][] miro = new int[N][M];
		for (int n = 0; n < N; n++) {
			String str = sc.nextLine();
			char[] charArr = str.toCharArray();
			for (int m = 0; m < M; m++) {
				miro[n][m] = charArr[m] - '0';
			}
		}
		
		minCnt = 9999;
		move(miro, 0, 0, 0, 1);
		
		System.out.println(minCnt);
		
	}
	
	// dWay -> Now 에서 어느 방향에서 왔는지 체크 -> 온 방향으로 되돌아가지 않도록
	static void move(int[][] miro, int nNext, int mNext, int dWay, int cnt) {
		
		if (miro[nNext][mNext] == 0) return;
		
		// TEST -----------------------------------------------------------
		System.out.println("[" + nNext + ", " + mNext + "]");
		// TEST -----------------------------------------------------------
		
		if (nNext == N-1 && mNext == M-1) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			if (d == (dWay+2) % 4 ) continue;	// 온 방향 Pass
			if (nNext+dn[d] < 0 || nNext+dn[d] == N ||
				mNext+dm[d] < 0 || mNext+dm[d] == M) continue;
			move(miro, nNext+dn[d], mNext+dm[d], d, cnt + 1);
		}
		
	}
	
}