package pr_03_practice;

import java.util.Arrays;

public class Practice1 {

	public static void main(String[] args) {
		
		int N = 5;
		int[][] board = new int[N][N];
		
		// 				   0  1  2  3
		// 				   상  하  좌  우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = (int)(Math.random()*100);
			}
		}
		
		System.out.println(Arrays.deepToString(board));
		
		int[][] sum = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
//				if (r - 1 >= 0)
//					sum[r][c] += Math.abs(board[r-1][c] - board[r][c]);
//				if (r + 1 < N)
//					sum[r][c] += Math.abs(board[r+1][c] - board[r][c]);
//				if (c - 1 >= 0)
//					sum[r][c] += Math.abs(board[r][c-1] - board[r][c]);
//				if (c + 1 < N)
//					sum[r][c] += Math.abs(board[r][c+1] - board[r][c]);
				
				// 델타 배열 사용 이유
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (0 <= nr && nr < N && 0 <= nc && nc < N) {
						sum[r][c] += Math.abs(board[r][c] - board[nr][nc]);
					}
				}
				
			}
		}

		System.out.println(Arrays.deepToString(sum));
		
	}
}
