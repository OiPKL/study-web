package swea;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			
			int K = -1;
			for (int i = 0; i < arr.length; i++)
				K = Math.max(K, arr[i]);
			
			int[] cnt = new int[K+1];
			for (int i = 0; i < arr.length; i++)
				cnt[arr[i]]++;
			
			for (int i = 1; i < cnt.length; i++)
				cnt[i] += cnt[i-1];
			
			int[] arr2 = new int[arr.length];
			for (int i = arr2.length - 1; i >= 0; i--)
				arr2[cnt[arr[i]]-- - 1] = arr[i];
			
			System.out.print("#" + t + " ");
			for (int num : arr2)
				System.out.print(num + " ");
			System.out.println();
		}
		
	}	
}