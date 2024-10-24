package baekjoon_failed.G3_2091_동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());	// X원
		int A = Integer.parseInt(st.nextToken());	// 1센트
		int B = Integer.parseInt(st.nextToken());	// 5센트
		int C = Integer.parseInt(st.nextToken());	// 10센트
		int D = Integer.parseInt(st.nextToken());	// 25센트
		
		int maxA = A;
		int maxB = A + B * 5;
		int maxC = A + B * 5 + C * 10;
		int maxD = A + B * 5 + C * 10 + D * 25;
		
		int[][] dp = new int[maxD + 1][4];
		for (int a = 1; a <= A; a++)
			dp[a][0] = a;
		
		if (maxA != maxB) {
			int gap = Math.max(maxA, 5);
			for (int b = gap; b <= maxB; b += gap) {
				for (int a = 1; a <= gap; a++) {
					if (dp[a][0] != 0) {
						dp[b + a][0] = dp[a][0];
						dp[b + a][1] = b / gap;
					}
				}
			}
		} else {
			for (int b = 1; b <= B; b++)
				dp[b * 5][1] = b;
		}
		
		if (maxB != maxC) {
			int gap = Math.max(maxB, 10);
			for (int c = gap; c <= maxC; c += gap) {
				for (int b = 1; b <= gap; b++) {
					if (dp[b][0] != 0 || dp[b][1] != 0) {
						dp[c + b][0] = dp[b][0];
						dp[c + b][1] = dp[b][1];
						dp[c + b][2] = c / gap;
					}
				}
			}
		} else {
			for (int c = 1; c <= C; c++)
				dp[c * 10][2] = c;
		}
		
		if (maxC != maxD) {
			int gap = Math.max(maxC, 25);
			for (int d = gap; d <= maxD - gap; d += gap) {
				for (int c = 1; c <= gap; c++) {
					if (dp[c][0] != 0 || dp[c][1] != 0 || dp[c][2] != 0) {
						dp[d + c][0] = dp[c][0];
						dp[d + c][1] = dp[c][1];
						dp[d + c][2] = dp[c][2];
						dp[d + c][3] = d / gap;
					}
				}
			}
		} else {
			for (int d = 1; d <= D; d++)
				dp[d * 25][3] = d;
		}
		
		for (int x = 1; x <= maxD; x++)
			System.out.printf(" %2d", x);
		System.out.println();
		System.out.println();
		for (int x = 1; x <= maxD; x++)
			System.out.printf(" %2d", dp[x][0]);
		System.out.println();
		for (int x = 1; x <= maxD; x++)
			System.out.printf(" %2d", dp[x][1]);
		System.out.println();
		for (int x = 1; x <= maxD; x++)
			System.out.printf(" %2d", dp[x][2]);
		System.out.println();
		for (int x = 1; x <= maxD; x++)
			System.out.printf(" %2d", dp[x][3]);
		System.out.println();
		System.out.println();
		
		System.out.printf("%d %d %d %d", dp[X][0], dp[X][1], dp[X][2], dp[X][3]);
	}
}