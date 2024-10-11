package baekjoon_failed.G2_15824_너봄에는캡사이신이맛있단다;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int mod = 1_000_000_007;
	
	static int N, sum;
	static int[] food;
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	
    	int[] food = new int[N + 1];
    	for (int i = 1; i <= N; i++)
    		food[i] = sc.nextInt();
    	
    	Arrays.sort(food);
    	
    	long sum = 0;
    	
    	for (int i = 1; i <= N; i++) {
    		int cntL = i - 1;
    		int cntR = N - i;
    		
    		long powL = pow(cntL);
    		long powR = pow(cntR);
    		
    		long maxScovile = food[i] * (powL - 1);
    		long minScovile = food[i] * (powR - 1);
    		
    		sum = (sum + maxScovile - minScovile + mod) % mod;
    	}
    	
    	System.out.println(sum);
	}
    
    // 제곱 계산 분할정복?
    static long pow(int k) {
    	long result = 1;
    	for (int i = 0; i < k; i++)
    		result = (result * 2) % mod;
    	return result;
    }
}