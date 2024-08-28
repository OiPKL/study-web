package pr_04_quick_sort;

import java.util.Arrays;

public class Practice {

	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;
	
	public static void main(String[] args) {
		quickSortHoare(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSortHoare(int left, int right) {
		if (left < right) {
			int pivot = partitionHoare(left, right);
			quickSortHoare(left, pivot - 1);
			quickSortHoare(pivot + 1, right);
		}
	}
	
	// 반한값은 피봇의 위치
	static int partitionHoare(int left, int right) {
		int pivot = arr[left];
		
		int L = left + 1, R = right;
		
		while (L <= R) {
			// L: pivot 보다 큰 값을 찾을 때까지 이동
			while (L <= R && arr[L] <= pivot)
				L++;
			// R: pivot 보다 작거나 같은 값을 만날 때까지 이동
			while (arr[R] > pivot)
				R--;
			
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// R의 위치는 pivot 이 가야할 위치
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;	// pivot 위치
	}
}
