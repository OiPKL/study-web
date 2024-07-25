package com.ssafy.ws.step3_1;

public class Student extends Person {

	String track;
	String region;
	int classNumber;
	
	public Student() {
	}

	public Student(String name, int age, String track, String region, int classNumber) {
		super(name, age);
		this.track = track;
		this.region = region;
		this.classNumber = classNumber;
	}
	
	@Override
	void showInformation() {
		System.out.println("Student 클래스의 showInformation() ");
		System.out.println("이름: " + Student.this.name);
		System.out.println("나이: " + Student.this.age);
		System.out.println("트랙: " + Student.this.track);
		System.out.println("지역: " + Student.this.region);
		System.out.println("반: " + Student.this.classNumber);
	}
	
}
