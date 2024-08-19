package com.ssafy.ws.step3;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] swtch = new int[N];
		
		for (int i = 0; i < M; i++) {
			int X = sc.nextInt();
			
			for (int j = 0; j < swtch.length; j++) {
				if ((j+1) % X == 0)
					swtch[j] = 1;
			}
		}
		
		for (int i : swtch)
			System.out.print(i + " ");
			
	}
}
