package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			int max = 0;
			int score = 0;
			int N = sc.nextInt();
			int[][] stk = new int[2][N];
			
			for (int r = 0; r < 2; r++)
				for (int c = 0; c < N; c++)
					stk[r][c] = sc.nextInt();
			
			
			
		}// tc
	}
}
