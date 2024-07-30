package pr_01_sequential_search;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] arr = {4, 9, 11, 23, 2, 19, 7};
		int key = 7;
		int result = searchForNoSort(arr, key);
		int result2 = searchWhileNoSort(arr, key);
		System.out.println(result);
		System.out.println(result2);
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int result3 = searchForSort(arr, key);
		int result4 = searchWhileSort(arr, key);
		System.out.println(result3);
		System.out.println(result4);
		
	}
	
	static int searchForNoSort(int[] arr, int key) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
		
	}
	
	static int searchWhileNoSort(int[] arr, int key) {
		
		int i = 0;
		while(i < arr.length) {
			if (arr[i] == key) {
				return i;
			}
			i++;
		}
		return -1;

	}
	
	static int searchForSort(int[] arr, int key) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
			else if (arr[i] > key)
				return -1;
		}
		return -1;
		
	}
	
	static int searchWhileSort(int[] arr, int key) {
		
		int i = 0;
		while(i < arr.length) {
			if (arr[i] == key) {
				return i;
			} else if (arr[i] > key)
				return -1;
			i++;
		}
		return -1;

	}
}
