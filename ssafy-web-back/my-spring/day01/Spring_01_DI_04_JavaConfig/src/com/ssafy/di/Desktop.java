package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
	
	public Desktop() {
		System.out.println("생성완료");
	}
	
	public String getInfo() {
		return "데스크톱";
	}
	
}
