package baekjoon;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		
		int[] nums = new int[100];
		
		int idx = 0;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				nums[idx++] = i * j;
			}
		}
		
		Arrays.sort(nums);
		
		for (int i = 0; i < 100; i++) {
			sb.append(i).append(" ").
		}
	}
}