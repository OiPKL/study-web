package pr_03_selection_search;
import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
	
		int[] arr = {10, 64, 25, 11, 28, 77, 34}; 
		
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	static void selectionSort(int[] arr) {

		// 사이클 횟수 : 배열 길이 - 1
		for (int i = 0; i < arr.length; i++) {
			
			int minIdx = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j])
					minIdx = j;
			}
			// swap : i <-> minIdx
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
			
		}
	}
	
}
