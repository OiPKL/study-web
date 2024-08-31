package swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[][] room = new int[N][N];
			for (int n1 = 0; n1 < N; n1++) {
				int box = sc.nextInt();
				for (int n2 = 0; n2 < box; n2++) {
					room[n1][n2] = 1;
				}
			}

			Stack<Integer>[] rotatedRoom = new Stack[N];
			for (int n2 = 0; n2 < N; n2++) {
				rotatedRoom[n2] = new Stack<>();
			}
			
			int maxCnt = 0;
			for (int n2 = 0; n2 < N; n2++) {
				int cnt = 0;
				for (int n1 = N - 1; n1 >= 0; n1--) {
					if (room[n1][n2] == 1) {
						maxCnt = Math.max(maxCnt, cnt);
						cnt = 0;
					} else {
						
					}
				}
			}
			
		}
		
	}
}
