package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] NN;
	static Queue<Boolean>[] overlapped;				// 기존 visited 상위호환

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NN = new int[N];
		overlapped = new Queue[10000];
		for (int i = 0; i < 10000; i++)
			overlapped[i] = new LinkedList<>();
		
		for (int n = 0; n < N; n++) {
			int num = sc.nextInt();
			NN[n] = num;
			overlapped[num].add(overlapped[num].isEmpty() ? false : true);
		}
		
		Arrays.sort(NN);
		
		btk(new ArrayList<>());
		
	}
	
	static void btk(List<Integer> pickN) {
		if (pickN.size() == M) {
			for (int num : pickN)
				System.out.print(num + " ");
			System.out.println();
			
			return;
		}
		
		for (int n = 0; n < N; n++) {
			if (!overlapped[NN[n]].isEmpty()) {
				
				boolean tmp = overlapped[NN[n]].peek();
				
				if (tmp == false) {					// 중복원소 중 두개 이상 뽑을 경우에만
					
				} else {							// 첫번째 원소
					overlapped[NN[n]].poll();
					pickN.add(NN[n]);
					btk(pickN);
					pickN.remove(pickN.size() - 1);
					overlapped[NN[n]].add(tmp);
				}
			}
			
			
			
			
			
		}
	}
	
}
