package baekjoon_failed.G1_1799_비숍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, maxCntB, maxCntW;
	static int[][] map;
	static boolean[] sumCheck, chaCheck;
	
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
		
		maxCntB = 0;
		maxCntW = 0;
        sumCheck = new boolean[2 * N];
        chaCheck = new boolean[2 * N];
		
		btk(0, 0, 0, true);		// 합 짝수(Black)
		btk(0, 1, 0, false);	// 합 홀수(White)
		
		System.out.println(maxCntB + maxCntW);
	}
	
	static void btk(int rNow, int cNow, int cnt, boolean isBlack) {
		
		if (rNow == N) {
			if (isBlack)
				maxCntB = Math.max(maxCntB, cnt);
			else
				maxCntW = Math.max(maxCntW, cnt);
			return;
		}
		
		for (int r = rNow; r < N; r++) {
			for (int c = r == rNow ? cNow : 0; c < N; c += 2) {
				
				if (map[r][c] == 1) {

					int sum = r + c;
					int cha = r - c + N;
					
					if (!sumCheck[sum] && !chaCheck[cha]) {
						
						sumCheck[sum] = true;
						chaCheck[cha] = true;
						if (c + 2 == N)
							btk(r + 1, 1, cnt + 1, isBlack);
						else if (c + 2 == N + 1)
							btk(r + 1, 0, cnt + 1, isBlack);
						else
							btk(r, c + 2, cnt + 1, isBlack);
						sumCheck[sum] = false;
						chaCheck[cha] = false;
					}
				}
			}
		}
	}
}