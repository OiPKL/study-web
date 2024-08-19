package com.ssafy.ws.step4;

import java.util.Scanner;

public class AirCrashes {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int[] crash = new int[N];
		
		for (int i = 0; i < N; i++) {
			crash[i] = sc.nextInt();
		}
		
		int max = crash[0];
		int min = crash[0];
		
		for (int i = 0; i < N; i++) {
			if (crash[i] > max) max = crash[i];
			if (crash[i] < min) min = crash[i];
		}
		
		if (min == crash[N-1])
			System.out.println(-1);
		else
			System.out.println(max - min);
		
	}
}
