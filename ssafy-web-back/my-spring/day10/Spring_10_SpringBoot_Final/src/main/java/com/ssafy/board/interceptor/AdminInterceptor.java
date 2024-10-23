package com.ssafy.board.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인 했니?
		HttpSession session = request.getSession();

//		if (session.getAttribute("loginUser").equals("admin")) {
		if(!"admin".equals(session.getAttribute("loginUser"))) {
			response.sendRedirect("list");
			return false;
		}

		return true;
	}
	
}
