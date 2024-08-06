package pr_02_factorial;

public class Practice {
	public static void main(String[] args) {
		
		System.out.println(factorial1(10));
//		System.out.println(factorial2(10));	// >> StackOverFlow Error
		System.out.println(factorial3(10));
		
	}

	static int factorial1 (int N) {
		int result = 1;
		for (int i = 1; i <= N; i++) {
			result *= i;
		}
		return result;
	}
	
	static int factorial2(int N) {
		return N * factorial2(N - 1);
	}
	
	static int factorial3(int N) {
		if (N == 0 || N == 1)
			return 1;
		return N * factorial3(N - 1);
	}
	
}
