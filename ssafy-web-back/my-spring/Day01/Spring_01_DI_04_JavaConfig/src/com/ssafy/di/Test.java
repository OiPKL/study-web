package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		// ACAC + Ctrl Space
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Programmer p = context.getBean("p", Programmer.class);
		
		p.coding();
	}
}
