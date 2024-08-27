package baekjoon_failed.S4_17162_가희의수열놀이Small;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int Q;
	static int M;
	static List<Long> arr;
	static int[] mod1;
	static int[] mod2;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 맨 뒤 num 추가
		// 2. 맨 뒤 원소 제거
		// >> 맨 뒤에서부터 최소 몇 개를 선택해야 mod로 나누었을 때
		//    0, 1, ... mod-1 경우가 최소 한 번 이상 ??
		
		Q = sc.nextInt();	// Query 개수
		M = sc.nextInt();	// mod 1,2
		
		arr = new ArrayList<>();
		mod1 = new int[M];
		
		for (int q = 0; q < Q; q++) {
			int cmd = sc.nextInt();
			
			if (cmd == 1) {
				long num = sc.nextLong();
				arr.add(num);
				mod1[(int) (num % M)]++;
			} else if (cmd == 2) {
				if (!arr.isEmpty()) {
					long num = arr.get(arr.size() - 1);
					mod1[(int) (num % M)]--;
				}
			} else {
				if (!check1()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(check2());
			}
		}
		
	}
	
	static boolean check1() {
		for (int m = 0; m < M; m++)
			if (mod1[m] == 0) return false;
		return true;
	}
	
	static int check2() {
		int cnt = 0;
		mod2 = new int[M];
		for (int i = arr.size() - 1; i >= 0; i--) {
			long num = arr.get(i);
			mod2[(int) (num % M)]++;
			cnt++;
			
			for (int m = 0; m < M; m++)
				if (mod2[m] == 0) continue;
		}
		return cnt;
	}
	
}