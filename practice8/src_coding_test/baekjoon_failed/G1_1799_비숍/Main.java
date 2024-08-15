package baekjoon_failed.G1_1799_비숍;

import java.util.Scanner;

public class Main {
	
	static int cnt = 0;
	static int max = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// 비숍 불가능위치 = 0, 가능위치 = 1, 놓인위치 = 2
		int[][] chess = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				chess[r][c] = sc.nextInt();
			}
		}
		
		setBishop(chess, 0, 0);
		System.out.println(max);
		
	}
	
	/*
	 * 재귀함수 setBishop
	 * 1. 끝나는 조건
	 * - chess[N-1][N-1] 도달
	 * 2. 다음 단계 진행
	 * - 이중for문 : chess[r][c+1] ~ chess[r][N-1]
	 * - 이중for문 : chess[r+1][0] ~ chess[N-1][N-1]
	 * 3. 현재 단계 이중 for문 반복
	 * - <2> 와 같음
	 * 4. 이전단계로 회귀
	 * - <2> 에서의 리턴 시 이전 단계로 원복
	 * - 리턴 = 더 놓을 수 없다 -> max 비교
	 * - 가장 마지막에 놓였던 비숍을 제거 (2->1)
	 * - [rBishop][cBishop] 으로 원복 ~ 다음 for문으로 탐색 시작
	 */
	
	static void setBishop(int[][] chess, int rBishop, int cBishop) {
		int N = chess.length;
		
		// rBishop 행에서의 Bishop 탐색
		for (int c = cBishop; c < N; c++) {
			if (chess[rBishop][c] == 1 && isSafe(chess, rBishop, c)) {
				chess[rBishop][c] = 2;				// 비숍놓기
				cnt++;
				setBishop(chess, rBishop, c + 1);	// 다음비숍
				chess[rBishop][c] = 1;				// 비숍제거
				cnt--;
			}
		}
		
		// rBishop+1 이후 행에서의 Bishop 탐색
		for (int r = rBishop + 1; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (chess[r][c] == 1 && isSafe(chess, r, c)) {
					chess[r][c] = 2;				// 비숍놓기
					cnt++;
					if (r == N - 1 && c == N -1) {
						max = Math.max(max, cnt);
					}
					setBishop(chess, r, c + 1);		// 다음비숍
					chess[r][c] = 1;				// 비숍제거
					cnt--;
				}
			}
		}
		
	}
	
	static boolean isSafe(int[][] chess, int rBishop, int cBishop) {
		int N = chess.length;
		
		for (int r = 0; r < N; r++) {
			// rBishop + cBishop = r + cDaegak1
			int cDaegak1 = (rBishop + cBishop) - r;
			if (cDaegak1 >= 0 && cDaegak1 < N && chess[r][cDaegak1] == 2) return false;
			// rBisop - cBishop = r - cDaegak2
			int cDaegak2 = r - (rBishop - cBishop);
			if (cDaegak2 >= 0 && cDaegak2 < N && chess[r][cDaegak2] == 2) return false;
		}
		return true;
	}
}