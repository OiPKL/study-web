package com.ssafy.ws.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			System.out.println("로그인 안했음");
			response.sendRedirect("/");
			return false;
		} else {
			System.out.println("로그인 했음");
			return true;
		}
		
		
	}
	

}
