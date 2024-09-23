<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	// id pw 를 통해 실제 유저인지 확인 -> Manager를 통해 유저 목록을 관리 or (조건문)
	if (id.equals("ssafy") && pw.equals("1234")) {
		// 로그인 성공 -> 세션에 저장
		// JSP의 경우: 세션은 기본 객체
		session.setAttribute("userid", id);
		// Servlet의 경우: 쿠키목록을 전부 가져와 JSESSIONID 이름을 가진 쿠키가 있는지 확인하고
		// 해당 쿠키를 이용하여 세션ID를 가져온다 -> getSession()
		HttpSession mySession = request.getSession();
		
		// Main.jsp 페이지로 이동 -> 포워딩
//		// 1. 포워딩
//		request.getRequestDispatcher("08_Main.jsp").forward(request, response);
		// 2. (리다이렉트)
		response.sendRedirect("08_Main.jsp");
		
	} else
		// 로그인 실패
		response.sendRedirect("07_LoginForm.jsp");
	
%>