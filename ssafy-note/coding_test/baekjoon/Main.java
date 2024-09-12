package baekjoon;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
	        Map<String, List<String>> removed = new HashMap<>();
			PriorityQueue<String> minHeap = new PriorityQueue<>();
			PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			int K = sc.nextInt();
			sc.nextLine();
			
			for (int k = 0; k < K; k++) {
				String line = sc.nextLine();
				char cmd = line.charAt(0);
				char ops = line.charAt(2);
				
				if (cmd == 'I') {
					if (ops == '-') {
						
					}
				} else {
					if (!minHeap.isEmpty()) {
						if (ops == '-') {
							
						} else {
							
						}
					}
				}
			}
			
		}//TC
	}
}

/*
 * 							removed.putIfAbsent("asdf", new ArrayList<>());
							removed.get("key").add(123);
 */
