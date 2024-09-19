package com.ssafy.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 구구단...
		resp.setContentType("text/html;characterset=UTF-8");
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		// 등록...
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		String action = req.getParameter("action");
		switch (action) {
		case "regist":
			// 등록하는 작업 (메서드로 빼서 사용 가능)
			// 인간의 대한 정보가 요청통로안에 몽땅 들어있다.

			break;
		case "gugu":
			// 구구단을 하는 작업(메서드로 빼서 사용 가능)
			break;

		}

	}

}
