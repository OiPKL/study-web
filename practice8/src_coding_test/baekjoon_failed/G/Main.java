package baekjoon_failed.G;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = 1;
        List<Integer> showN = new ArrayList<>();

        pickN(N, M, start, showN);
    }
    
    static void pickN(int N, int M, int start, List<Integer> showN) {
    	
    	if (showN.size() == M) {
    		for (int num : showN)
    			System.out.print(num + " ");
    		System.out.println();
    		return;
    	}
    	
    	for (int i = start; i <= N; i++) {
    		showN.add(start++);				// 배열에 원소 추가
    		pickN(N, M, i + 1, showN);		// if 꽉찬 배열 ~ 출력 후 ~ 리턴해서 다시 여기로
    		showN.remove(showN.size() - 1); // 마지막 원소 삭제 ~ 
    	}
    	
    }
    
}