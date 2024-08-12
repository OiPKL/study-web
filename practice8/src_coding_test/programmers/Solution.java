package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int[] priorities, int location) {
    	
    	Queue <Integer> processQueue = new LinkedList<>();
    	
    	int num = 1;
    	for (int i = 0; i < priorities.length; i++) {
    		// 처음배열순서, 우선순위, 처음배열순서, 우선순위,,,
    		processQueue.offer(num++);
    		processQueue.offer(priorities[i]);
    	}
    	
    	while (!(processQueue.isEmpty())) {
    		int tmp = 0;
    	}

    	while (!(processQueue.isEmpty())) {
    		for (int i = 1; i < processQueue.size(); i++) {
    			if (processQueue.peek()[1] < ((LinkedList<Integer[]>) processQueue).get(i)[1]) {
    				processQueue.offer(processQueue.poll());
    			} else {
    				completedQueue.offer(processQueue.poll());
    			}
    		}
    	}
    	
    	return ((LinkedList<Integer[]>) completedQueue).get(location)[0];
    	
    }
}

class Main {
	public static void main(String[] args) {
		
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		int answer = Solution.solution(priorities, location);
		System.out.println(answer);
		
	}
}