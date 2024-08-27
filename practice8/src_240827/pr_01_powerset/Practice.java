package pr_01_powerset;

import java.util.Arrays;

public class Practice {
	
	static String[] 재료 = {"단무지", "햄", "오이", "시금치"};
	static int N = 4;
	static int[] kimbab1 = new int[N];
	static int[] kimbab2 = new int[N];
	static boolean[] kimbab3 = new boolean[N];
	
	public static void main(String[] args) {
		
		// 반복문 사용
		// 재료가 4개 => 반복문 4개 필요
		for (int i = 0; i < 2; i++) {				// 단무지
			kimbab1[0] = i;
			for (int j = 0; j < 2; j++) {			// 햄
				kimbab1[1] = j;
				for (int k = 0; k < 2; k++) {		// 오이
					kimbab1[2] = k;
					for (int l = 0; l < 2; l++) {	// 시금치
						kimbab1[3] = l;
						System.out.println(Arrays.toString(kimbab1));
					}
				}
			}
		}
		System.out.println();
		
		// 비트마스킹 사용
		// 1 << N : 2^N 만큼 반복한다
		// i => 그 자체가 하나의 김밥 종류의 수 !!
		for (int i = 0; i < (1 << N); i++) {		// 1 << N == 2^N
			// 재료 확인 반복문 필요
			String tmp = "김밥: ";
			for (int j = 0; j < N; j++) {
//				if ((i & (1 << j)) != 0) {			// == 1? X
				if ((i & (1 << j)) == 1 << j) {		// > 0   O
					tmp += 재료[j];
				}
			}
			System.out.println(tmp);
		}
		System.out.println();
		
		// 재귀함수 사용
		powerset(0);
	}
	
	// idx : 내가 어떤 재료를 선택할지에 대한 인덱스
	static void powerset(int idx) {
		// 기저조건
		if (idx == N) {			// 모든 재료를 전부 검사함
			String tmp = "김밥: ";
			for (int i = 0; i < N; i++) {
				if (kimbab3[i]) tmp += 재료[i];
			}
			System.out.println(tmp);
			return;
		}
		// 재귀부분
		kimbab3[idx] = true;	// 해당 위치의 재료를 사용함
		powerset(idx + 1);
		kimbab3[idx] = false;	// 해당 위치의 재료를 사용안함
		powerset(idx + 1);
	}
}
