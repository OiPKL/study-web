package com.ssafy.proxy;

import java.util.Random;

public class SSAFY {
	
	public void coding() {
		System.out.println("부팅완료");	// 이전수행기능
		
		try {
			System.out.println("끙차끙차");	// 핵심관심사항
			
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
