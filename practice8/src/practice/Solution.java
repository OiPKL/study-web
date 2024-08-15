package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			Queue<Character> button = new LinkedList<>();
			boolean[] buttonB = new boolean[100];
			boolean[] buttonO = new boolean[100];

			int N = sc.nextInt();
			for (int n = 0; n < N; n++) {
				char ch = sc.next().charAt(0);
				int M = sc.nextInt();
				button.add(ch);
				if (ch == 'B') 	buttonB[M-1] = true;
				else 			buttonO[M-1] = true;
			}
			
			int time = 0;
			int idxB = 0;
			int idxO = 0;
			
			// 버튼 큐가 비어질 때까지
			outer:
			while (!(button.isEmpty())) {
				time++;
				// 버튼을 동시에 누를 수 없음 -> if - else 로 택 1
				// 선택1. TT TF FT -> 버튼 클릭 & 전진 or 대기
				if (buttonB[idxB] || buttonO[idxO]) {
					if (buttonB[idxB]) {
						if (button.peek() == 'B') {
							if (idxO < 100 && !buttonO[idxO]) idxO++;
							buttonB[idxB] = false;
							button.poll();
							continue outer;
						} else {
							if (idxO < 100 && !buttonO[idxO]) idxO++;
						}
					} else {
						if (button.peek() == 'O') {
							if (idxB < 100 && !buttonB[idxB]) idxB++;
							buttonO[idxO] = false;
							button.poll();
							continue outer;
						} else {
							if (idxB < 100 && !buttonB[idxB]) idxB++;
						}
					}
				// 선택2. FF -> 둘 다 전진
				} else {
					if (idxB < 100 && !buttonB[idxB]) idxB++;
					if (idxO < 100 && !buttonO[idxO]) idxO++;
				}
			}
			
			System.out.println("#" + tc + " " + time);
		}
	}
	
}