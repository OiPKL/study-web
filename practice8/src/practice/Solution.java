package practice;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			sc.nextLine();

			String[] card = new String[N];
			
			for (int n = 0; n < N; n++)
				card[n] = sc.next();
			sc.nextLine();
			
			System.out.print("#" + t + " ");
			for (String str : card)
				System.out.print(str + " ");
			System.out.println();
		}
		
	}
}