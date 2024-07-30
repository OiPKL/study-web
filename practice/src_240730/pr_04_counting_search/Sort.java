package pr_04_counting_search;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] arr = { 4, 9, 11, 23, 2, 19, 7 };

		countingSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void countingSort(int[] arr) {
		
		// 원소의 범위(최댓값 K) 확인
		int K = -1;
		for (int i = 0; i < arr.length; i++) {
			K = Math.max(K, arr[i]);
		}

		// count 배열 index : 0 ~ K
		// arr[i]에 해당하는 index++
		int[] count = new int[K + 1];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		// count 배열 => 누적합 배열
		// 누적합 배열 count[i] = count[0] ~ count[i] 합
		// count 배열 : 해당 원소가 몇개 등장?
		// 누적합 배열 : 해당 원소가 몇번째 위치까지 존재?
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		// 안정 정렬 : 역방향 순회하며 정렬
		int[] sortedArr = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			sortedArr[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArr[i];
        }
		
	}
}
