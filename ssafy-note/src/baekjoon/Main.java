package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, rNow, cNow, dNow, rNext, cNext, dNext, cnt = 0, tmp = 0;
	static int[][] ruleA, ruleB;
	static boolean[][] map;
	static boolean cleaned = false;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
    public static void main(String[] args) throws IOException {
    	
    	// 현재 칸 먼지 제거
    	// 규칙표 : 현재 좌표에 적힌 만큼 시계방향 회전
    	// 먼지 제거 O (A) : 
    	// 먼지 제거 X (B) : 
    	// 바라보는 방향으로 한 칸 전진
    	// 작동 중지	- 이동 후 영역 밖 벗어나면
    	// 			- 반복해도 더 이상 먼지 제거 불가

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        rNow = Integer.parseInt(st.nextToken());
        cNow = Integer.parseInt(st.nextToken());
        dNow = Integer.parseInt(st.nextToken());
        
        map = new boolean[R][C];
        ruleA = new int[R][C];
        ruleB = new int[R][C];
        
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
        
        move:
        while (true) {
        	
        	tmp = 0;
        	rNext = rNow;
        	cNext = cNow;
        	dNext = dNow;
        	
        	clean:
        	while (true) {
        		
        		if (cleaned) {	// ruleA
        			
        			if (!map[rNext][cNext])
        				map[rNext][cNext] = true;

        			
        		} else {		// ruleB
        			
        			if (!map[rNext][cNext])
        				map[rNext][cNext] = true;
        			
        			
        		}
        	}
        }
    }
}