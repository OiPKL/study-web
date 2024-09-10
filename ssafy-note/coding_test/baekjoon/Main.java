package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] cows;
	
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim();
        
        String[] tokens = line.split(" ");
        cows = new int[N];

        for (int i = 0; i < N; i++)
        	cows[i] = Integer.parseInt(tokens[i]);
        
        // 아이디어
        // maxHit : |i-j| * cows[i]
        // maxHit 보다 커지려면 cows[i] 가 있는 |i-j| 밖이어야 함
        // 인덱스의 왼쪽&오른쪽 끝까지 도달할때까지 가장 큰 cows[i] 찾기
        
        long minHit = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
        	
        	long maxHit = Integer.MIN_VALUE;
    		
    		for (int j = 0; j <= N - 1; j++) {
    			if (cows[j] > biggestIce) {
    				biggestIce = cows[j];
    				biggestIceIdx = new ArrayList<>();
    				biggestIceIdx.add(j);
    			} else if (cows[i] == biggestIce) {
    				biggestIceIdx.add(j);
    			}
    		}
    		
    		int farDistance = Integer.MIN_VALUE;
    		int farIdx = 0;
    		for (int idx : biggestIceIdx) {
    			int distance = Math.abs(i - idx);
    			if (distance >= farDistance) {
    				farDistance = distance;
    				farIdx = idx;
    			}
    		}
    		
    		int leftStart = 0;
    		int leftEnd = ;
    		int rightStart = ;
    		int rightStart = N - 1;

    		while (leftStart != leftEnd && rightStart != rightEnd) {
    			
    		}

    		while (leftStart != leftEnd) {
        		
        	}
    		
    		while (rightStart != rightEnd) {
    			
    		}
        	
        }
        
        System.out.println(minHit);
    }
	
	static List<Integer> getFarIdxList(int start, int end) {
		
		int biggestIce = Integer.MIN_VALUE;
		List<Integer> biggestIceIdx = new ArrayList<>();
		
		return biggestIceIdx
	}
}