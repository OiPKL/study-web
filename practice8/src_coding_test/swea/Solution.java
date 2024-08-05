package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int K = sc.nextInt();
			List<Integer> arr = new ArrayList<>();
			
			for (int k = 0; k < K; k++) {
				arr.add(sc.nextInt());
			}

			int cnt = 0;
			for (int k = 0; k < K; k++) {
				if (arr.get(k) == 0) cnt++;
			}
			
			for (int c = 0; c < cnt; c++) {
				arr.remove(arr.size() - 1);
			}
			
			if (arr.size() == 0)
				// 다 지워지는 경우는 마지막이 0인 경우 뿐임
				System.out.println("#" + t + " " + 0);
			else
				System.out.println("#" + t + " " + (arr.get(arr.size() - 1)));
		}
		
	}	
}