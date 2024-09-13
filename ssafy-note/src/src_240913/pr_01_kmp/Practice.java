package src_240913.pr_01_kmp;

public class Practice {
	public static void main(String[] args) {
		
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
		
		KMP(text, pattern);
	}
	// T: Text
	// P: Pattern
	static void KMP(String T, String P) {
		int[] pi = getPi(P);				// 점프테이블 준비
		
		int j = 0;							// j = 패턴의 인덱스
											// i = 본문의 인덱스
		for (int i = 0; i < T.length(); i++) {
			
			// 달랐을 때
			while (j > 0 && T.charAt(i) != P.charAt(j))
				j = pi[j - 1];				// 점프
			
			// 같았을 때
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					System.out.println((i - P.length() + 1) + "위치 부터 시작!");
					j = pi[j];
				} else
					j++;
			} 
		}
	}
	
	// pi : 패턴 Pf를 i 인덱스까지 잘라서 (부분문자열)
	// 접두사와 접미사가 일치하는 최대길이를 담을 배열
	static int[] getPi(String P) {
		int[] pi = new int[P.length()];
		
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			// i != j
			while (j > 0 && P.charAt(i) != P.charAt(j))
				j = pi[j - 1];
			// i == j
			if (P.charAt(i) == P.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}
	
}
