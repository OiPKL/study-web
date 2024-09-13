package baekjoon_failed.G1_32136_소신발언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim();
        
        String[] tokens = line.split(" ");
        int[] cows = new int[N];
        
        for (int i = 0; i < tokens.length; i++)
            cows[i] = Integer.parseInt(tokens[i]);

        // [소넘버][히터위치] 녹는시간 전부 미리 저장
        long[][] meltingTime = new long[N][N];
        for (int i = 0; i < N; i++)
        	for (int j = 0; j < N; j++)
        		meltingTime[i][j] = Math.abs(i - j) * cows[i];
        
        // 이진탐색
        int L = 0;
        int R = N - 1;
        int H = N / 2;
        
        long minMaxMeltingTime = Integer.MAX_VALUE;
        while (H != 0 && H != N - 1) {
        	long maxMeltingTimeL = Integer.MIN_VALUE;
        	for (int c = L; c < H - 1; c++)
        		maxMeltingTimeL = Math.max(maxMeltingTimeL, meltingTime[c][H]);
        	
        	long maxMeltingTimeR = Integer.MIN_VALUE;
        	for (int c = H + 1; c < R; c++)
        		maxMeltingTimeR = Math.max(maxMeltingTimeR, meltingTime[c][H]);
        	
        	if (maxMeltingTimeL >= maxMeltingTimeR) {
        		H = H / 2;
        		R = H - 1;
        	} else {
        		H = H + H / 2;
        		L = H + 1;
        	}
        	
            minMaxMeltingTime = Math.min(minMaxMeltingTime, Math.max(maxMeltingTimeL, maxMeltingTimeR));
        }
        
        // H = 0
        
        
        // H = N - 1
        
        System.out.println(minMaxMeltingTime);
    }
}