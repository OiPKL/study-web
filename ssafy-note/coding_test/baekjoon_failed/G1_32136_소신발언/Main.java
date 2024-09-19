package baekjoon_failed.G1_32136_소신발언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

	       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	       int N = Integer.parseInt(reader.readLine().trim());
	       String line = reader.readLine().trim();
	       
	       String[] tokens = line.split(" ");
	       int[] cows = new int[N];
	       
	       for (int i = 0; i < tokens.length; i++)
	           cows[i] = Integer.parseInt(tokens[i]);
	       
    	   /* 
    	    * 아이디어
    	    * 이진탐색 : 더 작은 쪽으로 이동
    	    * 히터의 위치가 변할 때, 각 소의 meltingTime 은 증가or감소 추세기 때문
    	    */
	       
	       int L = 0;
	       int R = N - 1;
	       int H = (L + R) / 2;
	       int maxH = -1;
	       long meltingTime;
	       long maxMeltingTime = Long.MIN_VALUE;
	       long minMaxMeltingTime = Long.MAX_VALUE;
	       
	       for (int i = L; i <= R; i++) {
	    	   meltingTime = Math.abs(H - i) * cows[i];
	    	   if (meltingTime > maxMeltingTime) {
	    		   maxH = i;
	    		   maxMeltingTime = meltingTime;
	    	   }
	       }
	       
	       minMaxMeltingTime = maxMeltingTime;
	       
	       while (L < H && H < R) {
	    	   
	    	   maxMeltingTime = Long.MIN_VALUE;
	    	   
	    	   if (maxH < H) {
	    		   R = H;
	    		   H = (L + R) / 2;
	    		   
	    	       for (int i = L; i <= R; i++) {
	    	    	   meltingTime = Math.abs(H - i) * cows[i];
	    	    	   if (meltingTime > maxMeltingTime) {
	    	    		   maxH = i;
	    	    		   maxMeltingTime = meltingTime;
	    	    	   }
	    	       }
	    	   } else {
	    		   L = H;
	    		   H = (L + R) / 2;
	    		   
	    	       for (int i = L; i <= R; i++) {
	    	    	   meltingTime = Math.abs(H - i) * cows[i];
	    	    	   if (meltingTime > maxMeltingTime) {
	    	    		   maxH = i;
	    	    		   maxMeltingTime = meltingTime;
	    	    	   }
	    	       }
	    	   }

	    	   minMaxMeltingTime = Math.min(minMaxMeltingTime, maxMeltingTime);
	    	   
	       }
	       
	       System.out.println(minMaxMeltingTime);
		
	}
}