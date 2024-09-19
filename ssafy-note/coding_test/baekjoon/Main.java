package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

	       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	       
	       String line = reader.readLine().trim();
	       String[] tokens = line.split(" ");
	       
	       int N = Integer.parseInt(tokens[0]);
	       int H = Integer.parseInt(tokens[1]);
	       
	       Stack<Integer>[] flying = new Stack[H + 1];
	       for (int h = 1; h <= H; h++)
	    	   flying[h] = new Stack<>();
	       
	       int[] cave = new int[N];
	       for (int n = 0; n < N; n++) {
	    	   cave[n] = Integer.parseInt(reader.readLine().trim());
	    	   
	    	   if (n % 2 == 0) {
	    		   for (int h = 1; h <= cave[n]; h++)
	    			   flying[h].add(1);
	    	   } else {
	    		   for (int h = H; h >= H - cave[n] + 1; h--)
	    			   flying[h].add(1);
	    	   }
	       }

	       int min = Integer.MAX_VALUE;
	       int cnt = 0;
	       for (int h = 1; h <= H; h++) {
	    	   if (min > flying[h].size()) {
	    		   min = flying[h].size();
	    		   cnt = 1;
	    	   } else if (min == flying[h].size()) {
	    		   cnt++;
	    	   }
	       }
	       
	       System.out.println(min + " " + cnt);
	       
	}
}