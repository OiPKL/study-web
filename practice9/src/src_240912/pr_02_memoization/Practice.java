package src_240912.pr_02_memoization;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	
	static int[] callFibo = new int[1000];
	static int[] memo;						// 계산 값을 저장하기 위한 공간 할당
	
	static {
		memo = new int[1000];
		memo[0] = 0;
		memo[1] = 1;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibo2(N));
		System.out.println(Arrays.toString(callFibo));

	}
	
	static int fibo2(int n) {
		callFibo[n]++;
		if (n >= 2 && memo[2] == 0)
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		return memo[n];
	}
}
