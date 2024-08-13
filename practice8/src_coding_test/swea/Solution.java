package swea;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int[][] test = new int[11][10];
    	int[] score = new int[11];
    	
    	for (int i = 0; i < 11; i++) {
    		for (int j = 0; j < 10; j++) {
    			test[i][j] = sc.nextInt();
    		}
    	}
    	
    	for (int i = 1; i <= 10; i++) {
    		for (int j = 0; j < 10; j++) {
    			if (test[i][j] == test[0][j])
    				score[i] += 10;
    		}
    	}
    	
    	int maxScore = -1;
    	int maxIdx = 0;
    	int minScore = 101;
    	int minIdx = 0;

    	for (int i = 1; i <= 10; i++) {
    		if (maxScore < score[i]) {
    			maxScore = score[i];
    			maxIdx = i;
    		}
    		if (minScore > score[i]) {
    			minScore = score[i];
    			minIdx = i;
    		}
    	}
    	
    	int sum = 0;
    	for (int i = 1; i <= 10; i++) {
    		if (i == maxIdx || i == minIdx) continue;
    		sum += score[i];
    	}
    	
    	int answer = 0;
    	answer = (sum+4) / 8;
    	System.out.println(answer);
    }
}