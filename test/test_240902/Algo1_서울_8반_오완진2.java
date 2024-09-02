import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Algo1_서울_8반_오완진2 {

	// static 변수 선언
	static int N;
	static char[][] board;
	static Deque<Character>[] deques;
	
	public static void main(String[] args) {
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			// N 입력 받고 String 입력 받기위해 nextLine() 추가
			N = sc.nextInt();
			sc.nextLine();
			// N*N 크기의 이차원배열 보드판 생성
			board = new char[N][N];
			// N개의 dequeN] 선언
			deques = new Deque[N];
			// N개의 deque 사용 위해 구현체 추가
			for (int n = 0; n < N; n++)
				deques[n] = new LinkedList<Character>();
			// 한 줄 입력받아서 charArr 로 바꾼 뒤에 intArr 로 변환
			String str = sc.nextLine();
			char[] charArr = str.toCharArray();
			int[] orderArr = new int[charArr.length];
			for (int i = 0; i < charArr.length; i++)
				orderArr[i] = charArr[i] - '0';
			
			// 주어진 순서대로 볼을 떨어뜨림
			for (int i = 0; i < orderArr.length; i++) {
				dropBall(orderArr[i]);
			}
			
			// deque의 앞에서부터 꺼내면서 board[][] 아래쪽부터 채우기
			for (int n = 0; n < N; n++) {
				int mIdx = N - 1;
				if (!deques[n].isEmpty()) {
					while (!deques[n].isEmpty()) {
						board[n][mIdx--] = deques[n].pollFirst();
					}
				}
			}
			// board[][] 출력
			for (int n = 0; n < N; n++)
				for (int m = 0; m < n; m++)
					System.out.print(board[n][m]);
				System.out.println();
		}
		// 스캐너 닫기
		sc.close();
	}
	// 볼 떨어뜨리기 (board의 가로 인덱스를 파라미터로)
	static void dropBall(int idx) {
		// 만약 꽉 찾다면 Pass
		if (deques[idx].size() == N)
			return;
		// 해당 인덱스의 deque[idx] 에 *을 뒤에 추가
		deques[idx].addLast('*');
		// 첫줄에 폭발이 일어나는지 체크
		isBoom();
	}
	// 폭발 체크 메서드
	static void isBoom() {
		// 만약 비어있는 deque가 있다면 맨 아래줄이 꽉 안찼다는 뜻 -> Pass
		for (int n = 0; n < N; n++) {
			if (deques[n].size() == 0)
				return;
		}
		// deque 배열 모두에게서 앞의 원소 꺼내기 = 폭발!
		for (int n = 0; n < N; n++) {
			deques[n].pollFirst();
		}
	}
	
}