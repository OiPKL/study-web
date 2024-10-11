package src_240909.pr_02_topological_sort_stack;

import java.util.Scanner;
import java.util.Stack;

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

	static int V, E;
	static int[][] adjArr;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();					// 정점의 개수 (1번부터 시작)
		E = sc.nextInt();					// 간선의 개수
		
		adjArr = new int[V + 1][V + 1];
		degree = new int[V + 1];			// 진입차수를 저장할 배열
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1;					// 가중치 1
			degree[B]++;						// 진입차수 증가
			visited = new boolean[V + 1];
			ans = new Stack<>();
		}
		
		for (int i = 1; i <= V; i++) {
			if (degree[i] == 0)
				dfs(i);
		}
		
		while (!ans.isEmpty()) {
			System.out.println(cook[ans.pop()]);
		}
		
	}
	
	static void dfs(int curr) {
		
		// 방문 true -> 무조건 출력은 X : 아직 선행 조건이 남아 있을 수 있기 때문
		visited[curr] = true;
		
		for (int i = 1; i <= V; i++) {
			// 간선이 연결되어 있고, 방문 false
			// 현재는 조건문 작성 순서가 크게 상관없지만 작성 순서에 따라 효율성, 예외 등등 고려 필요
			if (adjArr[curr][i] == 1 && !visited[i])
				dfs(i);
		}
		
		// 연결된 모든 정점을 다 방문 -> ans Stack 추가
		ans.push(curr);
		
	}
	
}
