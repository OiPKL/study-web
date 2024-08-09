package baekjoon_failed.G4_9663_N_Queen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        boolean[][] chess = new boolean[N][N];
        
        setQueen(chess, 0);
        System.out.println(cnt);
    }
    
    static int cnt = 0;
    
    static void setQueen(boolean[][] chess, int row) {
        int N = chess.length;
        
        // 모든 퀸을 놓았다면 경우의 수를 증가시킨다.
        if (row == N) {
            cnt++;
            return;
        }
        
        // 해당 행에 퀸을 놓을 수 있는 모든 열을 탐색
        for (int col = 0; col < N; col++) {
            if (isSafe(chess, row, col)) {
                chess[row][col] = true; // 퀸을 놓는다
                setQueen(chess, row + 1); // 다음 행으로 이동
                chess[row][col] = false; // 퀸을 제거하여 백트래킹
            }
        }
    }
    
    static boolean isSafe(boolean[][] chess, int row, int col) {
        int N = chess.length;
        
        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (chess[i][col]) return false;
        }
        
        // 대각선 (\) 확인
        for (int i = 0; i < row; i++) {
            int diagonal1 = col - (row - i);
            if (diagonal1 >= 0 && chess[i][diagonal1]) return false;
        }
        
        // 대각선 (/) 확인
        for (int i = 0; i < row; i++) {
            int diagonal2 = col + (row - i);
            if (diagonal2 < N && chess[i][diagonal2]) return false;
        }
        
        return true;
    }
}
