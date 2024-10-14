package com.ssafy.aop;

import java.util.Random;

public class SSAFY implements Person {
	
	public int coding() {
		System.out.println("끙차끙차");	// 핵심관심사항
		
		// 학습용 예외코드
		if (new Random().nextBoolean()) {
			throw new OuchException();
		}
		
		return (int) (Math.random()*10) + 1;
	}
}
