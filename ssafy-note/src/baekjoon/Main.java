package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int W, B;
	static char[][] words, board;
	static boolean[][] visited;
	
	// 0점 	1-2
	// 1점 	3-4
	// 2점 	5
	// 3점 	6
	// 5점 	7
	// 11점 	8
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());

		words = new char[W][];
		for (int w = 0; w < W; w++) {
			
			String line = br.readLine();
			words[w] = new char[line.length()];
			words[w] = line.toCharArray();
		}
		
		br.readLine();
		st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= TC; tc++) {
			
			board = new char[4][4];
			for (int r = 0; r < 4; r++) {
				String line = br.readLine();
				board[r] = line.toCharArray();
			}
			
			if (tc != TC)
				br.readLine();
			
			int maxScore = 0;
			int longestWordIdx = -1;
			int cnt = 0;
			
			
			
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < words[longestWordIdx].length; i++)
				tmp.append(words[longestWordIdx][i]);
			String longestWord = tmp.toString();
			
			sb.append(maxScore).append(" ").append(longestWord).append(" ").append(cnt).append("\n");
		}//tc
		
		System.out.println(sb);
	}
}