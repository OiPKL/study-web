package practice;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] ban = new int[N];
		int MIN = sc.nextInt();			// 반 최소인원
		int MAX = sc.nextInt();			// 반 최대인원
		int K1 = 101;					// score1 최소값
		int K2 = 0;						// score2 최대값
		for (int n = 0; n < N; n++) {
			ban[n] = sc.nextInt();
			K1 = Math.min(K1, ban[n]);
			K2 = Math.max(K2, ban[n]);
		}
		
		int ANS = 1001;
		for (int score1 = K1; score1 <= K2 - 1; score1++) {
			for (int score2 = score1 + 1; score2 <= K2; score2++) {
				
				int banA = 0;			// A반 인원
				int banB = 0;			// B반 인원
				int banC = 0;			// C반 인원
				
				for (int n = 0; n < N; n++) {
					if 		(ban[n] < score1) 						banA++;
					else if (score1 <= ban[n] && ban[n] < score2) 	banB++;
					else											banC++;
				}
				
				int MIN2 = 1001;
				int MAX2 = 0;
				
				if (MIN <= banA && banA <= MAX &&
					MIN <= banB && banB <= MAX &&
					MIN <= banC && banC <= MAX) {
					
					MIN2 = Math.min(MIN2, banA);
					MIN2 = Math.min(MIN2, banB);
					MIN2 = Math.min(MIN2, banC);
					MAX2 = Math.max(MAX2, banA);
					MAX2 = Math.max(MAX2, banB);
					MAX2 = Math.max(MAX2, banC);
				}
				
				if (MIN2 != 1001 && MAX2 != 0) {
					int TMP = MAX2 - MIN2;
					ANS = Math.min(ANS, TMP);
				}
				
			}
		}
		
		if (ANS == 1001) System.out.println(-1);
		else			 System.out.println(ANS);
		
	}
}
