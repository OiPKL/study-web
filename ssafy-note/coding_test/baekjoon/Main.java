package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dn = {0, 1, 0, -1};
	static int[] dm = {1, 0, -1, 0};
	
	static int N, M;
	static int[][] miro;
	static boolean[][] visited;
	
	static Queue<int[]> bfs1;
	static Queue<int[]> bfs2;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		miro = new int[N][M];
		visited = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			String line = sc.nextLine();
			for (int m = 0; m < M; m++) {
				char ch = line.charAt(m);
				miro[n][m] = ch - '0';
			}
		}

		searchingBeforeBomb();
        
        System.out.println(-1);
	}
	
	static void searchingBeforeBomb() {
		
		bfs1 = new LinkedList<>();

		bfs1.add(new int[] {0, 0, 1});
		visited[0][0] = true;
		
	}
	
	static void searchingAfterBomb() {
		
	}
}