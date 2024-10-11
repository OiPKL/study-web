package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
// 공통 관심사항을 한번에 저장하는 클래스(단위)
public class MyAspect {
	
	@Pointcut("execution(* com.ssafy.aop.*.coding())")
	public void mypt() {	// 메서드 명이 곧 변수
		
	}

//	@Before(value="mypt()")
	public void before() {
		System.out.println("부팅완료");	// 이전수행기능
	}
	
//	@AfterReturning(value="mypt()", returning="num")
	public void afterReturning(int num) {
		System.out.println(num + " 만큼 커밋완료");
	}
	
//	@AfterThrowing(value="mypt()", throwing="th")
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴ㄱㄱ");
		
		if (th instanceof OuchException) {
			((OuchException)th).handleException();
		}
	}
	
//	@After(value="mypt()")
	public void after() {
		System.out.println("퇴실체크");
	}
	
	//////////////////////////////////////////////////////
	
	@Around(value="mypt()")
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
