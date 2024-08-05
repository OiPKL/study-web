package baekjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        
        String candy = "";
        char[][] candyArr = new char[N][N];
        
        for (int r = 0; r < N; r++) {
        	candy = sc.nextLine();
        	candyArr[r] = candy.toCharArray();
        }
        
//        System.out.println(N);
//        for (int r = 0; r < N; r++) {
//        	for (int c = 0; c < N; c++) {
//        		System.out.print(candyArr[r][c]);
//        	}
//        	System.out.println();
//        }

        int cnt = 0;
        int max = 0;
        
        // 행 탐색
        for (int r = 0; r < N; r++) {
        	for (int c = 0; c < N - 1; c++) {
        		cnt = 0;
        		if (candyArr[r][c] == candyArr[r][c+1]) {
        			while (candyArr[r][c] == candyArr[r][c+1])
        				cnt++;
        		}
        		max = Math.max(max, cnt);
        	}
        }
        
        // 열 탐색
    	for (int c = 0; c < N; c++) {
    		for (int r = 0; r < N - 1; r++) {
    			cnt = 0;
        		if (candyArr[r][c] == candyArr[r+1][c]) {
        			while (candyArr[r][c] == candyArr[r+1][c])
        				cnt++;
        		}
        		max = Math.max(max, cnt);
        	}
        }
        
    	System.out.println(max);
    }
}