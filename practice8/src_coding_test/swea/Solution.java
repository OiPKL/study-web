package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[][] SNJ = new int[N][N];
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					SNJ[n][m] = sc.nextInt();
				}
			}
			
			simulation = new ArrayList<>();
			int great = Integer.MAX_VALUE;
			combination(N, new boolean[N], 0, new ArrayList<>());
			
			System.out.println("#" + tc + " " + great);
		}
	}
	
	static List<List<Integer>> simulation;
	
	static void combination(int N, boolean[] used, int start, List<Integer> food) {
		if (food.size() == N/2) {
			simulation.add(food);
			for (int num : food)
				System.out.print(num + " ");
			System.out.println();
			return;
		}	
		
		for (int n = start; n < N; n++) {
			if (used[n]) continue;
			used[n] = true;
			combination(N, used, start + 1, food);
			used[n] = false;
		}
		
	}
	
}