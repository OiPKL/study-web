package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			Queue<Character> clickRobot = new LinkedList<>();
			Queue<Integer> btnNumB = new LinkedList<>();
			Queue<Integer> btnNumO = new LinkedList<>();
			boolean[] btnOnOffB = new boolean[100];
			boolean[] btnOnOffO = new boolean[100];

			int N = sc.nextInt();
			for (int n = 0; n < N; n++) {
				char ch = sc.next().charAt(0);
				int M = sc.nextInt();
				clickRobot.add(ch);
				if (ch == 'B') {
					btnNumB.offer(M);
					btnOnOffB[M-1] = true;
				}
				else {
					btnNumO.offer(M);
					btnOnOffO[M-1] = true;
				}
			}
			
			int time = 0;
			int idxB = 0;
			int idxO = 0;
			
			// 버튼 큐가 비어질 때까지
			while (!(clickRobot.isEmpty())) {
				time++;
				// 버튼을 동시에 누를 수 없음 -> if-else 로 택 1
				// 선택1. TF FT TT -> 버튼 큐 확인 후 버튼 클릭 & 무브 or 대기
                if (btnOnOffB[idxB] || btnOnOffO[idxO]) {
                	// 1-1. TF & 큐Blue -> Blue 버튼 & Orge 무브 or 대기
                    if (btnOnOffB[idxB] && clickRobot.peek() == 'B') {
                        btnOnOffB[idxB] = false;
                        btnNumB.poll();
                        clickRobot.poll();
                        if ((!btnNumO.isEmpty()) && 0 <= idxO && idxO < 100 && !btnOnOffO[idxO])
                        	idxO += moveDirection(btnNumO, idxO);
                	// 1-2. FT & 큐Orge -> Blue 무브 or 대기 & Orge 버튼
                    } else if (btnOnOffO[idxO] && clickRobot.peek() == 'O') {
                        btnOnOffO[idxO] = false;
                        clickRobot.poll();
                        btnNumO.poll();
                        if ((!btnNumB.isEmpty()) && 0 <= idxB && idxB < 100 && !btnOnOffB[idxB])
                        	idxB += moveDirection(btnNumB, idxB);
                	// 1-3. TF & 큐Orge | FT & 큐Blue -> 무브 or 대기
                    } else {
                    	if ((!btnNumB.isEmpty()) && 0 <= idxB && idxB < 100 && !btnOnOffB[idxB])
                    		idxB += moveDirection(btnNumB, idxB);
                    	if ((!btnNumO.isEmpty()) && 0 <= idxO && idxO < 100 && !btnOnOffO[idxO])
                    		idxO += moveDirection(btnNumO, idxO);
                    }
				// 선택2. FF -> 둘 다 무브
                } else {
                    if ((!btnNumB.isEmpty()) && 0 <= idxB && idxB < 100)
                    	idxB += moveDirection(btnNumB, idxB);
                    if ((!btnNumO.isEmpty()) && 0 <= idxO && idxO < 100)
                    	idxO += moveDirection(btnNumO, idxO);
                }
			}
			
			System.out.println("#" + tc + " " + time);
		}
	}
	
	// 전진 or 후진 메서드
	static int moveDirection(Queue<Integer> btnNum, int idx) {
		return btnNum.peek() > idx ? 1 : -1;
	}
	
}