package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int tmp;
	static List<Queue<Integer>> orderList = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[] nums = new int[N];
		int[] ops = new int[4];
		for (int n = 0; n < N; n++)
			nums[n] = sc.nextInt();
		for (int n = 0; n < 4; n++)
			ops[n] = sc.nextInt();
		
		long max = Integer.MIN_VALUE;
		long min = Integer.MAX_VALUE;
		
		makeOrderList(ops, new LinkedList<>());
		
		for (int i = 0; i < orderList.size(); i++) {
			Queue<Integer> order = orderList.get(i);
			
			int idx = 0;
			long ans = nums[idx];
			int num = nums[++idx];
			int op = orderList.get(i).poll();
			
			if (op == 0)
				ans += num;
			if (op == 1)
				ans -= Math.abs(ans);
			if (op == 2)
				ans *= num;
			if (op == 3)
				ans /= num;
			
			max = Math.max(max, ans);
			min = Math.min(min, ans);
		}
		
		System.out.println(max);
		System.out.println(min);
		
	}

	static void makeOrderList(int[] ops, Queue<Integer> order) {
		if (order.size() == N - 1) {
			orderList.add(order);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (ops[i] > 0) {
				tmp = ops[i]--;
				order.offer(i);
				tmp++;
			}
		}
		
	}
	
}
