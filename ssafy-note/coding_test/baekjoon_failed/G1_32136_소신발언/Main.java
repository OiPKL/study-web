package baekjoon_failed.G1_32136_소신발언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static int N;
	static int[] cows;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim();
        
        String[] tokens = line.split(" ");
        cows = new int[N];

        for (int i = 0; i < N; i++)
        	cows[i] = Integer.parseInt(tokens[i]);
        
        int L = 0;
        int R = N - 1;
        int oldH = L;						// 기준점 이었던것
        int newH = L;						// 히터위치(기준점)
        long maxHit = Integer.MIN_VALUE;
        long minMaxHit = Integer.MAX_VALUE;
        
        while (L + 1 < R) {
        	
        	int[] maxHList = maxHfinder(L + 1, R);
        	newH = oldH = maxHList[0];
        	maxHit = (long) cows[newH] * (newH - oldH);
        	
        	if (maxHit < minMaxHit) {
        		minMaxHit = maxHit;
        		L = newH;
        	} else
        		break;
        }
        
        System.out.println(minMaxHit);
        
	}
        
        
	static int[] maxHfinder(int start, int end) {
		
		Deque<Integer> maxHList = new LinkedList<>();
		int maxH = Integer.MIN_VALUE;
		
		for (int idx = start; idx <= end; idx++) {
			if (cows[idx] > maxH) {
				maxHList = new LinkedList<>();
				maxHList.addLast(idx);
				maxH = cows[idx];
			} else if (cows[idx] == maxH) {
				maxHList.addLast(idx);
			}
		}
		
		int minIdx = maxHList.peekFirst();
		int maxIdx = maxHList.peekLast();
		
		return (new int[] {minIdx, maxIdx});
	}
}