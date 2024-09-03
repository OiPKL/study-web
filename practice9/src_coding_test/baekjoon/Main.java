package baekjoon;

import java.util.Scanner;

public class Main {
	
	static int N, rNow, cNow, rNext, cNext, dWay;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	// (4방향 모두 y기준) 2 10 7 1 5 10 7 1 2 a 순으로 저장
	static int[][] dtr = {{-2, -1, -1, -1, 0, 1, 1, 1, 2, 0},
						  {0, 1, 0, -1, 2, 1, 0, -1, 0, 1},
						  {2, 1, 1, 1, 0, -1, -1, -1, -2, 0},
						  {0, -1, 0, 1, -2, -1, 0, 1, 0, -1}};
	static int[][] dtc = {{0, -1, 0, 1, -2, -1, 0, 1, 0, -1},
						  {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0},
						  {0, 1, 0, -1, 2, 1, 0, -1, 0, 1},
						  {2, 1, 1, 1, 0, -1, -1, -1, -2, 0}};
	static int[] dtx = 	  {2, 10, 7, 1, 5, 10, 7, 1, 2};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				map[r][c] = sc.nextInt();
		
		rNow = N/2;
		cNow = N/2;
		visited[rNow][cNow] = true;
		dWay = 3;
		
		while (!(rNow == 0 && cNow == 0)) {
			for (int d = 1; d <= 2; d++) {		// 좌회전 시도 후 직진
				dWay = (dWay + d) % 4;
				rNext = rNow + dr[dWay];
				cNext = cNow + dc[dWay];
				
//				if (rNext < 0 && N <= rNext) ----- 걸릴 일이 없지 ㅇㅇ
				if (!visited[rNext][cNext]) break;
			}
			System.out.println(rNext + ", " + cNext + ", " + dWay);
			rNow = rNext;
			cNow = cNext;
			visited[rNow][cNow] = true;
		}
		
		
	}
}
