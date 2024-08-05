package practice_algo;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		
		int[] arr = {21, 5, 12, 53, 23, 23, 2, 4};
		
		int K = -1;
		for (int i = 0; i < arr.length; i++)
			K = Math.max(K, arr[i]);
		
		int[] cnt = new int[K+1];
		for (int i = 0; i < arr.length; i++)
			cnt[arr[i]]++;
		
		for (int i = 1; i < cnt.length; i++)
			cnt[i] += cnt[i-1];
		
		int[] sortedArr = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			sortedArr[cnt[arr[i]]-- - 1] = arr[i];
		}
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = sortedArr[i];
		
		System.out.println(Arrays.toString(arr));
	}
}
