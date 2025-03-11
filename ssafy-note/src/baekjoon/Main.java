package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()) - 1;
		int N = Integer.parseInt(st.nextToken()) - 1;
		int K = Integer.parseInt(st.nextToken());
		
		int[][] visited = new int[N][M];
		
		HashMap<Integer, Integer> hashmapN = new HashMap<>();
		HashMap<Integer, Integer> hashmapM = new HashMap<>();
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int btnN = Integer.parseInt(st.nextToken()) - 1;
			int btnM = Integer.parseInt(st.nextToken()) - 1;
			
			hashmapN.put(btnN, btnM);
			hashmapM.put(btnM, btnN);
		}
		
		int time = 0;
		int nNow = 0;
		int mNow = 0;
		boolean garo = false;	// true = btnN, false = btnM
		
		Queue<int[]> bfs = new LinkedList<>();
		bfs.add(new int[] {0, 0});
		
		while (!bfs.isEmpty()) {
			
			
		}
		
		if (nNow == N - 1 && mNow == M - 1)
			System.out.println(visited[nNow][mNow]);
		else
			System.out.println(-1);
	}
}