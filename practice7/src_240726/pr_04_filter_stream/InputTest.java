package pr_04_filter_stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 파일 입력
		// FileInputStream 	 : 표준입력(키보드)
		// InputStreamReader : byte -> character
		// BufferedReader	 : buffer 기능 추가
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(Arrays.toString(nums));
		
	}
}