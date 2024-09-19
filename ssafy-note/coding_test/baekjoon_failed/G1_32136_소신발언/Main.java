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
	       int R = N -1;
	       long maxMeltingTime = Long.MIN_VALUE;
	       long minMaxMeltingTime = Long.MAX_VALUE;
	       
	       int maxH = 0;
	       int H = (L + R) / 2;
	       for (int i = L; i <= R; i++) {
	    	   long meltingTime = Math.abs(H - i) * cows[i];
	    	   if (meltingTime > maxMeltingTime) {
	    		   maxH = i;
	    		   maxMeltingTime = meltingTime;
	    	   }
	       }
	       
	       minMaxMeltingTime = maxMeltingTime;
	       
	       while (L <= R) {
	    	   
		       long maxMeltingTimeL = Long.MIN_VALUE;
		       long maxMeltingTimeR = Long.MIN_VALUE;
	    	   
	    	   if (maxH < H) {
	    		   if (maxH < ((L + H) / 2)) {
	    			   
	    		   } else {
	    			   
	    		   }
	    	   } else {
	    		   if (maxH < ((H + R) / 2)) {
	    			   
	    		   } else {
	    			   
	    		   }
	    	   }

	    	   

	       }
		
	}
	
}