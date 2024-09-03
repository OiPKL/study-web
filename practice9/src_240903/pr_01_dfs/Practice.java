package pr_01_dfs;

import java.util.Scanner;

public class Practice {
	
	static int V, E;			// 정점의 개수, 간선의 개수
	static int[][] adj;			// 인접행렬
	static boolean[] visited;	// 방문체크
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new int[V+1][V+1];	// 시작 정점의 번호를 1부터
		visited = new boolean[V + 1];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from][to] = adj[to][from] = 1;	// 무향 & 가중치X
		}
		
		dfs(1);
		
	}
	
	// v: 현재 정점
	static void dfs(int v) {
		visited[v] = true;
		System.out.println(v);
		
		// 인접하면서 방문하지 않은 정점을 방문
		for (int i = 1; i <= V; i++) {
			//   방문 체크    && 인접 체크
			if (!visited[i] && adj[v][i] == 1) {
				dfs(i);
			}
		}
	}
}
