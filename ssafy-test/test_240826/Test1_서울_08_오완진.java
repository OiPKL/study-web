import java.util.Scanner;

public class Test1_서울_08_오완진 {
	public static void main(String[] args) {
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 TC 받아와서 TC번 반복
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// nextInt - nextInt 버퍼를 클리어 하기위해 nextLine 추가
			sc.nextLine();
			// N*M 이차원배열에 한줄씩 N번 문자열로 입력받고 이를 char 배열로 반환해 저장
			char[][] poland = new char[N][M];
			for (int n = 0; n < N; n++) {
				String str = sc.nextLine();
				poland[n] = str.toCharArray();
			}
			// 행마다 W가 아닌 색깔의 수, R이 아닌 색깔의 수를 각각 [0] [1] 에 저장
			int[][] color = new int[N][2];
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (poland[n][m] != 'W') color[n][0]++;
					if (poland[n][m] != 'R') color[n][1]++;
				}
			}
			// 최소값 선정을 위한 변수는 최대한 크게 설정
			int minCnt = Integer.MAX_VALUE;
			int cnt = 0;
			// W-R 경계선 (i=1 ~ i=N-1) 케이스마다 카운트 측정
			for (int i = 1; i < N; i++) {
				// 각 경우의 수마다 cnt 초기화
				cnt = 0;
				// 0 ~ i-1 에는 W를 바꿔야 하는 수,
				for (int n = 0; n < i; n++) {
					cnt += color[n][0];
				}
				// i ~ N-1 에는 R를 빠꿔야 하는 수를 카운트
				for (int n = i; n < N; n++) {
					cnt += color[n][1];
				}
				// 최소값 비교
				minCnt = Math.min(minCnt, cnt);
			}
			// 최소값 출력
			System.out.println("#" + tc + " " + minCnt);
		}
		// 스캐너 닫기
		sc.close();
	}
}
