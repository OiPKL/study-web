package baekjoon_failed.G1_1799_비숍;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] chess;
	static int cnt;
	static int maxCnt;
	static boolean[] checkBishop = new boolean[19];	// r-c + N-1 : -4~4 -> 0~8 보정
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		// 비숍 불가능위치 = 0, 가능위치 = 1
		chess = new int[N][N];
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				chess[r][c] = sc.nextInt();
		
		setBishop(0);
		System.out.println(maxCnt);
		
	}
	
	// 하나의 대각선에는 하나의 비숍만 놓일 수 있다 -> 같은 r+c 줄에는 하나의 비숍만 (rCheck)
	static void setBishop(int rCheckIdx) {
		
        if (rCheckIdx > 2 * (N - 1)) {
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        // rCheckIdx 번째 대각선을 기준으로 비숍을 놓을 수 있는지 체크
		for (int rCheck = rCheckIdx; rCheck <= 2 * (N - 1); rCheck++){
			// if N = 4
			// 0) [0,0] ~ 1) [1,0]-[0,1] ~ ... ~ 4) [4,0]-[3,1]-[2,2]-[1,3]-[0,4]
			if (rCheck < N) {
				for (int rr = 0; rr < rCheck + 1; rr++) {
					int rBishop = rCheck - rr;
					int cBishop = rr;
					if (chess[rBishop][cBishop] == 1) {
						if (!checkBishop[rBishop-cBishop+N-1]) {
							checkBishop[rBishop-cBishop+N-1] = true;
							cnt++;
							setBishop(rCheck + 1);
							checkBishop[rBishop-cBishop+N-1] = false;
							cnt--;
						}
					}
				}
			// 5) [4,1]-[3,2]-[2,3]-[1,4] ~ ... ~ 7) [4,3]-[3,4] ~ 8) [4,4]
			} else {
				for (int rr = 0; rr < 2 * (N - 1) - rCheck + 1; rr++) {
					int rBishop = (N - 1) - rr;
					int cBishop = rCheck - (N - 1) + rr;
					if (chess[rBishop][cBishop] == 1) {
						if (!checkBishop[rBishop-cBishop+N-1]) {
							checkBishop[rBishop-cBishop+N-1] = true;
							cnt++;
							setBishop(rCheck + 1);
							checkBishop[rBishop-cBishop+N-1] = false;
							cnt--;
						}
					}
				}
			}
		}
        // 현재 대각선에서 비숍을 놓지 않고 다음 대각선으로 이동
        setBishop(rCheckIdx + 1);
	}
}

