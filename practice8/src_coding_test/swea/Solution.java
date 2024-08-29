package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static boolean[] cards;		// idx: 0 ~ 17	- 인영이의 카드덱 결정에 사용
	static boolean[] iinPicked;	// idx: 0 ~ 8	- 백트래킹 중복 선택 방지
	static int[] kyuOrder;		// idx: 0 ~ 8	- 규영이의 카드순서
	static int[] iinCard;		// idx: 0 ~ 8	- 인영이의 카드덱 (순서는 미정)
	static int kyuScore;
	static int kyuWin;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			cards = new boolean[18];
			iinPicked = new boolean[9];
			kyuOrder = new int[9];
			iinCard = new int[9];
			kyuWin = 0;
			
			for (int i = 0; i < 9; i++) {
				int card = sc.nextInt() - 1;	// card-idx 조정 (인덱스 에러 방지)
				kyuOrder[i] = card;
				cards[card] = true;
			}
			
			int iinIdx = 0;
			for (int i = 0; i < 18; i++) {
				if (!cards[i]) iinCard[iinIdx++] = i;
			}
			
			play (new ArrayList<>(), 0);
			
			System.out.println("#" + tc + " " + kyuWin + " " + (362880 - kyuWin));
			
		}
		
	}
	
	static void play(List<Integer> iinOrder, int idx) {
		
		if (iinOrder.size() == 9) {
			kyuScore = 0;
			for (int i = 0; i < 9; i++) {
				if (kyuOrder[i] > iinOrder.get(i)) kyuScore += (kyuOrder[i] + iinOrder.get(i));
			}
			if (kyuScore > 153 - kyuScore) kyuWin++;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!iinPicked[i]) {
				iinPicked[idx] = true;
				iinOrder.add(iinCard[idx]);
				play(iinOrder, idx + 1);
				iinOrder.remove(iinOrder.size() - 1);
				iinPicked[idx] = false;
			}
		}
		
	}
	
}
