package com.ssafy.di4_의존성주입;

public class Programmer {
	private Computer computer;
	
	public Programmer() {
		
	}
	
	// 생성자 주입
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	// 설정자 주입
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다");
	}
}
