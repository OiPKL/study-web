package swea_240729.d4_3000_중간값구하기_failed;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int N = sc.nextInt();
		int A = sc.nextInt();
		
		int[] note = new int[2*N+1];
		note[0] = A;
		
		// 테스트케이스
		for (int i = 0; i < T; i++) {
			long mid = 0;
			long sum = 0;
			
			// 2*N개 숫자 입력
			for (int j = 1; j < 2*N; j+=2) {
				note[j] = sc.nextInt();
				note[j+1] = sc.nextInt();
				
				// 배열크기 3 : 3개 비교
				if (j == 1) {
					for (int k = 2; k > 0; k--) {
						for (int l = 0; l < k; l++) {
							if (note[l] > note[l+1]) {
								int tmp = note[l+1];
								note[l+1] = note[l];
								note[l] = tmp;
							}
						}
					}
				}
				
				// 배열크기 5~ : 중앙-1, 중앙, 중앙+1, 추가1, 추가2 비교
				if (j != 1) {
					int[] tmpNote = new int[5];
					tmpNote[0] = note[0];
					tmpNote[1] = note[1];
					tmpNote[4] = note[2];
					tmpNote[2] = note[j];
					tmpNote[3] = note[j+1];
					
					for (int k = 2; k > 0; k--) {
						for (int l = 0; l < k; l++) {
							if (note[l] > note[l+1]) {
								int tmp = note[l+1];
								note[l+1] = note[l];
								note[l] = tmp;
							}
						}
					}
				}
				
				// 중간값 ~ 합 ~ 나머지
				mid = note[2];
				sum += mid;
				if (sum >= 20171109) sum %= 20171109;
				
			}
			
			System.out.printf("#%d " + sum, i+1);
		
		}
		
	}
}
