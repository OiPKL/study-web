import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algo2_서울_8반_오완진2 {
	// static 변수 선언 : 주어진 N, M, S 그리고 출력할 경우의 수 cnt
	static int N, M, S, cnt;
	// 입력 받을 등번호 배열 선언
	static int[] NN;
	// 백트래킹에서 방문을 검사하는데 사용할 boolean 배열 선언
	static boolean[] visited;
	// 백트래킹에서 모든 경우의 수를 담을 리스트 선언
	static List<Integer> pickN;
	
	public static void main(String[] args) {
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 번호 입력받기
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			// 주어진 N M S 입력받고 cnt 초기화
			N = sc.nextInt();
			M = sc.nextInt();
			S = sc.nextInt();
			cnt = 0;
			// 등번호 배열 입력받기
			NN = new int[N];
			for (int n = 0; n < N; n++)
				NN[n] = sc.nextInt();
			// 방문배열 경우의수리스트 초기화
			visited = new boolean[N];
			pickN = new ArrayList<>();
			// 백트래킹 호출 -> 가능한 경우의수를 모두 조사함
			btk(0);
			// 0 이라면 -1 출력 아니라면 cnt 출력
			if (cnt == 0)
				System.out.println("#" + tc + " " + -1);
			else
				System.out.println("#" + tc + " " + cnt);
			
		}
		// 스캐너 닫기
		sc.close();
		
	}
	/*
	 *  백트래킹
	 *  NN 등번호 배열에서 하나씩 뽑아서 pickN 리스트에 추가함
	 *  추가하게 되면 NN 등번호 배열에 동등한 인덱스를 가지는 visited 배열을 true 로 변환
	 *  -> 같은 NN 등번호를 뽑는 것을 방지
	 *  그리고 그 만큼의 NN[n] 을 더한값을 파라미터로 하는 btk 재귀함수 호출
	 *  같은 방식으로 visited 배열을 바꾸고 등번호를 뽑게 된다
	 *  ...
	 *  btk 재귀함수가 호출되면 다시 n = 0 부터
	 *  visited[n]=true 를 제외한 NN을 찾는 과정을 반복하게된다
	 *  ...
	 *  만약 pickN 리스트를 M 개만큼 뽑았다면 sum 이 S랑 일치하는지 확인한다 -> cnt++?
	 *  그리고 다시 반환(리턴)
	 *  ...
	 *  리턴하게 되면 pickN 이 호출된곳으로 돌아와지면서 sum 에서 추가된 값은 빠지게 되고
	 *  아래의 두 줄로 인해 다시 pickN 에서 마지막으로 추가된 원소를 빼내고, 방문배열을 false로 바꾼다
	 *  이와 같은 과정으로 NN 등번호 배열을 순회하면서 중복없이 순서 상관없는 배열을 뽑을 수 있게된다
	 */
	static void btk(int sum) {
		
		if (pickN.size() == M) {
			if (sum == S) cnt++;
			return;
		}
		
		for (int n = 0; n < N; n++) {
			if (!visited[n]) {
				visited[n] = true;
				pickN.add(NN[n]);
				btk(sum + NN[n]);
				pickN.remove(pickN.size() - 1);
				visited[n] = false;
			}
		}
		
	}
}
