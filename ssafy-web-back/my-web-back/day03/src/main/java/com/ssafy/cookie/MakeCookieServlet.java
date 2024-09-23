package com.ssafy.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		System.out.println(key);
		
		// 쿠키 생성
		Cookie cookie = new Cookie(key, value);
		
		// 유효시간 결정: 초(s) (1분=60 1시간=60*60 1일=60*60*24)
		cookie.setMaxAge(60);
		
//		// 쿠키 삭제
//		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		resp.sendRedirect(req.getContextPath() + "/02_CookieResult.jsp");
	}
	
	// 쿠키 삭제
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		for (Cookie c : req.getCookies()) {
			if (c.getName().equals(name))
				c.setMaxAge(0);
		}
	}
}
