package practice;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[] chu = new int[N];
			int[] chuL = new int[N];
			int[] chuR = new int[N];
			sum = 0;
			sumL = 0;
			sumR = 0;
			for (int n = 0; n < N; n++) {
				int num = sc.nextInt();
				chu[n] = num;
				sum += num;
			}
			
			cnt = 0;
			setChu(chu, chuL, chuR);
			
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	static int cnt = 0;
	static int sum = 0;
	static int sumL = 0;
	static int sumR = 0;
	
	static void setChu(int[] chu, int[] chuL, int[] chuR) {
		if (sumL < sumR) return;
		if (sum == sumL + sumR) {
			cnt++;
			return;
		}
		
		setChu:
		for (int n = 0; n < chu.length; n++) {
			for (int m = 0; m < chuL.length; m++)
				if (chu[m] == chuL[m]) continue setChu;
			
			chuL[n] = chu[n];
			sumL += chu[n];
			if (chuR[n] == chu[n]) {
				chuR[n] = 0;
				sumR -= chu[n];
			}
			
			setChu(chu, chuL, chuR);
			
			chuR[n] = chu[n];
			sumR += chu[n];
			if (chuL[n] == chu[n]) {
				chuL[n] = 0;
				sumL -= chu[n];
			}
		}
		
	}
	
}
