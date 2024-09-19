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
	       
	       for (int i = 0; i < tokens.length; i++)
	           cows[i] = Integer.parseInt(tokens[i]);
	       
    	   /* 
    	    * 아이디어
    	    * 이진탐색 : 더 작은 쪽으로 이동
    	    * 히터의 위치가 변할 때, 각 소의 meltingTime 은 증가or감소 추세기 때문
    	    */
	       
			int L = 0;
			int R = N - 1;
			long minMaxMeltingTime = Long.MAX_VALUE;
			
	        while (L <= R) {
	            int M = (L + R) / 2;
	            long maxMeltingTime = calMaxMeltingTime(M);
	            // 0 < M, M < N - 1 = 인덱스 범위 밖 방지
	            long maxMeltingTimeL = (M > 0) ? calMaxMeltingTime(M - 1) : Long.MAX_VALUE;
	            long maxMeltingTimeR = (M < N - 1) ? calMaxMeltingTime(M + 1) : Long.MAX_VALUE;
	            
	            if (maxMeltingTimeL < maxMeltingTimeR) {
	            	if (maxMeltingTimeL < maxMeltingTime)
	            		R = M - 1;
	            	else {
		                minMaxMeltingTime = Math.min(minMaxMeltingTime, maxMeltingTimeL);
		                break;
	            	}
	            } else if (maxMeltingTimeR < maxMeltingTimeL) {
	            	if (maxMeltingTimeR < maxMeltingTime)
		                L = M + 1;
	            	else {
		                minMaxMeltingTime = Math.min(minMaxMeltingTime, maxMeltingTimeR);
		                break;
	            	}
	            } else {
	                minMaxMeltingTime = Math.min(minMaxMeltingTime, maxMeltingTime);
	                break;
	            }
	        }
	        
	        // L = R 인 경우 체크
	        minMaxMeltingTime = Math.min(minMaxMeltingTime, calMaxMeltingTime(L));
	        minMaxMeltingTime = Math.min(minMaxMeltingTime, calMaxMeltingTime(R));

	        System.out.println(minMaxMeltingTime);
		
	}
	
	static long calMaxMeltingTime(int H) {
		long maxMeltingTime = 0;
		
		for (int i = 0; i < N; i++)
			maxMeltingTime = Math.max(maxMeltingTime, Math.abs(H - i) * cows[i]);
		
		return maxMeltingTime;
	}
}