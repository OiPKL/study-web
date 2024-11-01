package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, minScore, answer;
	static int[] papers;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	papers = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int n = 0; n < N; n++)
    		papers[n] = Integer.parseInt(st.nextToken());
    	
    	int L = 0;				// 오답
    	int R = 2_000_000;		// 정답
    	while (L <= R) {
    		
    		int M = (L + R) / 2;
    		
    		if (isPossible(M)) {
    			answer = minScore;
    			L = M + 1;
    		} else {
    			R = M - 1;
    		}
    	}
    	
    	System.out.println(answer);
    }

    static boolean isPossible(int maxScore) {
    	
    	int idx = 0;	// 시험지 인덱스
    	int cnt = 0;	// 그룹 개수
    	
    	while (idx < N) {
    		
    		cnt++;
    		
    		int score = 0;
    		int minSum = Integer.MAX_VALUE;
    		while (idx < N) {
    			
    			if (score + papers[idx] <= maxScore) {
    				score += papers[idx];
    				idx++;
    			} else {
    				minSum = Math.min(minSum, score);
    				break;
    			}
    		}
    	}
    	
    	return cnt >= K;
    }
}