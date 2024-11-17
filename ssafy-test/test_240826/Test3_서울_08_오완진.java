import java.util.Scanner;

public class Test3_서울_08_오완진 {
	public static void main(String[] args) {
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 TC 받아와서 TC번 반복
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// N*N 이차원배열에 어장 값 입력받기
			int[][] bada = new int[N][N];
			for (int n1 = 0; n1 < N; n1++) {
				for (int n2 = 0; n2 < N; n2++) {
					bada[n1][n2] = sc.nextInt();
				}
			}
			// 최대값 선정을 위한 변수 (최대값이 0이 될 수 있음)
			int maxCnt = 0;
			int cnt = 0;
			// 어장을 순회하며 각 지점마다 M*M 크기의 그물을 펼처 수확량 조사
			for (int n1 = 0; n1 < N; n1++) {
				for (int n2 = 0; n2 < N; n2++) {
					// 각 경우의 수마다 cnt 초기화
					cnt = 0;
					// 그물크기 M (N-(M-1) ~ N) x (N-(M-1) ~ N) 안에서 어장 인덱스가 유효할 때만 카운트
					for (int m1 = -(M-1); m1 <= 0; m1++) {
						for (int m2 = -(M-1); m2 <= 0; m2++) {
							int x = n1 + m1;					// 그물의 x좌표
							int y = n2 + m2;					// 그물의 y좌표
							if (x < 0 || N - 1 < x) continue;	// 그물이 어장(가로축) 밖
							if (y < 0 || N - 1 < y) continue;	// 그물이 어장(세로축) 밖
							cnt += bada[x][y];
						}
					}
					// 최대값 비교
					maxCnt = Math.max(maxCnt, cnt);
				}
			}
			// 최대값 출력
			System.out.println("#" + tc + " " + maxCnt);
		}
		// 스캐너 닫기
		sc.close();
	}
}

/*
 * 혹시 모를 부분점수를 위한 접근방법 제시
 * 누적합을 이용한다........
 * 자세한 과정은 생략합니다...........
*/
