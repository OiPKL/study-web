package programmers;

import java.util.Stack;

class Solution {
	
	static int R, maxSum, sum, rNow, cNow, rNext, cNext;
	
    public int solution(int[][] triangle) {
    	
    	R = triangle.length;
    	maxSum = 0;
    	
    	Stack<int[]> dfs = new Stack<>();
    	dfs.add(new int[] {0, 0, triangle[0][0]});
    	
    	while (!dfs.isEmpty()) {
    		int[] now = dfs.pop();
    		rNow = now[0];
    		cNow = now[1];
    		sum = now[2];
    		
    		rNext = rNow + 1;
    		
    		if (rNext >= R) {
    			maxSum = Math.max(maxSum, sum);
    			continue;
    		}
    		
    		for (int c = 0; c <= 1; c++) {
    			cNext = cNow + c;
    			sum += triangle[rNext][cNext];
    			
    			dfs.add(new int[] {rNext, cNext, sum});
    		}
    	}
    	
    	return maxSum;
    	
    }
}