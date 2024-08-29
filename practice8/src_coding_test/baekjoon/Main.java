package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N;
	static int M;
	static int[] NN;
	static Stack<Boolean>[] overlapped;	// 기존 visited 상위호환
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NN = new int[N];
		overlapped = new Stack[10000];
		for (int i = 0; i < 10000; i++) {
			overlapped[i] = new Stack<>();
		}
		
		for (int n = 0; n < N; n++) {
			int num = sc.nextInt();
			NN[n] = num;
			overlapped[num].add(true);
		}
		Arrays.sort(NN);
		
		btk(new ArrayList<>());
	}
	
	static void btk(List<Integer> pickN) {
		if(pickN.size() == M) {
			for (int num : pickN)
				System.out.print(num + " ");
			System.out.println();
			
			return;
		}
		
		for (int n = 0; n < N; n++) {
			if (!overlapped[NN[n]].isEmpty()) {
				
			}
		}
		
		for (int n = 0; n < N; n++) {
			if (!visited[n]) {
				if (overlapped[NN[n]] > 0) {
					if (overlapped[NN[n]] > 1) {
						overlapped[NN[n]]--;
						pickN.add(NN[n]);
						btk(pickN);
						pickN.remove(pickN.size() - 1);
						overlapped[NN[n]]++;
					} else {
						visited[n] = true;
						pickN.add(NN[n]);
						btk(pickN);
						pickN.remove(pickN.size() - 1);
						visited[n] = false;
					}
				}
			}
		}
		
	}
}