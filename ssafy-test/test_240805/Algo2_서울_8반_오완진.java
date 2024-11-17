import java.util.Scanner;

public class Algo2_서울_8반_오완진 {
	public static void main(String[] args) {
		// Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		// 총 테스트케이스 개수 T 입력 받기
		int T = sc.nextInt();
		
		// 테스트케이스 번호 t 입력받기
		for (int t = 1; t <= T; t++) {

			// 달팽이크기 N 입력받기
			// 입력받은 N으로 N*N 크기의 이차원배열 snail 생성
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			// 델타 배열 : 남(0) 동(1) 북(2) 서(3)
			int[] rWay = {1, 0, -1, 0};
			int[] cWay = {0, 1, 0, -1};
			
			int way = 0;		// 델타배열 인덱스 설정 (기본 남쪽방향)
			int rNow = 0;		// 현재 r 좌표
			int cNow = 0;		// 현재 c 좌표
			int rNext = 0;		// 다음 r 좌표
			int cNext = 0;		// 다음 c 좌표
			int ggumdl = 1;		// snail[rNow][cNow]에 입력될 숫자
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					// 처음은 [0][0]을 현재 좌표로 설정
					// 이후엔 유효한 좌표로 탐색된 다음 좌표를 현재 좌표로 설정
					rNow = rNext;
					cNow = cNext;
					
					// 현재 좌표에서 달팽이 숫자 입력
					// 입력 후 달팽이 숫자 1증가
					snail[rNow][cNow] = ggumdl++;
					
					// 현재의 델타배열 인덱스로 다음 좌표 설정 후 유효한 좌표인지 탐색
					rNext = rNow + rWay[way];
					cNext = cNow + cWay[way];
					
					// Short Circuit을 사용하여 Index Boundary Error 방지
					// 다음 좌표가 달팽이 안에 있는지 체크 & 다음 좌표에 이미 입력된 숫자가 있는지 체크
					if (rNext >= 0 && rNext < N && cNext >= 0 && cNext < N && snail[rNext][cNext] == 0)
						continue;
					// 걸러진 경우 델타배열 인덱스를 변경 : 남(0) -> 동(1) -> 북(2) -> 서(3) -> 남(0) -> ...
					// 변경된 델타배열 인덱스로 다음 좌표 재설정
					else {
						way = (way+1) % 4;			// 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> ... 방지
						rNext = rNow + rWay[way];
						cNext = cNow + cWay[way];
					}
				}
			}
			
			// 달팽이 출력
			System.out.println("#" + t + " ");
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(snail[r][c] + " ");
				}
				System.out.println();
			}
		}
		// Scanner 종료
		sc.close();
	}
}