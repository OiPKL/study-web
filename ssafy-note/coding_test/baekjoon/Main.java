package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N, D;
	static int[] rail;
	static PriorityQueue<int[]> persons;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		rail = new int[200_000_000];
		
		for (int i = 0; i < N; i++)
			persons = new PriorityQueue<>(
					(a, b) -> {
						if (a[0] != b[0])
							return a[0] - b[0];
						else
							return a[1] - b[1];
					});
		
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt() + 100_000_000;
			int B = sc.nextInt() + 100_000_000;
			
			if (A <= B)
				persons.add(new int[] {A, B});
			else
				persons.add(new int[] {B, A});
		}
		
		D = sc.nextInt();
		
//		for (int i = 0; i < N; i++) {
//			int[] person = persons.poll();
//			System.out.println(person[0] + " " + person[1]);
//		}
		
		
	}
}