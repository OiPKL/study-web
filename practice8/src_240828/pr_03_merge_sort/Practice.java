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
		// TEST ************************************************
		System.out.println(Arrays.toString(arr) + "\tBefore: " + left + " ~ " + right);
		System.out.println();
		// TEST ************************************************
		// #1
		if (left == right) {
			return;
		}
		
		int mid = (left + right) / 2;
		// 앞쪽 절반
		mergeSort(left, mid);
		// 뒤쪽 절반
		mergeSort(mid + 1, right);
		// 병합
		merge(left, mid, right);
		
		// #2
//		if (left < right) {
//			int mid = (left + right) / 2;
//			mergeSort(left, mid);
//			mergeSort(mid + 1, right);
//			merge(left, mid, right);
//		}
		
		// TEST ************************************************
		System.out.println(Arrays.toString(arr) + "\t\t\tAfter: " + left + " ~ " + right);
		System.out.println();
		// TEST ************************************************

	}
	
	// left: 구간의 시작
	// mid: 왼쪽 파트의 끝 -> mid+1: 오른쪽 파트의 시작
	// right: 구간의 끝
	static void merge(int left, int mid, int right) {
		// 앞쪽 절반의 원소를 가리킬 포인터
		int L = left;
		// 뒤쪽 절반의 원소를 가리킬 포인터
		int R = mid + 1;
		// tmp 배열의 인덱스
		int idx = left;
		
		// L이 가리키는 값과 R이 가리키는 값을 비교해서 작은 값을 tmp 배열에 복사
		// 안정정렬 : 같은 값이 서로 다른 영역에 나오더라도 앞쪽 원소부터 배치하기 때문에 안정적임
		while(L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			} 
		}
		// 한쪽 포인터가 범위를 벗어난 경우
		// L이 벗어나지 않은 경우 = if 나머지 왼쪽 파트 존재
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		// R이 벗어나지 않은 경우 = if 나머지 오른쪽 파트 존재
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
