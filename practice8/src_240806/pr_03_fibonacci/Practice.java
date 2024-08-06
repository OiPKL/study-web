package pr_03_fibonacci;

public class Practice {

	public static void main(String[] args) {
		
		int result3 = mFibo(45);		// 매우빠름
		System.out.println(result3);
		
		int result2 = fibonacci2(45);	// 빠름
		System.out.println(result2);
		
		int result1 = fibonacci1(45);	// 느림
		System.out.println(result1);
		
	}

	static int fibonacci1(int N) {
		
		if (N <= 1)
			return N;
		return fibonacci1(N - 1) + fibonacci1(N - 2);
	}
	
	static int fibonacci2(int N) {
		int[] arr = new int[N+1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[N];
	}
	
	static int[] dp = new int[500];
	
	// Memoization 사용
	static int mFibo(int N) {
		if (N <= 1)
			return N;
		if (dp[N] > 0)
			return dp[N];
		
		return dp[N] = mFibo(N - 1) + mFibo(N - 2);
	}
	
}
