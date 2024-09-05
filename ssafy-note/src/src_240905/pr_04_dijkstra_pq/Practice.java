package src_240905.pr_04_dijkstra_pq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Practice {
	
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51\r\n"
			+ "";

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i = 0 ; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for(int i = 0 ; i<E; i++)
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];
		
		//시작 노드까지의 거리는 0으로 초기화
		dist[start] = 0; 
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			//이미 방분했다면 비용을 알고 있다는 뜻
			if(visited[curr.v]) continue; 
			visited[curr.v]= true; //선택
			
			for(Node node : adjList[curr.v]) {
				if(!visited[node.v] && dist[node.v] > dist[curr.v]+node.w  ) {
					dist[node.v]= dist[curr.v]+ node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		
	}
}
