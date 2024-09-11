package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static int N;
	static int[] cows;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim();
        
        String[] tokens = line.split(" ");
        cows = new int[N];

        for (int i = 0; i < N; i++)
        	cows[i] = Integer.parseInt(tokens[i]);

        /*
         * 아이디어
         * maxHit : |i-j| * cows[i]
         * maxHit 보다 커지려면 cows[i] 가 있는 |i-j| 밖이어야 함
         * 0 & N-1 도달할 때까지 가장 큰 cows[i] 찾고 ~ 인덱스 건너뛰고 ~ 반복
         */
        
        long minMaxHit = Integer.MAX_VALUE;
        
        for (int idx = 0; idx <= N - 1; idx++) {
        	
        	int L = idx;
        	int R = idx;
        	int[] maxHList;						// maxHfinder 메서드 ~ maxH 인덱스 가져오기
        	int dL, dR, moveD;					// 절대값거리, 이동거리
        	int maxHL, maxHR;					// 거리곱 계산 전 (가장 큰 소신발언크기)
        	long maxHitL, maxHitR;				// 거리곱 계산 후 (가장 긴 히터가동시간)
        	long maxHit = Integer.MIN_VALUE;
        	
        	while (0 < L && R < N - 1) {
        		maxHList = maxHfinder(0, L - 1);
        		dL = idx - maxHList[0];
        		maxHL = cows[maxHList[0]];
        		maxHitL = (long)maxHL * dL;
        		
        		maxHList = maxHfinder(R + 1, N - 1);
        		dR = maxHList[1] - idx;
        		maxHR = cows[maxHList[1]];
        		maxHitR = (long)maxHR * dR;
        		
        		if (maxHitL > maxHitR) {
        			moveD = dL;
            		L = idx - moveD;
            		R = idx + moveD;
            		maxHit = Math.max(maxHit, maxHitL);
        		} else {
        			moveD = dR;
            		L = idx - moveD;
            		R = idx + moveD;
            		maxHit = Math.max(maxHit, maxHitR);
        		}
        	}

        	while (0 < L) {
        		maxHList = maxHfinder(0, L - 1);
        		moveD = idx - maxHList[0];
        		maxHL = cows[maxHList[0]];
        		maxHitL = (long)maxHL * moveD;
        		
        		L = idx - moveD;
        		maxHit = Math.max(maxHit, maxHitL);
        	}
        	
        	while (R < N - 1) {
        		maxHList = maxHfinder(R + 1, N - 1);
        		moveD = maxHList[1] - idx;
        		maxHR = cows[maxHList[1]];
        		maxHitR = (long)maxHR * moveD;
        		
        		R = idx + moveD;
        		maxHit = Math.max(maxHit, maxHitR);
        	}
        	
        	maxHit = Math.max(maxHit, (long) cows[0] * (idx - 0));
        	maxHit = Math.max(maxHit, (long) cows[N - 1] * (N - 1 - idx));
        	
        	minMaxHit = Math.min(minMaxHit, maxHit);
        }
        
        System.out.println(minMaxHit);
        
	}
	
	static int[] maxHfinder(int start, int end) {
		
		Deque<Integer> maxHList = new LinkedList<>();
		int maxH = Integer.MIN_VALUE;
		
		for (int idx = start; idx <= end; idx++) {
			if (cows[idx] > maxH) {
				maxHList = new LinkedList<>();
				maxHList.addLast(idx);
				maxH = cows[idx];
			} else if (cows[idx] == maxH) {
				maxHList.addLast(idx);
			}
		}
		
		int minIdx = maxHList.peekFirst();
		int maxIdx = maxHList.peekLast();
		
		return (new int[] {minIdx, maxIdx});
	}
}