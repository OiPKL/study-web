package baekjoon_failed.G1_1799_비숍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, maxCnt;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] evenSumCheck, evenChaCheck, oddSumCheck, oddChaCheck;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N][N];
		evenSumCheck = new boolean[20];	// 0 2 4 6 8 10 12 14 16 18
		evenChaCheck = new boolean[20];	// -8 -6 -4 -2 0 2 4 6 8	-> 0 2 4 6 8 10 12 14 16 18 (+8)
		oddSumCheck = new boolean[20];	// 1 3 5 7 9 11 13 15 17
		oddChaCheck = new boolean[20];	// -9 -7 -5 -3 -1 1 3 5 7 9	-> 1 3 5 7 9 11 13 15 17 (+10)
		
		maxCnt = 0;
		btk(0, 0, 0);
		
		System.out.println(maxCnt);
	}

	private static void btk(int rNow, int cNow, int cnt) {
	
		System.out.println();
		for (int r = 0; r < N; r++)
			System.out.println(Arrays.toString(visited[r]));
		System.out.println();
		
		if (rNow == N) {
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		
		if (map[rNow][cNow] == 1) {
			if ((rNow + cNow) % 2 == 0) {
				
				for (int c = cNow; c < N; c++) {
					
					int sumCheck = rNow + cNow;
					int chaCheck = rNow - cNow + 8;
					
					if (!visited[rNow][cNow] && !evenSumCheck[sumCheck] && !evenChaCheck[chaCheck]) {
						
						visited[rNow][cNow] = true;
						evenSumCheck[sumCheck] = true;
						evenChaCheck[chaCheck] = true;
						if (cNow != N - 1)
							btk(rNow, cNow + 1, cnt + 1);
						else
							btk(rNow + 1, 0, cnt + 1);
						visited[rNow][cNow] = false;
						evenSumCheck[sumCheck] = false;
						evenChaCheck[chaCheck] = false;
					}
				}
				
				for (int r = rNow + 1; r < N; r++) {
					for (int c = 0; c < N; c++) {
						
						int sumCheck = rNow + cNow;
						int chaCheck = rNow - cNow + 8;
						
						if (!visited[rNow][cNow] && !evenSumCheck[sumCheck] && !evenChaCheck[chaCheck]) {
							
							visited[rNow][cNow] = true;
							evenSumCheck[sumCheck] = true;
							evenChaCheck[chaCheck] = true;
							if (cNow != N - 1)
								btk(r, cNow + 1, cnt + 1);
							else
								btk(r + 1, 0, cnt + 1);
							visited[rNow][cNow] = false;
							evenSumCheck[sumCheck] = false;
							evenChaCheck[chaCheck] = false;
						}
					}
				}
			} else {
				
				for (int c = cNow; c < N; c++) {
					
					int sumCheck = rNow + cNow;
					int chaCheck = rNow - cNow + 10;
					
					if (!visited[rNow][cNow] && !oddSumCheck[sumCheck] && !oddChaCheck[chaCheck]) {
						
						visited[rNow][cNow] = true;
						oddSumCheck[sumCheck] = true;
						oddChaCheck[chaCheck] = true;
						if (cNow != N - 1)
							btk(rNow, cNow + 1, cnt + 1);
						else
							btk(rNow + 1, 0, cnt + 1);
						visited[rNow][cNow] = false;
						oddSumCheck[sumCheck] = false;
						oddChaCheck[chaCheck] = false;
					}
				}
				
				for (int r = rNow + 1; r < N; r++) {
					for (int c = 0; c < N; c++) {
						
						int sumCheck = rNow + cNow;
						int chaCheck = rNow - cNow + 10;
						
						if (!visited[rNow][cNow] && !oddSumCheck[sumCheck] && !oddChaCheck[chaCheck]) {
							
							visited[rNow][cNow] = true;
							oddSumCheck[sumCheck] = true;
							oddChaCheck[chaCheck] = true;
							if (cNow != N - 1)
								btk(r, cNow + 1, cnt + 1);
							else
								btk(r + 1, 0, cnt + 1);
							visited[rNow][cNow] = false;
							oddSumCheck[sumCheck] = false;
							oddChaCheck[chaCheck] = false;
						}
					}
				}
			}
		}//map==1
		
		else {
			
			for (int c = cNow; c < N; c++) {
				if (cNow != N - 1)
					btk(rNow, cNow + 1, cnt);
				else
					btk(rNow + 1, 0, cnt);
			}
			
			for (int r = rNow + 1; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (cNow != N - 1)
						btk(r, cNow + 1, cnt);
					else
						btk(r + 1, 0, cnt);
				}
			}
		}//map==0
	}
}