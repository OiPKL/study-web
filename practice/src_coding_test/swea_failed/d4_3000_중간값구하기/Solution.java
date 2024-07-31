package swea_failed.d4_3000_중간값구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			long A = sc.nextInt();
			
			List<Long> Note = new ArrayList<>();
			Note.add(A);
			
			int idx = 0;
			long mid = 0;
			long sum = 0;
			
			for (int n = 0; n < N; n++) {
				long new1 = sc.nextLong();
				long new2 = sc.nextLong();

				Note.add(new1);
				Note.add(new2);
				
				Collections.sort(Note);
				idx = Note.size()/2;
				mid = Note.get(idx);
				sum += mid;
				if (sum >= 20171109) sum %= 20171109;
				
				// test
//				for (long num : Note)
//					System.out.print(num + " ");
//				System.out.println();
				
			}
			
			System.out.printf("#%d " + sum, t);
			
		}
		
		sc.close();
		
	}
}
