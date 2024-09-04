package pr_01_kruskal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice {
	
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
	
	static class Edge implements Comparable<Edge> {
		int A, B, W;
		
		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;		// 오름차순
//			return -(this.W - o.W);		// 내림차순
			// return Integer.compare(this.W, o.W);
		}
	}
	
	// 
	
	static int[] p;		// 대표자를 저장할 배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();	// 정점의 개수
		int E = sc.nextInt();	// 간선의 개수
		
		Edge[] edges = new Edge[E];
		
		// 클래스 대신 배열 사용 *********************************************
		
		int[][] edges2 = new int[E][3]; // 0: 시작 1: 도착 2: 가중치
		
		Arrays.sort(edges2, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// **************************************************************
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		System.out.println("정렬 전");
		for (Edge e : edges) {
			System.out.println(e);
		}
		System.out.println();
		
		// 1. 가중치 순으로 오름차순 정렬하기
//		// Comparator 사용
//		Arrays.sort(edges, new Comparator<Edge>(){
//
//			@Override
//			public int compare(Edge o1, Edge o2) {
//				return o1.W - o2.W;
//			}
//			
//		});
		
		// compareTo 사용
		Arrays.sort(edges);

		System.out.println("정렬 후");
		for (Edge e : edges) {
			System.out.println(e);
		}
		System.out.println();
		
		// 2. V-1 개의 간선 뽑기 (사이클 발생하지 않도록)
		// 상호배타조합 (서로소집합, 유니온파인드)
		p = new int[V];
		
		// make-set을 통해 전체 자신을 대표로 만드는 작업
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		
		int ans = 0;	// 최소비용
		int pick = 0;	// 뽑은 간선의 개수
		
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			
			// 사이클이 발생하는지 검사
			if (px != py) {
				union(px, py);
				ans += edges[i].W;
				pick++;
			}
			
			if (pick == (V-1)) break;
		}
		
		System.out.println("최소비용: " + ans);

	}
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
//		// 기존 코드
//		if (x == p[x]) return x;
//		return findSet(p[x]);
		
		// 향상 코드 -> 반복 줄이기W
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		// x와 y가 대표자 여야만 함
//		// 기존 코드
//		p[findSet(y)] = findSet(x);	// X그룹에 Y그룹 넣기
		
		// 향상 코드
		p[y] = x;
	}
}
