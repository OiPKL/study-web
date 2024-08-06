package programmers;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
		int[] arr2 = {4, 4, 4, 3, 3};
		
		int[] arr11 = solution(arr1);
		int[] arr22 = solution(arr2);
		
		for (int num : arr11)
			System.out.print(num + " ");
		System.out.println();
		for (int num : arr22)
			System.out.print(num + " ");
		System.out.println();
		
	}
	
	static int[] solution(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (stack.isEmpty())
				stack.add(arr[i]);
			else if (arr[i] != stack.peek())
				stack.add(arr[i]);
			else continue;
		}
		
		int[] Arr = new int[stack.size()];
		
		for (int i = Arr.length - 1; i >= 0; i--)
			if (!(stack.isEmpty())) Arr[i] = stack.pop();
		
		return Arr;
		
	}
}