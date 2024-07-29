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
			int cnt = 1;
			long mid = 0;
			long sum = 0;
			
			// 2*N개 숫자 입력
			for (int j = 1; j < 2*N; j+=2) {
				note[j] = sc.nextInt();
				note[j+1] = sc.nextInt();
				cnt += 2;
				
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
				
				if (j != 1) {
					int[] note = new int[5];
					tmp[0] = note[0];
					tmp[1] = note[1];
					tmp[4] = note[2];
					tmp[2] = note[j];
					tmp[3] = note[j+1];
					
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
				
				
				
				// 버블정렬
				for (int k = cnt - 1; k > 0; k--) {
					for (int l = 0; l < k; l++) {
						if (note[l] > note[l+1]) {
							int tmp = note[l+1];
							note[l+1] = note[l];
							note[l] = tmp;
						}
					}
				}
				
				// 중간값 ~ 합 ~ 나머지
				mid = note[cnt/2];
				sum += mid;
				if (sum >= 20171109) sum %= 20171109;
				
			}
			
			System.out.printf("#%d " + sum, i+1);
		
		}
		
	}
}
