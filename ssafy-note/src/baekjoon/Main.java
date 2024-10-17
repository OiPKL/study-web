package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int K = sc.nextInt();
    	sc.nextLine();
    	
    	char[][] map = new char[N][M];
    	for (int n = 0; n < N; n++)
    		map[n] = sc.nextLine().toCharArray();

    	List<char[]> word = new ArrayList<>();
    	for (int k = 0; k < K; k++)
    		word.add(sc.nextLine().toCharArray());
    	
    	
    }
}