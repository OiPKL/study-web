package baekjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String candy = "";
        char[][] candyArr = new char[N][N];
        
        for (int r = 0; r < N; r++) {
        	candy = sc.nextLine();
        	candyArr[r] = candy.toCharArray();
        }

        
        
    }
}