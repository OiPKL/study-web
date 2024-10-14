package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

// 공통 관심사항을 한번에 저장하는 클래스(단위)
public class MyAspect {
	
	public void before() {
		System.out.println("부팅완료");	// 이전수행기능
	}
	
	public void afterReturning(int num) {
		System.out.println(num + " 만큼 커밋완료");
	}
	
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴ㄱㄱ");
		
		if (th instanceof OuchException) {
			((OuchException)th).handleException();
		}
	}
	
	public void after() {
		System.out.println("퇴실체크");
	}
	
	//////////////////////////////////////////////////////
	
	public void around(ProceedingJoinPoint pjt) {
		int num = 0;
		
		this.before();
		try {
			num = (int)pjt.proceed();
			this.afterReturning(num);
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
	}
}
