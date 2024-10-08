package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int mod = 1_000_000_007;

	static int N, result;
	static int[] menu;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();

		menu = new int[N];
		for (int i = 0; i < N; i++)
			menu[i] = sc.nextInt();
		visited = new boolean[N];
		
		Arrays.sort(menu);
		
		result = 0;
		
		btk(0, 0, 0);
		
		System.out.println(result);
	}
	
	static void btk(int idx, int cnt, int sum) {
		
		System.out.println(idx + " | " + cnt + " | " + sum);
		System.out.println(Arrays.toString(visited));
		
		if (cnt > 1)
			result = (result + sum) % mod;
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				btk(i, cnt + 1, sum + menu[i]);
				visited[i] = false;
			}
		}
	}
}