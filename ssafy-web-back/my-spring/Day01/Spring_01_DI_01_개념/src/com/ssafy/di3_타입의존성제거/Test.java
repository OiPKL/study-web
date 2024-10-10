package com.ssafy.di3_타입의존성제거;

public class Test {
	public static void main(String[] args) {
		
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
		
		Programmer p1 = new Programmer(desktop);
		Programmer p2 = new Programmer(laptop);
		
		p1.coding();
		p2.coding();
	}
}
