package swea_failed.d3_10761_신뢰;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			Queue<Character> clkBot = new LinkedList<>();
			Queue<Integer> btnBlue = new LinkedList<>();
			Queue<Integer> btnOrge = new LinkedList<>();
			
			int N = sc.nextInt();
			for (int n = 0; n < N; n++) {
				char ch = sc.next().charAt(0);
				int M = sc.nextInt();
				clkBot.offer(ch);
				if (ch == 'B') 	btnBlue.offer(M);
				else			btnOrge.offer(M);
			}
			
			int time = 0;
			int idxB = 1;
			int idxO = 1;
			
			// 클릭로봇 큐가 비어질 때까지
			while (!clkBot.isEmpty()) {
				time++;
				// 1. 둘 다 버튼위치 도착 : 동시 클릭X ~ 둘 중 하나는 대기
				if (!btnBlue.isEmpty() && idxB == btnBlue.peek() && !btnOrge.isEmpty() && idxO == btnOrge.peek()) {
					// 1-1. 클릭&대기
					if (clkBot.peek() == 'B') {
						btnBlue.poll();
						clkBot.poll();
					// 1-2. 대기&클릭
					} else {
						btnOrge.poll();
						clkBot.poll();
					}
				// 2. Blue만 버튼위치 도착 : Orge 이동? 종료?
				} else if (!btnBlue.isEmpty() && idxB == btnBlue.peek()) {
					// 2-1. 클릭&(이동.종료)
					if (clkBot.peek() == 'B') {
						btnBlue.poll();
						clkBot.poll();
					} if (!btnOrge.isEmpty() && 0 <= idxO && idxO < 100)
						idxO += move(btnOrge, idxO);
					// 2-2. 대기&(이동.종료)
					else {
						if (!btnOrge.isEmpty() && 0 <= idxO && idxO < 100)
							idxO += move(btnOrge, idxO);
					}
				// 3. Orge만 버튼위치 도착 : Blue 이동? 종료?
				} else if (!btnOrge.isEmpty() && idxO == btnOrge.peek()) {
					// 3-1. (이동.종료)&클릭
					if (clkBot.peek() == 'O') {
						btnOrge.poll();
						clkBot.poll();
					} if (!btnBlue.isEmpty() && 0 <= idxB && idxB < 100)
						idxB += move(btnBlue, idxB);
					// 3-2. (이동.종료)&대기
					else {
						if (!btnBlue.isEmpty() && 0 <= idxB && idxB < 100)
							idxB += move(btnBlue, idxB);
					}
				// 4. 둘 다 버튼위치 도착X : 이동? 종료?
				} else {
					// 4-1. 이동&이동
					if (!btnBlue.isEmpty() && !btnOrge.isEmpty()) {
						int moove1 = powerMove(btnBlue, idxB);
						int moove2 = powerMove(btnOrge, idxO);
						// |moove2| 만큼 이동
						if (Math.abs(moove1) > Math.abs(moove2)) {
							if (moove1 * moove2 > 0) {
								idxB += moove2;
								idxO += moove2;
							} else if (moove1 > 0) {
								idxB += moove2;
								idxO -= moove2;
							} else {
								idxB -= moove2;
								idxO += moove2;
							}
							time += (Math.abs(moove2) - 1);
						// |moove1| 만큼 이동
						} else {
							if (moove1 * moove2 > 0) {
								idxB += moove1;
								idxO += moove1;
							} else if (moove1 > 0) {
								idxB += moove1;
								idxO -= moove1;
							} else {
								idxB -= moove1;
								idxO += moove1;
							}
							time += (Math.abs(moove1) - 1);
						}
					// 4-2. 이동&종료
					} else if (btnOrge.isEmpty()) {
						int moove1 = powerMove(btnBlue, idxB);
						idxB += moove1;
						time += (Math.abs(moove1) - 1);
					// 4-3. 종료&이동
					} else if (btnBlue.isEmpty()) {
						int moove2 = powerMove(btnOrge, idxO);
						idxO += moove2;
						time += (Math.abs(moove2) - 1);
					// 4-4. 종료&종료
					} else {}
				}
			}
			
			System.out.println("#" + tc + " " + time);
		}
		
	}
	
	// 전진 or 후진 메서드
	static int move(Queue<Integer> btn, int idx) {
		return btn.peek() > idx ? 1 : -1;
	}
	
	// 강화전진 or 강화후진 메서드
	static int powerMove(Queue<Integer> btn, int idx) {
		int mooove = Math.abs(btn.peek() - idx);
		return btn.peek() > idx ? mooove : -mooove;
	}
}
