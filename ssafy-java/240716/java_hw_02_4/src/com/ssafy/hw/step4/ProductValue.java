package com.ssafy.hw.step4;

import java.util.Arrays;
import java.util.Scanner;

public class ProductValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] things = new int[N];
		int[] cnts = new int[N];
		
		for (int i = 0; i < N; i++) {
			things[i] = sc.nextInt();
			cnts[i] = 1;
		}
		sc.close();
		
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (k == j) continue;
				if (things[j] < things[k]) {
					cnts[j]++;
				}
			}
		}
		
		System.out.println(Arrays.toString(cnts));
	}

}
