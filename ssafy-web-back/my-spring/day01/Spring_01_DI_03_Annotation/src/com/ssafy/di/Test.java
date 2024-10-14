package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		// GXAC + Ctrl Space
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		Desktop d = (Desktop) context.getBean("desktop");
		
		System.out.println(d.getInfo());
		
		Programmer p = context.getBean("p", Programmer.class);
		
		p.coding();
	}
}
