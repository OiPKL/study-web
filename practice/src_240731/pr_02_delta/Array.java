package pr_02_delta;

import java.util.Scanner;

public class Array {

	// 				   0  1  2  3
	// 				   상  하  좌  우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] map = new int[5][5];
	
	static int r = 2;
	static int c = 2;
	
	static void printMap() {
		for (int r2 = 0; r2 < map.length; r2++) {
			for (int c2 = 0; c2 < map[0].length; c2++) {
				if (r == r2 && c == c2)
					System.out.print('O');
				else
					System.out.print('+');
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		printMap();
		
		while (true) {
			System.out.println("어디로 가야 하오");
			int d = sc.nextInt();
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length) {
				r = nr;
				c = nc;
			} else
				System.out.println("경로를 벗어났습니다");
			
			printMap();
		}
		
	}
	
}
