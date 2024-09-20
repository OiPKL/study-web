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
	        * 찾은 소의 위치로부터 히터의 위치가 가까워지면 갱신
	        * 찾은 소의 위치로부터 히터의 위치가 멀어지면 볼 필요없음
	        */
	       
	       int L = 0;
	       int R = N - 1;
	       int oldH = L;
	       int newH = (L + R) / 2;
	       
	       long maxMeltingTime = 0;
	       for (int i = L; i <= R; i++) {
	    	   long meltingTime = Math.abs(i - oldH) * cows[i];
	    	   maxMeltingTime = Math.max(maxMeltingTime, meltingTime);
	       }
	       long minMaxMeltingTime = maxMeltingTime;
	       
	       while (oldH <= newH) {
	    	   
	    	   maxMeltingTime = 0;
	    	   for (int i = L; i <= R; i++) {
		    	   long meltingTime = Math.abs(i - newH) * cows[i];
		    	   maxMeltingTime = Math.max(maxMeltingTime, meltingTime);
		       }
	    	   
	    	   if (minMaxMeltingTime < maxMeltingTime) {
	    		   
	    	   }
	    	   
//	    	   newH = (oldH + newH) / 2; ???
//	    	   
//	    	   newH = (newH + R) / 2; ???
	    	   
	       }
	       
	       System.out.println(minMaxMeltingTime);
	       
	}
}