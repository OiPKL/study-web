package IM;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[] startLed = new int[N+1];
			int[] targetLed = new int[N+1];
			for (int n = 1; n <= N; n++)
				targetLed[n] = sc.nextInt();
			
			int cnt = 0;
			while (!isPattern(startLed, targetLed)) {
				click(startLed, findNextI(startLed, targetLed));
				cnt++;
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	static int findNextI(int[] startLed, int[] targetLed) {
		int N = startLed.length;
		for (int n = 1; n < N; n++) {
			if (startLed[n] != targetLed[n])
				return n;
		}
		return 1;	// ���� (������ ������ ����)
		
	}
	
	static void click(int[] startLed, int i) {
		int N = startLed.length;
		for (int n = 1; n < N; n++) {
			if (n % i == 0) {
				if (startLed[n] == 0) 	startLed[n] = 1;
				else					startLed[n] = 0;
			}
		}
	}
	
	static boolean isPattern(int[] startLed, int[] targetLed) {
		int N = startLed.length;
		for (int n = 1; n < N; n++) {
			if (startLed[n] != targetLed[n]) return false;
		}
		return true;
	}
}