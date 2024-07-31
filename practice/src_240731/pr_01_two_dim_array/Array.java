package pr_01_two_dim_array;

import java.util.Arrays;

public class Array {
	
	public static void main(String[] args) {
			
	//	int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
			int[][] arr = new int[3][3];
			
			// 정방향 행 우선순회
			int num = 1;
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr[0].length; c++) {
					arr[r][c] = num++;
				}
			}
			
			// 1차원 배열 조회 -> 2차원 배열에 담긴 1차원 배열의 주소만 조회
			System.out.println(Arrays.toString(arr));
			System.out.println("정방향 행 우선순회");
			System.out.println(Arrays.deepToString(arr));
			
			// 역방향 행 우선순회
			num = 1;
			for (int r = 0; r < arr.length; r++) {
				for (int c = arr[0].length - 1; c >= 0; c--) {
					arr[r][c] = num++;
				}
			}
			
			System.out.println("역방향 행 우선순회");
			System.out.println(Arrays.deepToString(arr));
			
			// 정방향 열 우선순회
			num = 1;
			for (int c = 0; c < arr[0].length; c++) {
				for (int r = 0; r < arr.length; r++) {
					arr[r][c] = num++;
				}
			}
			
			System.out.println("정방향 열 우선순회");
			System.out.println(Arrays.deepToString(arr));
			
	}
	
}
