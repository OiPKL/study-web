package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[][] solution(int n) {
    	
    	for (int i = n; i >= 1; i--) {
    		tower1.add(i);
    	}

    	hanoi(tower1);
    	
    	int N = records.size();
    	int[][] answer = new int[N][2];
    	
    	int idx = 0;
    	for (int[] record : records)
    		answer[idx++] = record;
    	
    	return answer;
    }

    Stack<Integer> tower1 = new Stack<>();
    Stack<Integer> tower2 = new Stack<>();
    Stack<Integer> tower3 = new Stack<>();
    List<int[]> records = new ArrayList<>();
    
    List<int[]> hanoi(List<Integer> selectedTower) {
    	
    	if (selectedTower.size() % 2 == 0) {
    		
    	} else {
    		
    	}
    	
    }
    
}

/*

!최종 규칙!
1. 	1번 타워 이동 가능 2가지	-> 홀수/짝수 여부 판단
	- 짝수 -> 목표 타워 x
	- 홀수 -> 목표 타워 o
2.	1번 타워 이동 가능 1가지 -> 남은 하나의 타워로
3. 	1번 타워 이동 가능 0가지 -> 또 다른 (n-1) 하노이 탑
	- 가장 작은 수가 있는 타워 '전체'를 1번이 아닌 다른 타워로

 */

class Main {
	public static void main(String[] args) {
		
	}
}