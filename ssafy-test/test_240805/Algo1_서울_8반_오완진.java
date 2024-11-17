import java.util.Scanner;

public class Algo1_서울_8반_오완진 {
	public static void main(String[] args) {
		// Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		// 총 테스트케이스 개수 T 입력 받기
		int T = sc.nextInt();
		
		// 테스트케이스 번호 t 입력받기
		for (int t = 1; t <= T; t++) {

			// 행 개수 N과 열 개수 M 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 계산에 사용할 sum과 max
			int sum = 0;
			int max = 0;
			
			// 입력받은 N과 M으로 N*M 크기의 이차원배열 sqr 생성
			// sqr의 해당 행과 열에 숫자 입력받기
			int[][] sqr = new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					sqr[r][c] = sc.nextInt();
				}
			}
			
			// 행 별로 합 비교
			for (int r = 0; r < N; r++) {
				sum = 0;							// sum = 0 초기화
				for (int c = 0; c < M; c++)
					sum += sqr[r][c];				// 해당 행의 합 구하기
				max = Math.max(max, sum);			// 최대값 비교
			}
			
			// 열 별로 합 비교
			for (int c = 0; c < M; c++) {
				sum = 0;							// sum = 0 초기화
				for (int r = 0; r < N; r++)
					sum += sqr[r][c];				// 해당 열의 합 구하기
				max = Math.max(max, sum);			// 최대값 비교
			}
			
			// max값 출력
			System.out.println("#" + t + " " + max);
		}
		// Scanner 종료
		sc.close();
	}
}
