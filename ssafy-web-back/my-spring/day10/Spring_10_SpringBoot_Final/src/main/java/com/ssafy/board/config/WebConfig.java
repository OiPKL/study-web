package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.board.interceptor.AdminInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	// 의존성 주입 (필드주입,생성자주입,설정자주입)

	@Autowired
	private AdminInterceptor adminInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminInterceptor).addPathPatterns("/users");
	}
}
