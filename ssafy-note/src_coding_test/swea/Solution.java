package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N, minTime;
	static int[][] map;
	static List<int[]> personList, stairList, ETA;				// [2] [3] [2]
	static List<Integer> ETA1, ETA2;
	static Deque<Integer> stair1, stair2, wait1, wait2;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			minTime = Integer.MAX_VALUE;
			N = sc.nextInt();
			map = new int[N][N];
			personList = new ArrayList<>();
			stairList = new ArrayList<>();
			ETA = new ArrayList<>();
			ETA1 = new ArrayList<>();
			ETA2 = new ArrayList<>();
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					int data = sc.nextInt();
					if (data == 1)
						personList.add(new int[] {n, m});
					if (data >= 2)
						stairList.add(new int[] {n, m, data});	// stair[2] = 계단길이
				}
			}
			
			for (int p = 0; p < personList.size(); p++) {
				int[] person = personList.get(p);				// ETA : {계단거리1, 계단거리2}
				ETA.add(getNearbyStair(person, stairList.get(0), stairList.get(1)));
			}
			
//			// *****************************************************************************
//			for (int[] etas : ETA) {
//				for (int eta : etas)
//					System.out.print(eta + " ");
//				System.out.println();
//				System.out.println("----------------------");
//			}
//			// *****************************************************************************
			
			int stairLength1 = stairList.get(0)[2];
			int stairLength2 = stairList.get(1)[2];
			stair1 = new LinkedList<>();
			for (int i = 0; i < stairLength1; i++)
				stair1.addLast(0);								// 계단1 길이만큼 대기열 추가
			stair2 = new LinkedList<>();
			for (int i = 0; i < stairLength2; i++)
				stair2.addLast(0);								// 계단2 길이만큼 대기열 추가
			wait1 = new LinkedList<>();
			wait2 = new LinkedList<>();
			
			pickETA(new int[ETA.size()], 0);
			
			System.out.println("#" + tc + " " + minTime);
			
		}
		
	}
	
	static int[] getNearbyStair(int[] person, int[] stair1, int[] stair2) {
		int distance1 = Math.abs(person[0] - stair1[0]) + Math.abs(person[1] - stair1[1]);
		int distance2 = Math.abs(person[0] - stair2[0]) + Math.abs(person[1] - stair2[1]);
		
		return new int[] {distance1, distance2};
	}
	
	static void pickETA(int[] pick, int idx) {
		
		if (idx == ETA.size()) {
			
			ETA1.clear();
			ETA2.clear();
			
			int etaIdx = 0;
			for (int eta : pick) {
				if (eta == 1)
					ETA1.add(ETA.get(etaIdx++)[0]);				// 계단1 사람들의 거리 저장
				else
					ETA2.add(ETA.get(etaIdx++)[1]);				// 계단2 사람들의 거리 저장
			}
			
//			// *****************************************************************************
//			System.out.print("ETA1: ");
//			for (int eta : ETA1)
//				System.out.print(eta + " ");
//			System.out.println();
//			System.out.print("ETA2: ");
//			for (int eta : ETA2)
//				System.out.print(eta + " ");
//			System.out.println();
//			// *****************************************************************************
			
			getHappyTime();
			
			return;
		}
	
			pickETA(pick, idx+1);
//        pick[idx] = 1;
//        pickETA(pick, idx + 1);
//
//        pick[idx] = 2;
//        pickETA(pick, idx + 1);
		
	}
	
	static void getHappyTime() {
		
		int time = 0;
		int stairFirst1 = 0;
		int stairFirst2 = 0;
		int stairCnt1 = 0;
		int stairCnt2 = 0;
		int happyCnt = 0;
		
//		// *****************************************************************************
//		System.out.print("ETA1: ");
//		for (int num : ETA1)
//			System.out.print(num + " ");
//		System.out.println();
//		System.out.print("ETA2: ");
//		for (int num : ETA2)
//			System.out.print(num + " ");
//		System.out.println();
//		// *****************************************************************************
		
//		while (happyCnt <= ETA.size()) {
		for (int t = 0; t < 10; t++) {
			
			time++;
			
			System.out.println("======================================");
			System.out.println("시작");
			System.out.println("time: " + time);
			System.out.println("happyCnt: " + happyCnt);
			System.out.print("stair1: ");
			for (int num : stair1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("stair2: ");
			for (int num : stair2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait1: ");
			for (int num : wait1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait2: ");
			for (int num : wait2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA1: ");
			for (int num : ETA1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA2: ");
			for (int num : ETA2)
				System.out.print(num + " ");
			System.out.println();
			
			stairFirst1 = 0;
			if (!wait1.isEmpty()) {
				while (!wait1.isEmpty()) {
					if (stairCnt1 == 3) break;
					wait1.pollFirst();
					stairFirst1++;
					stairCnt1++;
				}
			}
			stair1.addLast(stairFirst1);
			
			stairFirst2 = 0;
			if (!wait2.isEmpty()) {
				while (!wait2.isEmpty()) {
					if (stairCnt2 == 3) break;
					wait2.pollFirst();
					stairFirst2++;
					stairCnt2++;
				}
			}
			stair2.addLast(stairFirst2);
			
			System.out.println("stair addLast");
			System.out.println("happyCnt: " + happyCnt);
			System.out.print("stair1: ");
			for (int num : stair1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("stair2: ");
			for (int num : stair2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait1: ");
			for (int num : wait1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait2: ");
			for (int num : wait2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA1: ");
			for (int num : ETA1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA2: ");
			for (int num : ETA2)
				System.out.print(num + " ");
			System.out.println();
			
			stairFirst1 = stair1.pollFirst();
			happyCnt += stairFirst1;
			stairCnt1 -= stairFirst1;
			
			stairFirst2 = stair2.pollFirst();
			happyCnt += stairFirst2;
			stairCnt2 -= stairFirst2;
			
			System.out.println("stair pollFirst");
			System.out.println("happyCnt: " + happyCnt);
			System.out.print("stair1: ");
			for (int num : stair1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("stair2: ");
			for (int num : stair2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait1: ");
			for (int num : wait1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait2: ");
			for (int num : wait2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA1: ");
			for (int num : ETA1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA2: ");
			for (int num : ETA2)
				System.out.print(num + " ");
			System.out.println();
			
			for (int i = 0; i < ETA1.size(); i++) {
				ETA1.set(i, ETA1.get(i) - 1);
				if (ETA1.get(i) == 0) wait1.addLast(0);
			}
			
			for (int i = 0; i < ETA2.size(); i++) {
				ETA2.set(i, ETA2.get(i) - 1);
				if (ETA2.get(i) == 0) wait2.addLast(0);
			}
			
			System.out.println("ETA - 1");
			System.out.println("happyCnt: " + happyCnt);
			System.out.print("stair1: ");
			for (int num : stair1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("stair2: ");
			for (int num : stair2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait1: ");
			for (int num : wait1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("wait2: ");
			for (int num : wait2)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA1: ");
			for (int num : ETA1)
				System.out.print(num + " ");
			System.out.println();
			System.out.print("ETA2: ");
			for (int num : ETA2)
				System.out.print(num + " ");
			System.out.println();
			
		}

		minTime = Math.min(minTime, time);
		
	}
}