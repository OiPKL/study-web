package com.ssafy.ws.step3_1;

public class Person {

	String name;
	int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void showInformation() {
		System.out.println("Person 클래스의 showInformation() ");
		System.out.println("이름: " + Person.this.name);
		System.out.println("나이: " + Person.this.age);
	}
	
}
