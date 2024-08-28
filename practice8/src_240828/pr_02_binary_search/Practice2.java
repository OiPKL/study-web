package pr_02_binary_search;

import java.util.Arrays;

public class Practice2 {
	
	static int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
	static int key = 19;
	
	public static void main(String[] args) {
		binarySearch(0, arr.length - 1);
		System.out.println();
		// Arrays.binarySearch -> 배열과 key 입력
		Arrays.binarySearch(arr, 0);
	}
	
	// 이진 검색 : 정렬된 배열에서만 사용가능
	static boolean binarySearch(int left, int right) {
		// 기저조건
		if (left > right) return false;
		// 재귀부분
		int mid = (left + right) / 2;
		// 중앙값과 같다
		if (arr[mid] == key) return true;
		// 중앙값이 크다 -> 왼쪽구간으로
		else if (arr[mid] > key)
			return binarySearch(left, mid - 1);
		// 중앙값이 작다 -> 오른쪽구간으로
		else
			return binarySearch(mid + 1, right);
	}
}
