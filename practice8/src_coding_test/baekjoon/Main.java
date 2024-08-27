package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 맨 뒤 num 추가
		// 2. 맨 뒤 원소 제거
		// >> 맨 뒤에서부터 최소 몇 개를 선택해야 mod로 나누었을 때
		//    0, 1, ... mod-1 경우가 최소 한 번 이상 ??
		
		int Q = sc.nextInt();	// Query 개수
		int M = sc.nextInt();	// mod
		
		Stack[] stackList = new Stack[M];
		
		int idx = 0;
		for (int q = 0; q < Q; q++) {
			int cmd = sc.nextInt();
			
			if (cmd == 1) {
				long num = sc.nextLong();
				stackList[(int) num % M].add(idx++);
			}
		}
		
	}
}