package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		decreasingNums.add(0);					// 첫째자리 0 * digit = 0 해결
		getDecreasingNums(0, 10, 1, 1, N);		// preDigit = 10 : nextDigit = 0 ~ 9
		if (cnt >= N) 	System.out.println(decreasingNums.get(N-1));
		else 			System.out.println(-1);
		
	}
	
	static int cnt = 1;
	static List<Integer> decreasingNums = new ArrayList<>();
											// 앞자리수		현재자리수			전체자리수
	static void getDecreasingNums(int num, int preDigit, int currDigit, int totalDigit, int N) {
		
		for (int digit = 0; digit < preDigit; digit++) {
			if (num == 0 && digit == 0) continue;
			num = num*10 + digit;
			decreasingNums.add(num);
			cnt++;
			if (cnt >= N) return;
			getDecreasingNums(num, digit, ++currDigit, totalDigit, N);
			num /= 10;
		}
		
		getDecreasingNums(0, 10, 1, ++totalDigit, N);
		
	}
	
}