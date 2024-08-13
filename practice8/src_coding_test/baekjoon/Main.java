package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	// bigNum-1 : 0 ~ 9 올 수 있도록
    	System.out.println(whatsOnNext(10, N));
    		
    }
    
    static int cnt = 0;
    static List<Integer> num = new ArrayList<>();
    
    static int whatsOnNext (int bigNum, int N) {

    	if (cnt == N) {
    		int jaritsu = 1;
    		int answer = 0;
    		for (int i = num.size() - 1; i >= 0; i--) {
    			answer += num.get(i) * jaritsu;
    			jaritsu *= 10;
    		}
    	}

    	for (int i = 0; i < bigNum; i++) {
    		
    	}
    	
    }
    
}