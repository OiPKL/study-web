package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] NN = new int[N];
		boolean checked = false;
		for (int n = 0; n < N; n++)
			NN[n] = sc.nextInt();
		
		for (int n = N - 1; n > 0; n--) {
			if (NN[n - 1] < NN[n]) {
				// Swap
				int tmp = NN[n - 1];
				NN[n - 1] = NN[n];
				NN[n] = tmp;
				
				Arrays.sort(NN, n, N);
				checked = true;
				break;
			}
		}
		
		if (checked) {
			for (int num : NN)
				sb.append(num).append(" ");
			System.out.println(sb);
		} else
			System.out.println(-1);
		
	}
}
