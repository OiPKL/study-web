import java.util.Scanner;

public class Test1_서울_08_오완진2 {
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		// TestCase 입력
		int TC = sc.nextInt();
		// TestCase 만큼 반복
		for (int tc = 1; tc <= TC; tc++) {
			
			// 계단높이 입력
			int H = sc.nextInt();
			
			/*
			 * Dynamic Programming(DP) 이용
			 * 계산 과정에서 이전에 계산한 값들을 다시 계산하는 것을 줄여서
			 * 효율적으로 답을 도출하기 위해 중간의 결과 값들을 메모리에 저장하는 계산 방식이다
			 */
			
			// H의 범위가 최대 60이므로 경우의 수가 int 범위를 초과한다
			// 따라서 long 타입으로 배열을 선언함
			// 인덱스 범위 0 ~ H 사용하기 위해서 배열의 길이 H+1
			// 여기서 dp[i] 배열의 인덱스는 i번째 계단까지 오를 수 있는 경우의 수를 의미한다
			long[] dp = new long[H+1];
			
			// 0번째 계단을 오르는 경우의 수는 1
			dp[0] = 1;
			for (int i = 1; i <= H; i++) {
				// 1. 1칸 이전 계단에서 1칸 오를 수 있는 경우의 수를 더한다
				// 1칸 = for 문에서의 인덱스 증가값이므로 if (i >= 1) 은 없어도 동작한다
//				if (i >= 1)
					dp[i] += dp[i-1];
				// 2. 3칸 이전 계단에서 1칸 오를 수 있는 경우의 수를 더한다
				// 1~2 높이의 계단에서는 -2, -1의 계단은 존재하지 않으므로
				// 인덱스 범위 에러를 방지하기 위해 if (i >= 3) 조건 추가
				if (i >= 3)
					dp[i] += dp[i-3];
				// 3. 4칸 이전 계단에서 1칸 오를 수 있는 경우의 수를 더한다
				// 1~3 높이의 계단에서는 -3, -2, -1의 계단은 존재하지 않으므로
				// 인덱스 범위 에러를 방지하기 위해 if (i >= 4) 조건 추가
				if (i >= 4)
					dp[i] += dp[i-4];
				
				// dp[4]를 예를 들면,
				// dp[4] += dp[3]; -> 3번째 계단까지 오르는 경우의 수 ~ 에서 1칸 UP ~ 경우의 수 추가
				// dp[4] += dp[1]; -> 1번째 계단까지 오르는 경우의 수 ~ 에서 3칸 UP ~ 경우의 수 추가
				// dp[4] += dp[0]; -> 0번째 계단까지 오르는 경우의 수 ~ 에서 4칸 UP ~ 경우의 수 추가
			}
			
			// H번째 계단을 오르는 경우의 수 출력 = dp[H]
			System.out.println("#" + tc + " " + dp[H]);
		}
		
		// 스캐너 닫기
		sc.close();
	}
}
