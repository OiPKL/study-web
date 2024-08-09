package baekjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	boolean[][] chess = new boolean[N][N];
    	// 체스판: false / 퀸: true
    	
    	setQueen(chess, 0, 0);
    	System.out.println(cnt);
    		
    }
    
    static int cnt = 0;
    
    static void setQueen(boolean[][] chess, int rQueen, int cQueen) {
    	
    	int N = chess.length;
    	
    	if (rQueen == N - 1) {
    		cnt++;
    		return;
    	}
    	
    	for (int i = rQueen; i < N; i++) {
    		rQueen++;
    		cQueen = setNextQueen(chess, rQueen);
    		setQueen(chess, rQueen, cQueen);
    		rQueen--;
    	}
    	
    }
    
    static boolean isSafe(boolean[][] chess, int rCheck, int cCheck) {

    	int N = chess.length;
    	
		for (int r = 0; r < N; r++) {
			if (chess[r][cCheck]) return false;
		}
		// 대각선1 (\ : r+c 일치 확인) -> 행에 대각선 위치의 (r, cCheck)가 존재한다면 ~
		for (int r = 0; r < N; r++) {
			int cCheck = (rNext + c) - r;
			if (cCheck >= 0 && cCheck < N && chess[r][cCheck] == true) continue outer;
		}
		// 대각선2 (/ : r-c 일치 확인) -> 행에 대각선 위치의 (r, cCheck)가 존재한다면 ~
		for (int r = 0; r < N; r++) {
			int cCheck = (c - rNext) + r;
			if (cCheck >= 0 && cCheck < N && chess[r][cCheck] == true) continue outer;
		}
		int cNext = c;
		return cNext;
    	
    }
    
}