package com.ssafy.ws.step3_1;

public class Teacher extends Student {

	int studentCount;
	
	public Teacher() {
	}
	
	public Teacher(String name, int age, String track, String region, int classNumber, int studentCount) {
		super(name, age, track, region, classNumber);
		this.studentCount = studentCount;
	}

	@Override
	void showInformation() {
		System.out.println("Teacher 클래스의 showInformation() ");
		System.out.println("이름: " + Teacher.this.name);
		System.out.println("나이: " + Teacher.this.age);
		System.out.println("트랙: " + Teacher.this.track);
		System.out.println("지역: " + Teacher.this.region);
		System.out.println("반: " + Teacher.this.classNumber);
		System.out.println("학생 수: " + Teacher.this.studentCount);
	}
	
}
