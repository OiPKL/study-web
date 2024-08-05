package practice_algo;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {21, 5, 12, 53, 23, 23, 2, 4};
		
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j])
					minIdx = j;
			}
			int tmp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = tmp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
