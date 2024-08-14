package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

    	// Queue bridge 사이즈는 2 * bridge_length
    	// Queue bridge 총합 <= weight
    	Queue<Integer> bridge = new LinkedList<>();
    	List<Integer> bridgeGunnu = new ArrayList<>();
    	int time = 0;
    	
    	while (bridgeGunnu.size() == truck_weights.length * 2) {
    		
    	}
    	
    	return time;
    	
    }
}

class Main {
	public static void main(String[] args) {
		
	}
}