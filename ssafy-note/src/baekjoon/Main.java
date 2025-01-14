package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer> arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList<>();
		visited = new boolean[N+1];
		
		btk();
		
		System.out.println(sb);
	}
	
	static void btk() {
		
		if (arr.size() == M) {
			
			for (int num : arr)
				sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			
			if (!visited[i]) {
				
				visited[i] = true;
				arr.add(i);
				btk();
				arr.remove(arr.size() - 1);
				visited[i] = false;
			}
		}
	}
}