package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static long cnt;
	static int N;
	static int M;
	static int[][] order;
	static List<Integer> runner;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			cnt = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			order = new int[M][2];
			runner = new ArrayList<>();
			
			for (int m = 0; m < M; m++) {
				order[m][0] = sc.nextInt();
				order[m][1] = sc.nextInt();
			}

			makeRunnerOrder();
			
			System.out.println("#" + tc + " " + cnt);
			
		}
		
	}
	
	static boolean isValid() {
		
		for (int n = 0; n < N; n++) {
			int runnerA = runner.get(n);
			
			for (int m = 0; m < M; m++) {
				if (order[m][0] == runnerA) {
					int runnerB = order[m][1];
					
					for (int i = 0; i < n; i++) {
						if (runner.get(i) == runnerB) {
							return false;
						}
					}
					
				}
			}
		}

		return true;
		
	}
	
	static void makeRunnerOrder() {
		
		if (runner.size() == N) {
			if (isValid()) cnt++;
			return;
		}
		
		for (int n = 1; n <= N; n++) {
			runner.add(n);
			makeRunnerOrder();
			runner.remove(runner.size() - 1);
		}
		
	}
	
}
