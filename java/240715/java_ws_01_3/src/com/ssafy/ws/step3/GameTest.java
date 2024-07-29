package com.ssafy.ws.step3;

import java.util.Scanner;

/**
 * 가위,바위,보 게임을 하는 클래스
 */
public class GameTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호를 입력하세요: ");
		int num = sc.nextInt();
		int comCount = 0;
		int myCount = 0;
		String winner = "";
		
		switch (num) {
		case 1:
			while (true) {
				
				int comChoice = (int)(Math.random()*3+1);
				
				System.out.print("가위바위보 중 하나 입력: ");
				String myChoice = sc.next();
								
				if (myChoice.equals("가위")) {				// 1
					if (comChoice == 2) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 3) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				} else if (myChoice.equals("바위")) {		// 2
					if (comChoice == 3) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 1) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				} else {							// 3
					if (comChoice == 1) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 2) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				}
				if (comCount == 3) {
					winner = "컴퓨터";
					break;
				}
				if (myCount == 3) {
					winner = "인간";
					break;
				}
			}
			break;
		case 2:
			while (true) {
				
				int comChoice = (int)(Math.random()*3+1);
				
				System.out.print("가위바위보 중 하나 입력: ");
				String myChoice = sc.next();
								
				if (myChoice.equals("가위")) {				// 1
					if (comChoice == 2) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 3) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				} else if (myChoice.equals("바위")) {		// 2
					if (comChoice == 3) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 1) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				} else {							// 3
					if (comChoice == 1) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 2) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				}
				if (comCount == 2) {
					winner = "컴퓨터";
					break;
				}
				if (myCount == 2) {
					winner = "인간";
					break;
				}
			}
			break;
		case 3:
			while (true) {
				
				int comChoice = (int)(Math.random()*3+1);
				
				System.out.print("가위바위보 중 하나 입력: ");
				String myChoice = sc.next();
				
				if (myChoice.equals("가위")) {				// 1
					if (comChoice == 2) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 3) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				} else if (myChoice.equals("바위")) {		// 2
					if (comChoice == 3) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 1) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				} else {							// 3
					if (comChoice == 1) {
						comCount++;
						System.out.println("졌습니다!!!");
					} else if (comChoice == 2) {
						myCount++;
						System.out.println("이겼습니다!!!");
					} else {
						System.out.println("비겼습니다!!!");
					}
				}
				if (comCount == 1) {
					winner = "컴퓨터";
					break;
				}
				if (myCount == 1) {
					winner = "인간";
					break;
				}
			}
			break;
		default:
			System.out.println("번호를 다시 입력하세요");
		}
		System.out.println(winner + " 승!!!");
	}
}
