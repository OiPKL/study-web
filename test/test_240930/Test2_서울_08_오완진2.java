import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test2_서울_08_오완진2 {
	
	// 델타배열 선언 (상하좌우 순)
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		// TestCase 입력
		int TC = sc.nextInt();
		// TestCase 만큼 반복
		for (int tc = 1; tc <= TC; tc++) {
			
			// N과 M 입력 받고 한 줄을 입력받기 위해 sc.nextLine()으로 비우기
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			
			// 한 줄 씩 입력받고 이를 charArr로 변환해 입력
			char[][] map = new char[N][M];
			for (int n = 0; n < N; n++) {
				String line = sc.nextLine();
				for (int m = 0; m < M; m++) {
					map[n] = line.toCharArray();
				}
			}
			
			/*
			 * BFS(너비우선탐색) or DFS(깊이우선탐색) 이용
			 * 이 문제에서는 최단경로를 구하는 것이 아니기에 아무거나 써도 상관없다
			 * 원리는 동일하다
			 * Queue에서(선입선출) 들어온 순서대로 다음 탐색 노드를 탐색하는 방식
			 * Stack에서(선입후출) 들어온 순서대로 다음 탐색 노드를 탐색하는 방식
			 * 0-1. Queue를 선언하고 탐색여부를 확인하기 위해 visited배열을 선언
			 * 0-2. 처음 좌표를 Queue에 추가하고, visited 방문체크한다
			 * 1-1. Queue에서 빼내면서 다음 탐색할 노드들을 검사하고 Queue에 추가한다
			 * 1-2. 검사 조건은 아래 주석에서 설명
			 * 2. 더 이상 탐색할 노드가 없다면 탐색이 종료됨
			 */
			
			// Queue를 이용한 bfs 와 boolean[][] visited 방문배열 선언
			Queue<int[]> bfs = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			
			// 각각 Black, Orange, White 개수 0 초기화
			int cntB = 0;
			int cntO = 0;
			int cntW = 0;
			
			// map을 순회하며 BFS를 이용한 영역 탐색 후 해당 카운트 +1
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					
					// 만약 방문하지 않은 노드라면
					if (!visited[n][m]) {
						
						// BFS 탐색 예정 노드에 추가
						bfs.add(new int[] {n, m});
						// 방문체크
						visited[n][m] = true;
						// 비교할 색깔은?
						char color = map[n][m];
						
						// 해당하는 색깔만큼 카운트 +1
						// 만약 첫번째 노드가 아닌 탐색할때마다 카운트를 한다면
						// 중복으로 카운트가 되므로 첫번째 노드를 기준으로 카운트한다
						switch(color) {
							case 'B' : cntB++;
										break;
							case 'O' : cntO++;
										break;
							case 'W' : cntW++;
										break;
						}
						
						// BFS가 비어질때 까지 = 더 이상 탐색할 노드가 없다
						while (!bfs.isEmpty()) {
							
							// 현재의 탐색 위치는?
							int[] now = bfs.poll();
							int nNow = now[0];
							int mNow = now[1];
							
							// 다음 탐색 위치는?
							// 델타 배열을 사용해 다음 탐색할 노드를 검사한다
							for (int d = 0; d < 4; d++) {
								
								// 현재의 위치를 기준으로 상하좌우로 이웃에 위치한 곳
								int nNext = nNow + dn[d];
								int mNext = mNow + dm[d];
								
								// 인덱스가 map의 범위밖인지
								// 만약 이미 탐색한 곳인지
								// 만약 첫번째 노드의 색깔과 다른 색깔인지
								if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
										visited[nNext][mNext] ||
										map[nNext][mNext] != color)
									continue;
								
								// 검사를 통과하면 다음 탐색노드에 추가되는 노드는
								// 배열 범위 안이면서 탐색하지 않았으며 첫번째 노드와 색깔이 동일함
								// BFS 탐색 예정 노드에 추가
								bfs.add(new int[] {nNext, mNext});
								// 방문체크
								visited[nNext][mNext] = true;
								
								/*
								 * BBOO
								 * BWOO 를 예로 들어보면,
								 * BBB가 검사되고 map을 순회하면서
								 * 방문한 곳은 건너뛰게 되므로 다음 OOOO가 검사되고
								 * 남은 W를 검사하고 전체 탐색과정이 종료됨 (=map순회완료)
								 * + BFS는 총 3번 실행될 것임
								 */
								}
								
							}
							
						}
						
					}
				}
			
			// 형식에 맞게 출력
			System.out.println("#" + tc + " " + cntB + " " + cntO + " " + cntW);
		}
		
		// 스캐너 닫기
		sc.close();
	}
}
