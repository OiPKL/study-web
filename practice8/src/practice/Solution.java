package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static List<Integer> tower = new ArrayList<>();
	static Stack<Integer> tower0 = new Stack<>();
	static List<Integer> tower00 = new ArrayList<>();
	static Stack<Integer> tower000 = new Stack<>();
	static List<Integer> tower1 = new ArrayList<>();
	static Stack<Integer> tower11 = new Stack<>();
	static List<Integer> tower2 = new ArrayList<>();
	static Stack<Integer> tower22 = new Stack<>();
	
	static int sum = 0;
	static int sum1 = 0;
	static int sum2 = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// tower 입력 & 정렬 & 합
		int N = sc.nextInt();
		for (int n = 0; n < N; n++) {
			tower.add(sc.nextInt());
		}
		Collections.sort(tower);
		for (int n = 0; n < N; n++) {
			tower0.add(tower.get(n));
			sum += tower.get(n);
		}
		
		addTower1(tower1, tower0);
		for (int n = 0; n < tower1.size(); n++)
			tower11.add(tower1.get(n));
		for (int n = 0; n < tower2.size(); n++)
			tower22.add(tower2.get(n));
		
		while (true) {
			sum1 -= tower11.peek();
			tower00.add(tower11.pop());
			if (sum1 < sum/2) break;
		}
		
		while (true) {
			sum2 -= tower22.peek();
			tower00.add(tower22.pop());
			if (sum2 < sum/2) break;
		}
		
		for (int n = 0; n < tower00.size(); n++)
			tower000.add(tower00.get(n));
		
//		for (int num : tower00)
//			System.out.print(num + " ");
//		System.out.println();
		
		if (sum1 > sum2)
			addTower4(tower11, tower000);
		else
			addTower4(tower22, tower000);
		
		System.out.println(Math.max(sum1, sum2));
		
	}

	static void addTower1(List<Integer> tower1, Stack<Integer> tower0) {
		int N = tower0.size();
		if (N == 0 || sum1 > sum/2) return;
		
		sum1 += tower0.peek();
		tower1.add(tower0.pop());
		addTower2(tower2, tower0);
		addTower1(tower1, tower0);
	}
	
	static void addTower2(List<Integer> tower2, Stack<Integer> tower0) {
		int N = tower0.size();
		if (N == 0 || sum2 > sum/2) return;
		
		sum2 += tower0.peek();
		tower2.add(tower0.pop());
		addTower1(tower1, tower0);
		addTower2(tower2, tower0);
	}
	
	static void addTower3(Stack<Integer> tower11, Stack<Integer> tower000) {
		int N = tower000.size();
		if (N == 0) return;
		
		sum1 += tower000.peek();
		tower11.add(tower000.pop());
		addTower4(tower22, tower0);
		addTower3(tower11, tower0);
	}
	
	static void addTower4(Stack<Integer> tower22, Stack<Integer> tower000) {
		int N = tower000.size();
		if (N == 0) return;
		
		sum2 += tower000.peek();
		tower22.add(tower000.pop());
		addTower3(tower11, tower0);
		addTower4(tower22, tower0);
	}
	
}