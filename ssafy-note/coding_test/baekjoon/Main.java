package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// GPT 췐스 시작
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim();
        
        String[] tokens = line.split(" ");
        int[] cows = new int[N];
        
        int K1 = 0;	// 첫번째로 큰 수
        int K2 = 0;	// 두번째로 큰 수
        List<Integer> K1List = new ArrayList<>();
        List<Integer> K2List = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	int cow = Integer.parseInt(tokens[i]);
        	cows[i] = i;
        	
        	if (cow > K1) {
        		K1 = cow;
        		K1List = new ArrayList<>();
        		K1List.add(i);
        	} else if (cow == K1)
        		K1List.add(i);
        }
        
        findK2:
        for (int i = 0; i < N; i++) {
        	for (int idx : K1List)
        		if (idx == i) continue findK2;
        	
        	if (cows[i] > K2) {
        		K2 = cows[i];
        		K2List = new ArrayList<>();
        		K2List.add(i);
        	} else if (cows[i] == K2)
        		K2List.add(i);
        }
        
        
        
        
        for (int i = 0; i < N; i++) {
        	int cow = Integer.parseInt(tokens[i]);
        	cows[i] = cow;
        	
        	if (cow > K1) {
        		K1 = cow;
        		idx1 = i;
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	if (i == K1) continue;
        	
        	if (cows[i] >= K2) {
        		K2 = cows[i];
        		idx2 = i;
        	}
        }
        // GPT 췐스 종료
		
        
		
		System.out.println();
		
	}//main
}//Main