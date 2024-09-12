package src_240912.pr_01_fibonacci;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibo1(N));

	}
	
	static int fibo1(int n) {
		// 기저조건
		// n == 0 : 0을 반환
		// n == 1 : 1을 반환
		if (n < 2) return n;
		return fibo1(n - 1) + fibo1(n - 2);
	}
}
