package com.ssafy.ws.step4;

import java.util.Scanner;

public class GabjaTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("60 갑자를 입력하세요: ");
		String $60 = sc.nextLine();
		
		char $10 = '갑';
		char $12 = '자';

		if ($60.length() == 2) {
			$10 = $60.charAt(0);
			$12 = $60.charAt(1);
		} else {
			System.out.println("다시 입력하세요");
			return;
		}
		
		for (int i = 1800; i <= 2100; i++) {
			char out1 = '갑';
			char out2 = '자';

			switch ((i-1444)%10) {
				case 0:
					out1 = '갑';
					break;
				case 1:
					out1 = '을';
					break;
				case 2:
					out1 = '병';
					break;
				case 3:
					out1 = '정';
					break;
				case 4:
					out1 = '무';
					break;
				case 5:
					out1 = '기';
					break;
				case 6:
					out1 = '경';
					break;
				case 7:
					out1 = '신';
					break;
				case 8:
					out1 = '임';
					break;
				case 9:
					out1 = '계';
					break;
				default:
					out1 = 'X';
					break;
			}
			
			switch ((i-1444)%12) {
				case 0:
					out2 = '자';
					break;
				case 1:
					out2 = '축';
					break;
				case 2:
					out2 = '인';
					break;
				case 3:
					out2 = '묘';
					break;
				case 4:
					out2 = '진';
					break;
				case 5:
					out2 = '사';
					break;
				case 6:
					out2 = '오';
					break;
				case 7:
					out2 = '미';
					break;
				case 8:
					out2 = '신';
					break;
				case 9:
					out2 = '유';
					break;
				case 10:
					out2 = '술';
					break;
				case 11:
					out2 = '해';
					break;
				default:
					out2 = 'X';
					break;
			}
			
			if (out1 == $10 & out2 == $12)
				System.out.print(i + " ");
			
		}

	}
}
