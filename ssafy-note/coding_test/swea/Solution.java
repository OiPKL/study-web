package swea;

import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			int[] now = new int[] {-1, -1, 0};
			int[] goal = new int[] {-1, -1};
			char[][] map = new char[N][N];
			
			for (int r = 0; r < N; r++) {
				String line = sc.nextLine();
				map[r] = line.toCharArray();
				
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'X') {
						now = new int[] {r, c, 0};
					}
					if (map[r][c] == 'Y') {
						goal = new int[] {r, c};
					}
				}
			}
			
			int rNow = now[0];
			int cNow = now[1];
			int dWay = now[2];

			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}