package swea;

import java.util.Scanner;

public class Solution {
	
	static int[] P;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			P = new int[N + 1];
			int[][] edges = new int[M][2];
			
			for (int m = 0; m < M; m++) {
				edges[m][0] = sc.nextInt();
				edges[m][1] = sc.nextInt();
			}
			
			for (int n = 1; n < N; n++) {
				makeSet(n);
			}
			
			for (int m = 0; m < M; m++) {
				
				int px = findSet(edges[m][0]);
				int py = findSet(edges[m][1]);
				
				if (px != py) {
					union(px, py);
				}
				
				for (int num : P)
					System.out.print(num + " ");
				System.out.println();
				
			}
			
			int ans = 1;
			int tmp = P[1];
			for (int n = 2; n <= N; n++) {
				if (P[n] != tmp) {
					tmp = P[n];
					ans++;
				}
			}
			
//			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
	static void makeSet (int x) {
		P[x] = x;
	}
	
	static int findSet (int x) {
		if (x != P[x])
			P[x] = findSet(P[x]);
		return P[x];
	}
	
	static void union(int x, int y) {
		P[y] = x;
	}
	
}