package com.ssafy.ws.step3;

/**
 * 클래스 생성 연습하기
 * 
 * 클래스는 멤버 변수(필드), 생성자, 멤버 메소드로 이루어져있습니다.
 * 
 */
public class Person {

	String name;
	int age;
	double height;
	String hobby;
	
	Person() {
		
	}
	
	Person(String name, int age, double height, String hobby) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.hobby = hobby;
	}
	
	void showInformation() {
		System.out.println("저의 이름은 " + name + "입니다.");
		System.out.println("저의 나이는" + age + "살입니다.");
		System.out.println("저의 키는" + height + "cm입니다.");
		System.out.println("저의 취미는" + hobby + "입니다.");
	}
	
}
