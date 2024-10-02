package baekjoon_failed.G2_13334_철로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N, D;
	static int[] rail;
	static PriorityQueue<int[]> persons;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<int[]> persons = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if (A <= B)
				persons.add(new int[] {A, B});
			else
				persons.add(new int[] {B, A});
		}
		
		// 1. 오른쪽좌표[1]를 기준으로 오름차순 정렬
		// 2. 왼쪽좌표[0]를 기준으로 오름차순 정렬
		Collections.sort(persons, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});

		int D = sc.nextInt();
		
//		for (int[] person : persons)
//			System.out.println(Arrays.toString(person));
		
		int maxCnt = 0;
		int tmp = Integer.MAX_VALUE;
		
		for (int i = N - 1; i >= 0; i--) {
			int railR = persons.get(i)[1];
			int railL = railR - D;
			
			if (railR != tmp) {
				tmp = railR;
				
//				int cnt = 0;
//				for (int j = i; j >= 0; j--) {
//					if (railL <= persons.get(j)[0])
//						cnt++;
//					// 반례 발생
//					// https://www.acmicpc.net/board/view/29748 (#3)
////					else
////						break;
//				}
				
				// 이진탐색
				int L = 0;
				int R = i;
				int M = -1;
				while (L <= R) {
					M = (L + R) / 2;

					if (railL <= persons.get(M)[0])
						R = M - 1;
					else
						L = M + 1;
				}
				
				int cnt = i - L + 1;
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
		
		System.out.println(maxCnt);
	}
}