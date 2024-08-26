import java.util.Scanner;

public class Test2_서울_08_오완진 {
	public static void main(String[] args) {
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 TC 받아와서 TC번 반복
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// N*M 이차원배열 빈 체스판 생성 (체스판 값은 0)
			int[][] chess = new int[N][M];
			// 나이트가 도착할 위치에 찍힐 숫자 (1부터 시작)
			int moved = 1;
			int knightN = 0;	// 나이트 초기 N좌표
			int knightM = 0;	// 나이트 초기 M좌표
			// 맨 처음 시작 (0,0) 에 1을 찍고 다음 찍을 수 +1
			chess[knightN][knightM] = moved++;
			// 아래 조건을 만족시켜서 벗어날 때까지 무한루프
			while (true) {
				knightM += 1;	// 오른쪽 1칸
				knightN += 2;	// 아래 2칸
				// 만약 나이트가 범위 밖을 벗어난다면 -N -M 만큼 조정
				if (N - 1 < knightN) knightN -= N;
				if (M - 1 < knightM) knightM -= M;
				// 만약 나이트가 이미 왔다간 곳이면 루프 종료
				if (chess[knightN][knightM] != 0)
					break;
				// 아니라면 숫자를 찍고 다음 찍을 수 +1
				else
					chess[knightN][knightM] = moved++;
			}
			// 체스판을 이차원배열로 출력
			System.out.println("#" + tc);
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					System.out.print(chess[n][m] + " ");
				}
				System.out.println();
			}
		}
		// 스캐너 닫기
		sc.close();
	}
}
