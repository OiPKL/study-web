package baekjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int[][] chess = new int[N][N];
    	
    	// 체스판 좌표 : 0 -> 퀸의 위치 : 1
    	// - 퀸은 1이 아닌 0에만 위치할 수 있음
    	// - 퀸이 놓이면 가로+세로+대각선 좌표를 전부 1로 변경 & cnt++
    	// - 행 단위로 남은 0 중 퀸의 위치를 선정

    	System.out.println(setQueen(chess, 0, 0));
    		
    }
    
    static int cnt = 0;
    
    static int setQueen(int[][] chess, int r, int c) {
    	// 동[0] 남[1] 남동[2] 남서[3]
    	int[] dr = {0, 1, 1, 1};
    	int[] dc = {1, 0, 1, -1};
    	
    	if (r == chess.length) {
    		cnt++;					// 마지막 행의 남은 퀸의 위치는 하나
    		int result = cnt;
    		return result;
    	} else {

    	}
    
    }
    
}