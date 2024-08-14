package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer> tower = new ArrayList<>();
		List<Integer> tower1 = new ArrayList<>();
		int sum = 0;
		for (int n = 0; n < N; n++) {
			int block = sc.nextInt();
			tower.add(block);
			sum += block;
		}
		
		for (int n = 1; n <= N; n++) {
			makeTower1(tower, tower1, 0, n, sum, 0);
		}
		
		System.out.println(minSum);
		System.out.println(Math.max(sum - memoSum, memoSum));
		
	}
	
	static int minSum = 999999999;
	static int memoSum = 0;
	
	static void makeTower1(List<Integer> tower, List<Integer> tower1, int blocks, int maxBlocks, int sum, int sum1) {
		if (blocks == maxBlocks) {
			System.out.print("tower1: ");		//
			for (int num : tower1) {
				System.out.print(num + " ");	//
				sum1 += num;
			}									//
			System.out.println();				//
			minSum = Math.min(minSum, Math.abs((sum - sum1) - sum1));
			memoSum = sum1;
			return;
		}
		
		for (int n = blocks; n < maxBlocks; n++) {
			tower1.add(tower.get(n));
			makeTower1(tower, tower1, blocks + 1, maxBlocks, sum, sum1);
			tower1.remove(tower1.size()-1);
		}
	}
	
}