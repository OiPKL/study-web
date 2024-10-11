package programmers;

import java.util.Arrays;

class Solution {
	
	static int[] between;
	
    public int solution(int D, int[] rocks, int N) {
    	
    	Arrays.sort(rocks);
    	
    	between = new int[rocks.length+1];
    	
    	int tmp = 0;
    	for (int i = 0; i < rocks.length; i++) {
    		int rock = rocks[i];
    		between[i] = rock - tmp;
    		tmp = rock;
    	}
    	between[rocks.length] = D - tmp;
    	
    	
    	
    }
}