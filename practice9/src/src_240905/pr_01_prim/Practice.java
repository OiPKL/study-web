package src_240905.pr_01_prim;

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
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjArr = new int[V][V];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W;	// 무향
		}
		
		boolean[] visited = new boolean[V];
		int[] p = new int[V];		// 어디서 왔는지 정보가 필요할 때만 (생략 가능)
		int[] dist = new int[V];	// key : 선택한 간선의 가중치
		
		// 1. 초기화
//		Arrays.fill(p, -1);
//		Arrays.fill(dist, INF);
		
		for (int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		}
		
		// 2. 시작정점 결정
		dist[0] = 0;
		
		// 3. V-1번 만큼 ~ 가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문 체크 & 갱신
		for (int i = 0; i < V - 1; i++) {
			
			int idx = -1;
			int min = INF;
			// 방문하지 않았으면서 가장 작은 값 찾기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					idx = j;
					min = dist[j];
				}
			}
			// 반복문 종료 ~ idx : 방문 X & 가장 작은 값
			visited[idx] = true;
			
			// 방문하지 않았고 업데이트할 수 있으면 업데이트
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					p[j] = idx;
					dist[j] = adjArr[idx][j];
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < V; i++)
			ans += dist[i];
		
		System.out.println(ans);
		
	}
}