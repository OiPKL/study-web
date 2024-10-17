package baekjoon_failed.G4_20166_문자열지옥에빠진호석;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, M, K;
	static int[] dn = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dm = {-1, 0, 1, 1, 1, 0, -1, -1};
	static char[][] map;
	static List<StringBuilder>[][] dp;
	static List<String> words;
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	K = sc.nextInt();
    	sc.nextLine();
    	
    	map = new char[N][M];
    	for (int n = 0; n < N; n++)
    		map[n] = sc.nextLine().toCharArray();

    	words = new ArrayList<>();
    	for (int k = 0; k < K; k++)
    		words.add(sc.nextLine());
    	
    	dp = new ArrayList[N][M];
    	for (int n = 0; n < N; n++) {
    		for (int m = 0; m < M; m++) {
    			dp[n][m] = new ArrayList<>();
    			getDp(new StringBuilder(Character.toString(map[n][m])), n, m, n, m);
    			Collections.sort(dp[n][m], (a, b) -> a.toString().compareTo(b.toString()));
    		}
    	}
    	
    	sb = new StringBuilder();
    	for (String word : words) {
    		int cnt = 0;
    		for (int n = 0; n < N; n++) {
    			for (int m = 0; m < M; m++) {
    				
    				for (StringBuilder memo : dp[n][m])
    					if (word.equals(memo.toString())) cnt++;
    				
    			}
    		}
    		
    		sb.append(cnt).append("\n");
    	}
    	
    	System.out.println(sb);
    }
    
    static void getDp(StringBuilder str, int nStart, int mStart, int nNow, int mNow) {
    	
    	if (str.length() < 1 || str.length() > 5)
    		return;
    	
    	dp[nStart][mStart].add(new StringBuilder(str));
    	
    	for (int d = 0; d < 8; d++) {
    		int nNext = (nNow + dn[d] + N) % N;
    		int mNext = (mNow + dm[d] + M) % M;
    		
            str.append(Character.toString(map[nNext][mNext]));
            getDp(str, nStart, mStart, nNext, mNext);
            str.setLength(str.length() - 1);
    	}
    	
    }
}