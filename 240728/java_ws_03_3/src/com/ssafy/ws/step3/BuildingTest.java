package com.ssafy.ws.step3;

import java.util.Scanner;

public class BuildingTest {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		char[][][] build = new char[T][][];
		int[] height = new int[T];
		
		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();
			build[i] = new char[N][N];
			
			for (int j = 0; j < N; j++) {
				
				build[i][j] = new char[N];
				
				for (int k = 0; k < N; k++) {
					
					build[i][j][k] = sc.next().charAt(0);
					
				}
				
			}
			
			// --------------------------------------------------
			
            for (int j = 0; j < N; j++) {
                
                for (int k = 0; k < N; k++) {
                    if (build[i][j][k] == 'B') {
                        int cnt = 1;
                        boolean surroundedByGarden = true;

                        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

                        for (int d = 0; d < 8; d++) {
                            int nx = j + dx[d];
                            int ny = k + dy[d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (build[i][nx][ny] == 'B') {
                                    cnt++;
                                } else {
                                    surroundedByGarden = false;
                                }
                            } else {
                                surroundedByGarden = false;
                            }
                        }

                        if (surroundedByGarden) {
                            cnt = 2;
                        }

                        height[i] = Math.max(height[i], cnt);
                    }
                }
            }
			
			// --------------------------------------------------
			
			for (int num : height)
				System.out.println("#" + (num+1) + ": " + num);
			
		}
					
	}
}
