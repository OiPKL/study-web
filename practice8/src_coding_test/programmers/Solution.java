package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int[] priorities, int location) {
    	
    	Queue <Integer[]> processQueue = new LinkedList<>();
    	Queue <Integer[]> completedQueue = new LinkedList<>();
    	
    	int num = 1;
    	for (int i = 0; i < priorities.length; i++) {
    		// process = { 처음배열순서 = 반환할값, 우선순위 }
    		Integer[] process = new Integer[2];
    		process[0] = num++;
    		process[1] = priorities[i];
    		processQueue.offer(process);
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