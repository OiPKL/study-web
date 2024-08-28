package pr_02_binary_search;
public class Practice {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };

		System.out.println(binarySearch(arr, 19));
	}

	// 이진 검색 : 정렬된 배열에서만 사용가능
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			// -> Overflow 문제가 생길 수 있다..
			int mid = (left + right) / 2;

			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return false;
	}
}