package pr_04_quick_sort;

import java.util.Arrays;

public class Practice2 {

	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;
	
	public static void main(String[] args) {
		quickSortLomuto(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSortLomuto(int left, int right) {
		if (left < right) {
			int pivot = partitionLomuto(left, right);
			quickSortLomuto(left, pivot - 1);
			quickSortLomuto(pivot + 1, right);
		}
	}
	
	// 반한값은 피봇의 위치
	static int partitionLomuto(int left, int right) {
		int pivot = arr[right];
		int i = left - 1;	// 작은 값들의 경계
		
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		return i+1;
	}
}
