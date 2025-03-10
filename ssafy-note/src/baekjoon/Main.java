package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int rNow = Integer.parseInt(st.nextToken());
        int cNow = Integer.parseInt(st.nextToken());
        int dNow = Integer.parseInt(st.nextToken());
        
        boolean[][] map = new boolean[R][C];
        int[][] ruleA = new int[R][C];
        int[][] ruleB = new int[R][C];
		
        int cnt = 0, totalCnt = 0;
        int rNext = -1, cNext = -1, dNext = -1;
        int rNNext = -1, cNNext = -1, dNNext = -1;
        boolean innerCleaned = false, outerCleaned = false;
        
        for (int r = 0; r < R; r++) {
        	String line = br.readLine();
        	for (int c = 0; c < C; c++)
        		ruleA[r][c] = line.charAt(c) - '0';
        }
        
        for (int r = 0; r < R; r++) {
        	String line = br.readLine();
        	for (int c = 0; c < C; c++)
        		ruleB[r][c] = line.charAt(c) - '0';
        }
        
        outer:
        while (true) {
        	
        	cnt = 0;
        	rNext = rNow;
        	cNext = cNow;
        	dNext = dNow;
        	outerCleaned = false;
        	
        	inner:
        	while (true) {
        		
        		innerCleaned = false;
        		
        		if (!map[rNext][cNext]) {
        			innerCleaned = true;
        			outerCleaned = true;
        			map[rNext][cNext] = true;
        		}
        		
        		if (innerCleaned)
        			dNNext = (dNext + ruleA[rNext][cNext]) % 4;
        		else
        			dNNext = (dNext + ruleB[rNext][cNext]) % 4;
        		
        		rNNext = rNext + dr[dNNext];
        		cNNext = cNext + dc[dNNext];
        		
        		if (rNNext < 0 || R <= rNNext || cNNext < 0 || C <= cNNext) {
        			if (outerCleaned)
        				totalCnt += cnt;
        			break outer;
        		}
        		
        		cnt++;
        		rNext = rNNext;
        		cNext = cNNext;
        		dNext = dNNext;
        		
        		if (rNNext == rNow && cNNext == cNow && dNNext == dNow) {
        			if (outerCleaned)
        				totalCnt += cnt;
        			break outer;
        		}
        	}
        }
        
        System.out.println(totalCnt);
	}
}