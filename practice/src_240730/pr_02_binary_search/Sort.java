package pr_02_binary_search;

public class Sort {

	public static void main(String[] args) {
		
		int[] arr = {2, 4, 7, 9, 11, 19, 23, 30};
		
		int result = binarySearch(arr, 11);
		System.out.println(result);
		
	}
	
	static int binarySearch(int[] arr, int key) {
		int left = 0;					// 구간의 시작 index
		int right = arr.length - 1;		// 구간의 끝 index
		
		while(left <= right) {			// right-left 역전되는 경우 Stop
			int mid = (left + right) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				left = mid + 1;
			} else // (arr[mid] > key)
				right = mid -1;
		}
		return -1;
	}
	
}
