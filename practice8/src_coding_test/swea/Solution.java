package swea;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
		}
	}
	
}

/*
 * 절대좌표 -> 상대좌표 사용!
 * cell[세포번호][]	0: 생명수치(X) .. 빈 땅 = 생명수치 0
 * 					1: 상태코드 .. X..1(비활성화카운트) (0..-(X-1))(사망카운트) -X(사망)
 * 					2: r좌표
 * 					3: c좌표
 * 
 * if cell 없다면 ~ 빈땅에 cell 생성
 * 번식 ~ 상하좌우 대결 -> 생명령 수치가 높은순서로
 * 모든 생명수치 존재 cell들 -1씩
 */