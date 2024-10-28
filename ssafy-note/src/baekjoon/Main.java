package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	static int W;
	static TreeMap<String, Boolean>[] words, copys;
	static char[][] board;
	static List<String>[][][] dp;
	static int totalScore, wordCnt, longgestWordLength;
	static String longgestWord;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		
		words = new TreeMap[9];
		for (int i = 1; i <= 8; i++)
			words[i] = new TreeMap<>();
		
		for (int w = 0; w < W; w++) {
			String line = br.readLine();
			int i = line.length();
			words[i].put(line, false);
		}
		
		br.readLine();
		st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= TC; tc++) {
			
			board = new char[4][4];
			for (int r = 0; r < 4; r++) {
				String line = br.readLine();
				for (int c = 0; c < 4; c++)
					board[r][c] = line.charAt(c);
			}
			
			if (tc != TC) br.readLine();
			
			copys = new TreeMap[9];
			for (int i = 1; i <= 8; i++) {
				copys[i] = new TreeMap<>();
				copys[i].putAll(words[i]);
			}
			
			/* 
			 * 출력
			 * 0 0점 	1-2
			 * 1 1점 	3-4
			 * 2 2점 	5
			 * 3 3점 	6
			 * 4 5점 	7
			 * 5 11점 	8
			 * 
			 * 중복 단어 = 한 번만 카운트 ~ totalScore++ & wordCnt++
			 * copys[길이] ~ 해당 단어 찾으면 value: false
			 * 가장 긴단어 : 사전 순 우선
			 * longgestWordLength 동일 ~ compareLonggestWord
			 * longgestWordLength 갱신 ~ longgestWord 등록
			 */
			
			totalScore = 0;
			wordCnt = 0;
			longgestWordLength = 0;
			longgestWord = "";
			dp = new ArrayList[4][4][9];
			for (int r = 0; r < 4; r++)
				for (int c = 0; c < 4; c++)
					for (int i = 0; i <= 8; i++)
						dp[r][c][i] = new ArrayList<>();
			
			for (int r = 0; r < 4; r++)
				for (int c = 0; c < 4; c++)
					getDp(r, c, 8);
			
			sb.append(totalScore).append(" ");
			sb.append(longgestWord).append(" ");
			sb.append(wordCnt).append("\n");
		}//tc
		
		System.out.println(sb);
	}
	
	static void getDp(int rNow, int cNow, int length) {
		
		if (length <= 0) {
			dp[rNow][cNow][length].add("");
			return;
		}
		
		char newChar = board[rNow][cNow];
		
		for (int d = 0; d < 8; d++) {
			
			int rNext = rNow + dr[d];
			int cNext = cNow + dc[d];
			
			if (rNext < 0 || 4 <= rNext || cNext < 0 || 4 <= cNext) continue;
			
			if (!dp[rNext][cNext][length - 1].isEmpty()) {
				
				for (String newStr : dp[rNext][cNext][length - 1]) {
					newStr = newChar + newStr;
					dp[rNow][cNow][length].add(newStr);
					calScore(length, newStr);
				}
			} else {
				getDp(rNext, cNext, length - 1);
				
				for (String newStr : dp[rNext][cNext][length - 1]) {
					newStr = newChar + newStr;
					dp[rNow][cNow][length].add(newStr);
					calScore(length, newStr);
				}
			}
		}
	}
	
	static void calScore(int length, String key) {
		
		if (copys[length].containsKey(key) && !copys[length].get(key)) {
			
			copys[length].remove(key);
			copys[length].put(key, true);
			
			wordCnt++;
			
			switch (length) {
			case 3:
				totalScore += 1;
				break;
			case 4:
				totalScore += 1;
				break;
			case 5:
				totalScore += 2;
				break;
			case 6:
				totalScore += 3;
				break;
			case 7:
				totalScore += 5;
				break;
			case 8:
				totalScore += 11;
				break;
			}
			
			if (length > longgestWordLength) {
				longgestWordLength = length;
				longgestWord = key;
			} else if (length == longgestWordLength) {
				if (longgestWord.isEmpty())
					longgestWord = key;
				else
					longgestWord = compareLonggestWord(key, longgestWord);
			}
		}
	}
	
	// 사전 순으로 A가 B 앞이면 음수, 뒤면 양수
	static String compareLonggestWord(String A, String B) {
		
		if (A.compareTo(B) < 0)
			return A;
		else
			return B;
	}
}