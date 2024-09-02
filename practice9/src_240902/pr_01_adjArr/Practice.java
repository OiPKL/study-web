package pr_01_adjArr;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 보통 문제에서는 V, E 의 개수를 준다
		int V = sc.nextInt();	// 정점 개수 (-> 0 or 1로 시작)
		int E = sc.nextInt();	// 간선 개수 (-> E개의 줄 입력)
		
		// 만약 시작정점이 1 -> new int[V+1][V+1]
		int[][] adjArr = new int[V][V];
		
		// E 개의 간선을 입력받을 반복문
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();	// 두 개의 정점 A, B
			int B = sc.nextInt();	// 가중치가 있다면 값은 3개
			int W = sc.nextInt();
			
			adjArr[A][B] = 1;	// 가중치가 없다면 1을, 있다면 1 저장
			adjArr[B][A] = 1;	// 만약 무향이라면 반대 경우도 1 저장
			
//			// 한 줄 작성
//			adjArr[A][B] = adjArr[B][A] = W;
//			// 만약 유향그래프 & 가중치 O & 변수 사용 자제
//			adjArr[A][B] = W;
			
		}
		
	}
}
