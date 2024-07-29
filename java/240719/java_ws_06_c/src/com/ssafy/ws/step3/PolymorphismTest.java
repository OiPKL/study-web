package com.ssafy.ws.step3;

/**
 * 다형성 연습하기
 * 
 * 주석을 참고하여 ____ 부분을 채우고 프로그램을 완성해 봅시다.
 * 
 * 다형성은 어느 한 객체가 다양한 형태를 갖을 수 있음을 의미합니다.
 * 
 */
public class PolymorphismTest {
	
	public static void main(String[] args) {
		
		// Q. 정수형, 실수형, 문자열 변수를 선언해 봅시다.
		int value1 = 10;
		double value2 = 10.0;
		String value3 = "ssafy";
		
		// Q. 데이터 타입은 Object, 변수 이름은 objectList, 크기는 3인 배열을 선언해 봅시다.
		Object[] objectList = new Object[3];
		
		// Q. 0번 인덱스에 정수형, 1번 인덱스에 실수형, 2번 인덱스에 문자열을 저장해봅시다.
		//    타입이 Object 임에도 정수, 실수, 문자열이 저장 가능함을 확인합니다.
		objectList[0] = value1;
		objectList[1] = value2;
		objectList[2] = value3;
		
		for (int i = 0; i < 3; i++) {
			System.out.println(objectList[i]);
		}
	}
}
