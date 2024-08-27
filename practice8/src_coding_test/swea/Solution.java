package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] SJR;
	static List<List<Integer>> foodsList;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			SJR = new int[N][N];
			foodsList = new ArrayList<>();
			for (int n1 = 0; n1 < N; n1++)
				for (int n2 = 0; n2 < N; n2++)
					SJR[n1][n2] = sc.nextInt();
			
			combination(0, new ArrayList<>());
			
			int minGap = Integer.MAX_VALUE;
			for (int fl = 0; fl < foodsList.size(); fl++) {
				List<Integer> foods = foodsList.get(fl);
				List<Integer> foodA = new ArrayList<>();
				List<Integer> foodB = new ArrayList<>();
				
				boolean[] isFoodA = new boolean[N];
				for (int n = 0; n < N/2; n++)
					isFoodA[foods.get(n)] = true;
				
				for (int n = 0; n < N; n++) {
					if (isFoodA[n])	foodA.add(n);
					else			foodB.add(n);
				}
				
				int scoreA = 0;
				for (int a1 = 0; a1 < N/2 - 1; a1++) {
					for (int a2 = a1 + 1; a2 < N/2; a2++) {
						int idx1 = foodA.get(a1);
						int idx2 = foodA.get(a2);
						scoreA += (SJR[idx1][idx2] + SJR[idx2][idx1]);
					}
				}
				int scoreB = 0;
				for (int b1 = 0; b1 < N/2 - 1; b1++) {
					for (int b2 = b1 + 1; b2 < N/2; b2++) {
						int idx1 = foodB.get(b1);
						int idx2 = foodB.get(b2);
						scoreB += (SJR[idx1][idx2] + SJR[idx2][idx1]);
					}
				}
				int gap = Math.abs(scoreA - scoreB);
				minGap = Math.min(minGap, gap);
						
			}
			
			System.out.println("#" + tc + " " + minGap);
		
		}
		
	}
	
	static void combination(int idx, List<Integer> foods) {
		if (foods.size() == N/2) {
			foodsList.add(new ArrayList<>(foods));
			return;
		}
		
		for (int i = idx; i < N; i++) {
			foods.add(i);
			combination(i + 1, foods);
			foods.remove(foods.size() - 1);
		}
	}
	
}
