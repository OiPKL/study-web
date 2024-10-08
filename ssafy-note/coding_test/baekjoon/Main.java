package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int mod = 1_000_000_007;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// S:3000 L:300000
		
		long[] food = new long[N];
		for (int n = 0; n < N; n++)
			food[n] = sc.nextLong();
		
		Arrays.sort(food);
		
		long sum = 0L;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				
			}
		}
	}
}