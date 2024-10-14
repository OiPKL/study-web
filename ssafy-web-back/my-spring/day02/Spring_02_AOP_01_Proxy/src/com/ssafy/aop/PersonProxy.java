package com.ssafy.aop;

import java.util.Random;

public class PersonProxy implements Person {

	// 프록시 객체에 주입한 인간
	private Person person;
	// 설정자 주입
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		System.out.println("부팅완료");	// 이전수행기능
		
		try {
			person.coding();
			if(new Random().nextBoolean())
				throw new OuchException();
			
			System.out.println("커밋완료");	// 정상종료
		} catch (OuchException e) {
			e.handleException();
			System.out.println("조퇴ㄱㄱ");	// 비정상정료
		} finally {
			System.out.println("퇴실체크");	// 종료
		}
	}
}
