package com.ssafy.mvc.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.mvc.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	private final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 클라이언트는 서버에게 요청을 보내기 전 사전 요청을 먼저 보낸다
		// 서버가 현재 요청을 수락할 수 있느 상태인지 체크
		if (request.getMethod().equals("OPTIONS"))
			return true;
		
		String token = request.getHeader(HEADER_AUTH);
		if (token != null) {
			jwtUtil.validate(token);
			return true;
		}
		
		throw new Exception("유효하지 않은 접근입니다");
	}
}
