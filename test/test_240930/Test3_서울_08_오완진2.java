import java.util.Scanner;

public class Test3_서울_08_오완진2 {
	
	// 델타배열 선언 (상하좌우 순)
	static int[] dn = {-1, 0, 1, 0};
	static int[] dm = {0, 1, 0, -1};
	
	// btk에서 사용하는 변수를 줄이기 위해 static 변수로 선언함 (가독성)
	static int N, M, minScore;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		// TestCase 입력
		int TC = sc.nextInt();
		// TestCase 만큼 반복
		for (int tc = 1; tc <= TC; tc++) {
			
			// N과 M 입력
			N = sc.nextInt();
			M = sc.nextInt();
			
			// map 입력
			map = new int[N][M];
			for (int n = 0; n < N; n++)
				for (int m = 0; m < M; m++)
					map[n][m] = sc.nextInt();
			
			/*
			 * BackTracking(BTK) 이용
			 * 현재의 좌표에서 minScore 계산을 한 후
			 * 다음 좌표에서 다시 함수를 호출하여 minScore 계산을 한 후
			 * ...
			 * 재귀함수를 이용한 완전탐색하는 방식이다
			 * BFS나 DFS를 이용하면 한번 방문한 곳은 다시 방문하지 않기때문에
			 * 모든 경우의 수를 생각할 수 없으므로 백트래킹을 이용함
			 */
			
			// Math.min 연산을 위한 가장 큰 변수 초기화
			minScore = Integer.MAX_VALUE;
			
			// 방문배열 선언
			// 여기에서 visited true = 블루의 땅, false = 오렌지의 땅으로 계산하였지만
			// 문제에서 요구하는 것은 블루의 땅과 오렌지의 땅 각각의 크기가 아닌
			// 두 땅의 차이가 최소가 되는 값이기 때문에 [0][0]이 블루이든, 오렌지이든 상관이 없음
			// -> visited[0][0]이 블루의 땅인지, 오렌지의 땅인지 두번 계산할 필요가 없다는 뜻
			visited = new boolean[N][M];
			// [0][0]은 블루의 땅임을 선언
			visited[0][0] = true;
			
			// [0][0] 좌표에서 영역계산을 시작
			btk(0, 0);
			
			// 형식에 맞게 출력
			System.out.println("#" + tc + " " + minScore);
		}
		
		// 스캐너 닫기
		sc.close();
	}
	
	// 현재의 좌표를 기준으로 호출
	static void btk(int nNow, int mNow) {
		
		// 현재 좌표에서 minScore 계산메서드 호출
		calScore();
		
		// 델타 배열을 사용해 다음 탐색할 좌표를 검사한다
		for (int d = 0; d < 4; d++) {
			
			// 현재의 위치를 기준으로 상하좌우로 이웃에 위치한 곳
			int nNext = nNow + dn[d];
			int mNext = mNow + dm[d];
			
			// 인덱스가 map의 범위밖인지
			// 만약 이미 탐색한 곳인지
			if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext ||
					visited[nNext][mNext])
				continue;
			
			// 방문체크 한 후
			visited[nNext][mNext] = true;
			// 다음 좌표를 기준으로 다시 btk 호출
			btk(nNext, mNext);
			// 모든 경우의 수를 탐색하기 위해 방문체크 해제
			visited[nNext][mNext] = false;
			
			/*
			 * map을 순회하면서
			 * [1][0] btk-검사 ~
			 * [1][0],[2][0] btk&검사 ~
			 * [1][0],[2][0], [3][0] btk&검사 ~ 
			 * ...
			 * [1][0],[2][0], __ , [4][0] btk&검사 ~
			 * 식으로 모든 경우의 수를 탐색하게 될 것임
			 */
		}
		
	}
	
	// minScore 계산 메서드
	static void calScore() {
		
		// 블루 오렌지 점수 0 초기화
		int scoreB = 0;
		int scoreO = 0;
		
		// map을 순회하면서 현재까지 방문된 곳은 블루의 점수+ 아닌 곳은 오렌지의 점수+
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (visited[n][m])
					scoreB += map[n][m];
				else
					scoreO += map[n][m];
			}
		}
		
		// minScore 계산 + 놓칠뻔한 조건 추가 : 모두가 블루의 땅이되면 계산X
		// ..인데 의미는 없다 (오히려 scoreB - scoreO 는 커지기 때문)
		if (scoreO != 0)
			minScore = Math.min(minScore, Math.abs(scoreB - scoreO));
	}
}
