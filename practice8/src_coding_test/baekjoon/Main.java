package baekjoon;

import java.util.Scanner;

public class Main {

	static int cnt = 0;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// 비숍 불가능위치 = 0, 가능위치 = 1, 놓인 비숍 위치 = 2
		int[][] chess = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				chess[r][c] = sc.nextInt();
			}
		}
		
		setBishop(chess, 0);
		System.out.println(max);
	}
	
	/*
	 * 재귀함수 setBishop
	 * 1. 끝나는 조건
	 * - if 문 : 맨 마지막 행 도달 = cnt++ 후 리턴 -> 리턴하면 이전의 행으로 돌아감
	 * - for문 종료 : c = 0 ~ c = N-1 까지 전부 세봤다 -> 리턴하면 이전의 행으로 돌아감
	 * 2. 다음 단계 진행
	 * - rBishop + 1 : 다음 행
	 * 3. 현재 단계에서 for문 반복 : c = 0 ~ c = N-1 비숍 위치 조건 확인 ~~~
	 * 4. <1> 에서의 리턴 시 이전 단계로 원복
	 * - rBishop + 1 이 취소(?)되고 rBishop 으로 돌아오게 됨
	 * - rBishop + 1 행에 놓았던 비숍을 제거하는 과정이 필요
	 */

	static void setBishop(int[][] chess, int rBishop) {
		int N = chess.length;
		
		if (rBishop == N) {
			cnt++;
			return;
		}
		
		for (int cBishop = 0; cBishop < N; cBishop++) {
			if (chess[rBishop][cBishop] == 1 && isSafe(chess, rBishop, cBishop)) {
				chess[rBishop][cBishop] = 2;	// 비숍 놓기
				setBishop(chess, rBishop + 1);	// 다음 행
				max = Math.max(max, cnt);
				cnt--;
				chess[rBishop][cBishop] = 1;	// 비숍 제거
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