package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int tmp = N;
			if (M > N) {
				N = M;
				M = tmp;
			} else if (M == N) {
				System.out.println(1);
				continue;
			}
			
			long cnt = 1;
			for (int j = N; j >= N-M+1; j--) {
				cnt *= j;
			}
			for (int j = M; j >= 1; j--) {
				cnt /= j;
			}
			System.out.println(cnt);
						
		}
		
	}
}