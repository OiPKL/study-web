package src_240903.pr_01_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Practice {
	
	static int V, E;			// 정점의 개수, 간선의 개수
	static List<Integer>[] adj;	// 인접리스트
	static boolean[] visited;	// 방문체크
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V+1];
		for (int i = 1; i <= V; i++)	// 시작 정점의 번호를 1부터
			adj[i] = new ArrayList<>();
		visited = new boolean[V + 1];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adj[from].add(to);			// 무향 & 가중치X
			adj[to].add(from);
		}
		
		bfs(1);
		
	}
	
	// v: 현재 정점
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.println(curr);
			
			// 인접하면서 방문하지 않은 정점을 방문
			for (int w : adj[curr]) {
				if (!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
		}
	}
}