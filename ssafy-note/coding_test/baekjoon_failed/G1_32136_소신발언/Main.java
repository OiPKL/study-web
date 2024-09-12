package baekjoon_failed.G1_32136_소신발언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
         * 왼쪽에서부터 오른족으로 기준점을 옮겨갈껀데
         * newH ~ oldH 까지의 hitTime이 newH ~ ooldH 까지의 hitTime보다 크다면 갱신
         * newH ~ oldH 까지의 hitTime 증가가 더 빠르기 때문
         */
        
        int L = 0;
        int R = N - 1;
        int ooldH = L;
        int oldH = L;
        int newH = L;
        long oldHitTime = 0;		// newH ~ ooldH 까지의 hitTime
        long newHitTime = 0;		// newH ~ oldH  까지의 hitTime
        long minHitTime = Integer.MAX_VALUE;
        
        while (newH < R) {
        	
        	newH = maxIceFinder(oldH + 1, R);
        	oldHitTime = (long) cows[ooldH] * (newH - ooldH);
        	newHitTime = (long) cows[oldH] * (newH - oldH);
        	
        	if (newHitTime >= oldHitTime) {
        		ooldH = oldH;
        		oldH = newH;
        	} else {
        		oldH = newH;
        	}
        	
        	minHitTime = Math.min(minHitTime, Math.max(oldHitTime, newHitTime));
        	
        }
        
        System.out.println(minHitTime);
        
	}
	
	static int maxIceFinder(int start, int end) {
		
		int maxIce = Integer.MIN_VALUE;
		int maxIceIdx = -1;
		
		for (int idx = start; idx <= end; idx++) {
			if (cows[idx] > maxIce) {
				maxIce = cows[idx];
				maxIceIdx = idx;
			}
		}
		
		return maxIceIdx;
		
	}
}