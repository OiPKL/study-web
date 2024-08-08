package pr_02_insertion_sort;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		
		int[] arr = new int[] { 69, 10, 30, 2, 16, 8, 31, 22 };
		
		// i : 정렬되지 않은 부분집합 U의 첫번째 원소
		// [0] : 정렬된 부분집합 S의 원소
		for (int i = 1; i < arr.length; i++) {
			// tmp 역할 : 비교할 
			int data = arr[i];
			// 부분집합 S의 뒤에서부터 비교하며 위치 찾기
			int j;
			for (j = i - 1; j >= 0 && arr[j] > data; j--) {
					arr[j + 1] = arr[j];
			}
			arr[j + 1] = data;
			System.out.println(Arrays.toString(arr));
		}
		
	}
}
