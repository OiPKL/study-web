package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		// GXAC + Ctrl Space
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println(1);
		Programmer p = (Programmer) context.getBean("programmer");
		Desktop d = (Desktop) context.getBean("desktop");
		
		p.setComputer(d);
		System.out.println(2);
		
		p.coding();
		
		Desktop d2 = (Desktop) context.getBean("desktop");
		
		// 싱글턴 관리
		System.out.println(d == d2);
	}
}
