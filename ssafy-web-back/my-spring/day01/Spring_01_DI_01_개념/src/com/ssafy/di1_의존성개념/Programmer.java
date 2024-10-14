package com.ssafy.di1_의존성개념;

public class Programmer {
	private Desktop desktop;
	
	public Programmer() {
		this.desktop = new Desktop();
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() + "으로 개발을 합니다");
	}
}
