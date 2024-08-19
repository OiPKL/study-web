package swea_failed.d4_3234_준환이의양팔저울;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[] chu = new int[N];
			List<Integer> chu1 = new ArrayList<>();
			List<Integer> chu2 = new ArrayList<>();
			sum = 0;
			sum1 = 0;
			sum2 = 0;
			for (int n = 0; n < N; n++) {
				int num = sc.nextInt();
				chu[n] = num;
				sum += num;
			}
			
			cnt = 0;
			setChu(chu, chu1, chu2, 0);
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	static int sum = 0;
	static int sum1 = 0;
	static int sum2 = 0;
	static int cnt = 0;
	
	static void setChu(int[] chu, List<Integer> chu1, List<Integer> chu2, int start) {
		
		if (sum1 < sum2) return;
		if (sum == sum1 + sum2) {
			
			cnt++;
			
			// TEST ------------------------------------------------
			System.out.println("cnt: " + cnt);
			for (int num : chu1)
				System.out.print(num + " ");
			System.out.println();
			for (int num : chu2)
				System.out.print(num + " ");
			System.out.println();
			System.out.println("**********************************");
			// TEST ------------------------------------------------
			
			return;
		}
		
		int N = chu.length;
		for (int n = start % N; n < start % N + N; n++) {
			
			int num = chu[n];
			
			for (int m = 0; m < chu1.size(); m++) {
				if (num == chu1.get(m)) {
					chu1.remove(m);
					sum1 -= num;
				}
			}
			chu2.add(num);
			sum2 += num;

			setChu(chu, chu1, chu2, start+1);
			
			chu2.remove(chu2.size() - 1);
			sum2 -= num;
			chu1.add(num);
			sum1 += num;
			
		}
		
	}
	
}