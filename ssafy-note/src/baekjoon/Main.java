package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static int mod = 1_000_000_007, D;
	static int[][] ssu = /*0*/ {{1, 2},
						 /*1*/ {0, 2, 3},
						 /*2*/ {0, 1, 3, 4},
						 /*3*/ {1, 2, 4, 5},
						 /*4*/ {2, 3, 5, 6},
						 /*5*/ {3, 4, 7},
						 /*6*/ {4, 7},
						 /*7*/ {5, 6}};
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		D = sc.nextInt();
		
	}
}