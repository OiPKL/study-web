package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//  💡 int 1과 char '1'은 다름! - 문자로서의 '1'
		//  - 해당 문자의 정수값 확인
		char ch_b1 = '1';
		char ch_b2 = '2';
		
		//  ⚠️ 숫자 문자에 사칙연산 - 문자 번호 기준 결과 반환
		char ch_b3 = '1' + '2';
		int int_b4 = ch_b1 + ch_b2;
		
		System.out.println(ch_b3);
		System.out.println(int_b4);

	}
}