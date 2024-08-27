package pr_02_combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
	
	static String[] 재료 = {"상추", "패티", "토마토", "치즈"};
	static int N = 4;
	static int R = 2;
	static String[] hamburger1 = new String[R];
	static String[] hamburger2 = new String[R];
	
	public static void main(String[] args) {
		
		// 재귀함수 사용
		combination1(0, 0);
		System.out.println();
		
		// 반복문 사용
		combination2(0, 0);
		System.out.println();
		
		// 재귀함수 & 반복문 사용
		combination3(0, new ArrayList<>());
		System.out.println();
		
	}
	
	// idxN : 재료의 인덱스
	// idxR : 뽑은 재료의 인덱스
	static void combination1(int idxN, int idxS) {
		// 기저조건
		if (idxS == R) {				// R만큼 전부 검사함
			System.out.println(Arrays.toString(hamburger1));
			return;
		}
		if (idxN == N)
			return;
		
		// 재귀부분
		hamburger1[idxS] = 재료[idxN];	// 해당 위치의 재료를 사용함
		combination1(idxN + 1, idxS + 1);
//		hamburger1[idxS] = null;		// 해당 위치의 재료를 사용안함
		combination1(idxN + 1, idxS);
	}
	
	static void combination2(int idxN, int idxS) {
		// 기저조건
		if (idxS == R) {				// R만큼 전부 검사함
			System.out.println(Arrays.toString(hamburger2));
			return;
		}
		
		// 반복문
		for (int i = idxN; i <= N-R+idxS; i++) {
			hamburger2[idxS] = 재료[i];	// 해당 위치의 재료를 사용함
			combination2(i + 1, idxS + 1);
		}
		
	}
	
	static void combination3(int idxN, List<String> hamburger3) {
		if (hamburger3.size() == R) {
			for (String str : hamburger3)
				System.out.print(str + " ");
			System.out.println();
			return;
		}
		
		for (int i = idxN; i < N; i++) {
			hamburger3.add(재료[i]);
			combination3(i + 1, hamburger3);
			hamburger3.remove(hamburger3.size() - 1);
		}
	}
	
}
