package pr_02_reverse;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		
		// Java 에서는 문자열 읽기는 가능, 특정 위치 문자 쓰기 X
		String str = new String("Hello SSAFY");
		
		// char 문자 배열 생성(1)
		char[] charArr = new char[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		System.out.println("charArr: " + Arrays.toString(charArr));
		System.out.println();
		
		// char 문자 배열 생성(2) : toCharArray 메서드
		char[] charArr2 = str.toCharArray();
		
		System.out.println("charArr2: " + Arrays.toString(charArr2));
		System.out.println();
		
		
		
		// 문자열 뒤집기
		// 1. 새로운 빈 문자열을 만들어 뒤에서부터 사용
		char[] nextArr = new char[charArr.length];
		
		// 원본 배열을 정방향 순회하면서
		for (int i = 0; i < charArr.length; i++) {
			nextArr[charArr.length - 1 - i] = charArr[i];
		}
		
		System.out.println("nextArr: " + Arrays.toString(nextArr));
		System.out.println();
		
		// 2. 원본 문자열에서 swap 사용
		
		// 절반만큼 반복 수행
		int N = charArr2.length;
		for (int i = 0; i < N / 2; i++) {
			char tmp = charArr2[i];
			charArr2[i] = charArr2[N - 1 - i];
			charArr2[N - 1 - i] = tmp;
		}
		
		System.out.println("charArr2 : " + Arrays.toString(charArr2));
		System.out.println();	
		
		
		
		// 문자 배열 -> 문자열 = 비효율적
		String nextStr = "";
		
		// 문자열을 더하는 과정 반복마다 새로운 문자열 객체 생성
		for (int i = 0; i < charArr2.length; i++) {
			nextStr += charArr2[i];
		}
		
		System.out.println("nextStr: " + nextStr);
		
	}
	
}
