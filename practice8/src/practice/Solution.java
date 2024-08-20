package practice;

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
			for (int n = 0; n < N; n++)
				for (int m = 0; m < N; m++)
					SNJ[n][m] = sc.nextInt();

		int great = 0;
		simulation = new ArrayList<>();
		combination(new int[N], new boolean[N], 0, N, N/2, new ArrayList<>());
		
		System.out.println(simulation.size());
		
		System.out.println("#" + tc + " " + great);
		}
	}
	
	static List<int[]> simulation;
	
	static void combination(int[] arr, boolean[] used, int start, int n, int r, List<Integer> food) {
	    if(r == 0) {
			for (int num : food)
				System.out.print(num + " ");
			System.out.println();
			
	        return;
	    } 

	    for(int i = start; i < n; i++) {
	        used[i] = true;
	        food.add(i);
	        combination(arr, used, i + 1, n, r - 1, food);
	        used[i] = false;
	        food.remove(food.size() - 1);
	    }
	}
	
}
