package pr_02_adjList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 보통 문제에서는 V, E 의 개수를 준다
		int V = sc.nextInt();	// 정점 개수 (-> 0 or 1로 시작)
		int E = sc.nextInt();	// 간선 개수 (-> E개의 줄 입력)
		
		List<Integer>[] adjList = new ArrayList[V];
		
		// Null Point Exception 방지
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
			
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			// 가중치를 같이 저장하고 싶다면 클래스 정의 필요
			adjList[A].add(B);
			adjList[A].add(A);
		}
		
	}
}