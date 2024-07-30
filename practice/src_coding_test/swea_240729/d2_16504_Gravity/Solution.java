package swea_240729.d2_16504_Gravity;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int[] gravity = new int[N];
			
			int maxDrop = 0;
			
			for (int n = 0; n < N; n++) {
				gravity[n] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				int drop = 0;
				for (int j = i + 1; j < N; j++) {
					if (gravity[i] > gravity[j]) {
						drop++;
					}
				}
				maxDrop = Math.max(maxDrop, drop);
			}
			
			System.out.println("#" + t + " " + maxDrop);
		}
		
	}
}