package src_240902.pr_03_edgeArr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
	
	static class Edge {
		int A, B, W;		// 시작 끝 가중치

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 보통 문제에서는 V, E 의 개수를 준다
		int V = sc.nextInt();	// 정점 개수 (-> 0 or 1로 시작)
		int E = sc.nextInt();	// 간선 개수 (-> E개의 줄 입력)
		
		Edge[] edges = new Edge[E];	// 객체 배열
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		//////////////////////////////////////////
		
		List<Edge> edges2 = new ArrayList<>();
		for (int i = 0; i < E; i++)
			edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		// 굳이? 객체까지?
		int[][] edges3 = new int[E][3];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges3[i][0] = A;
			edges3[i][1] = B;
			edges3[i][2] = W;
		}
	}
}