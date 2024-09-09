package src_240909.pr_01_topological_sort_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice {
	
	static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	static String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();
		
		int V = sc.nextInt();					// 정점의 개수 (1번부터 시작)
		int E = sc.nextInt();					// 간선의 개수
		
		int[][] adjArr = new int[V + 1][V + 1];
		int[] degree = new int[V + 1];			// 진입차수를 저장할 배열
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1;					// 가중치 1
			degree[B]++;						// 진입차수 증가
		}
		
		// 1. 진입차수 0 넣기
		Queue <Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= V; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
		
		// 2-1. 큐가 공백상태가 될 때까지 진행
		// 2-2. 간선 제거 후 진입차수가 0이 되면 큐에 넣기
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(cook[curr] + "\n");		// 위상정렬 수행 결과
			
			for (int i = 1; i <= V; i++) {
				// 무향에서는 인덱스의 순서가 중요x
				// 유향에서는 인덱스의 순서가 중요o
				if (adjArr[curr][i] == 1) {
					degree[i]--;				// 진입차수 -1
					adjArr[curr][i] = 0;		// 없어도 되는 코드
					// 만약 i 정점의 진입차수가 0
					if (degree[i] == 0)
						queue.add(i);
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
