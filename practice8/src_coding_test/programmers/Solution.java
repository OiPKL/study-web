package programmers;

class Solution {
    public static int solution(int n, int a, int b) {
    	int cnt = 0;
    	
    	while(Math.abs(a - b) != 1) {
    		a /= 2;
    		b /= 2;
    		cnt++;
    	}
    	
    	return cnt;
    }
}

class Main {
	public static void main(String[] args) {
		System.out.println(Solution.solution(8, 4, 7));
	}
}