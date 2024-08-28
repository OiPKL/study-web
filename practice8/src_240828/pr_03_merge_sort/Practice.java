package pr_03_merge_sort;

import java.util.Arrays;

public class Practice {

	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;
	static int[] tmp = new int[N];	// 추가적이 공간
	
	public static void main(String[] args) {
		mergeSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	// left: 구간의 시작
	// right: 구간의 끝
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
		
	}
	
	// left: 구간의 시작
	// mid: 왼쪽 파트의 끝 -> mid+1: 오른쪽 파트의 시작
	// right: 구간의 끝
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		
		int idx = left;	// tmp 배열의 인덱스
		
		while(L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			} 
		}
		// if 나머지 왼쪽 파트 존재
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		// if 나머지 오른쪽 파트 존재
		} else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		// 원본 배열에 반영
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}
	
}
