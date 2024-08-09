package baekjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	boolean[][] chess = new boolean[N][N];

    	System.out.println(cnt);
    		
    }
    
    static void setQueen()
    
}
    
//    static int cnt = 0;
//    
//    static boolean[][] setQueenZone(boolean[][] chess, int rQueen, int cQueen) {
//    	
//    	int N = chess.length;
//    	
//		chess[rQueen] = new boolean[N];	// 동서
//    	for (int r = 0; r < N; r++)
//    		chess[r][cQueen] = false;	// 남북
//    	int r = rQueen;
//    	int c = cQueen;
//    	while (r < N && c < N)
//    		chess[r++][c++] = false;	// 남동
//    	r = rQueen;
//    	c = cQueen;
//    	while (r < N && c >= 0)
//    		chess[r++][c--] = false;	// 남서
//    	r = rQueen;
//    	c = cQueen;
//    	while (r >= 0 && c < N)
//    		chess[r--][c++] = false;	// 북동
//    	r = rQueen;
//    	c = cQueen;
//    	while (r >= 0 && c >= 0)
//    		chess[r--][c--] = false;	// 북서
//    	
//    	return chess;
//    	
//    }
//    
//    static void setQueen(boolean[][] oldChess, boolean[][] newChess, int rQueen, int cQueen) {
//    	
//    	int N = oldChess.length;
//    	
//    	if (rQueen == N) {
//    		cnt++;
//    		return;
//    	}
//    	
//    	for (int r = rQueen; r < N; r++) {
//    		newChess = setQueenZone(oldChess, rQueen, cQueen);
//    		int tmpQueen = cQueen;
//    		for (int c = 0; c < N; c++) {
//    			if (newChess[rQueen++][c] == true)
//    				cQueen = c;				// 다음 cQueen 탐색
//    			if (cQueen == tmpQueen)	{	// 조건 만족하는 cQueen 존재 x
//    				newChess = oldChess;
//    				setQueen(oldChess, newChess, rQueen, cQueen);
//    			}
//    		}
//    	}
//    	
//    }