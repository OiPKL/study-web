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
    		setQueen(chess, rQueen, cQueen);
    	}
    	
    }
    
    static void setNextQueen(boolean[][] chess, int rNowQueen, int cNextQueen) {

    	int N = chess.length;
    	
		for (int c = 0; c < N; c++) {
			// 가로
			if (chess[rNowQueen][c] == false)
			// 세로
			for (int r = 0; r < N; r++) {
				if (chess[r][c] == false)
			}
			
			if (chess[r][c] == false)
			// 대각선1
			if ((rNowQueen + c) == (r))
			// 대각선2
		}
    	
    }
    
}