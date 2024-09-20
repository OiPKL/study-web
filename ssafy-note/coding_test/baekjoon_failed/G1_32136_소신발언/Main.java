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
	        * maxMeltingTime 인 소의 위치를 maxCowL, maxCowR
	        * 찾은 소의 위치에서 히터의 위치가 가까워지면 갱신
	        * 찾은 소의 위치에서 히터의 위치가 멀어지면 볼 필요없음
	        */
	       
	       int L = 0;
	       int R = N - 1;
	       int H = (L + R) / 2;
	       int maxCowL = -1;
	       int maxCowR = -1;
	       long minMaxMeltingTime = Long.MAX_VALUE;
	       
	       while (  true  ) {
	    	   
	    	   long maxMeltingTimeL = 0;
	    	   for (int i = L; i <= H - 1; i++) {
	    		   long meltingTime = (H - i) * cows[i];
	    		   if (meltingTime >= maxMeltingTimeL) {
	    			   maxMeltingTimeL = meltingTime;
	    			   maxCowL = i;
	    		   }
	    	   }
	    	   
	    	   long maxMeltingTimeR = 0;
	    	   for (int i = R; i >= H + 1; i--) {
	    		   long meltingTime = (i - H) * cows[i];
	    		   if (meltingTime >= maxMeltingTimeR) {
	    			   maxMeltingTimeR = meltingTime;
	    			   maxCowR = i;
	    		   }
	    	   }
	    	   
	    	   if (maxMeltingTimeL < maxMeltingTimeR) {
	    		   minMaxMeltingTime = maxMeltingTimeR;
	    	   } else if (maxMeltingTimeR < maxMeltingTimeL) {
	    		   minMaxMeltingTime = maxMeltingTimeL;
	    	   } else {	// maxMeltingTimeL = maxMeltingTimeR
	    		   minMaxMeltingTime = maxMeltingTimeL;
	    	   }

	       }
	       
	       System.out.println(minMaxMeltingTime);
	       
	}
}