package com.ssafy.di4_의존성주입;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
		
		// 생성자 주입
		Programmer p1 = new Programmer(desktop);
		Programmer p2 = new Programmer(laptop);
		
		p1.coding();
		p2.coding();
		
		// 설정자 주입
		Programmer p3 = new Programmer();
		p3.setComputer(laptop);
		
		p3.coding();
		
		// 메서드 주입
		Scanner sc = new Scanner(System.in);
		
		Programmer p4 = new Programmer();
		
		while (true) {
			p4.setComputer(ComputerFactory.getComputer(sc.next()));
			p4.coding();
		}
		
	}
}
