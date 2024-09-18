package baekjoon_failed.G1_32136_소신발언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] cows;
//	static long[][] meltingTime;
	
	public static void main(String[] args) throws IOException {
		
	       Scanner sc = new Scanner(System.in);

	       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	       N = Integer.parseInt(reader.readLine().trim());
	       String line = reader.readLine().trim();
	       
	       String[] tokens = line.split(" ");
	       cows = new int[N];
	       
	       for (int i = 0; i < tokens.length; i++)
	           cows[i] = Integer.parseInt(tokens[i]);
	       
//	       // [소넘버][히터위치] -> meltingTime 계산
//	       meltingTime = new long[N][N];
//	       for (int i = 0; i < N; i++)
//	    	   for (int j = 0; j < N; j++)
//	    		   meltingTime[i][j] = Math.abs(i - j) * cows[i];
	       
	       int L = 0;
	       int R = N -1;
	       long minMaxMeltingTime = Long.MAX_VALUE;
	       
	       while (L <= R) {
	    	   int H = (L + R) / 2;
	    	   
	    	   long maxMeltingTimeL = calMaxMeltingTime(H);
	    	   long maxMeltingTimeR = Long.MAX_VALUE;
	    	   if (H + 1 < N)
	    		   maxMeltingTimeR = calMaxMeltingTime(H + 1);
	    	   
	    	   /* 
	    	    * 아이디어
	    	    * 이진탐색 : 더 작은 쪽으로 이동
	    	    * 히터의 위치가 변할 때, 각 소의 meltingTime 은 증가or감소 추세기 때문
	    	    */
	    	   if (maxMeltingTimeL < maxMeltingTimeR) {
	    		   minMaxMeltingTime = Math.min(minMaxMeltingTime, maxMeltingTimeL);
	    		   R = H - 1;
	    	   } else {
	    		   minMaxMeltingTime = Math.min(minMaxMeltingTime, maxMeltingTimeR);
	    		   L = H + 1;
	    	   }
	       }
	       
	       System.out.println(minMaxMeltingTime);
	       
	}
	
	static long calMaxMeltingTime(int H) {
		
		long maxMeltingTime = 0;
//		for (int i = 0; i < N; i++)
//			maxMeltingTime = Math.max(maxMeltingTime, meltingTime[i][H]);
        for (int i = 0; i < N; i++) {
            long currentMeltingTime = Math.abs(i - H) * cows[i];
            maxMeltingTime = Math.max(maxMeltingTime, currentMeltingTime);
        }
		
		return maxMeltingTime;
	}
	
}