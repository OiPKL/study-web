<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%!
	int A = 10;
	int B = 20;
	
	String name = "SSAFY";
	
	public int add(int A, int B){
		return A + B;
	}
	
	public int abs(int A){
		return A > 0 ? A : -A;
	}
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부</title>
</head>
<body>

	<%
		int C = -10;
	
/* 		// 이 부분에 메서드 정의는 불가능
		public int mul(int A, int B){
			
		} */
		
		out.print(add(A, B));
		out.print("<br>");
		
		out.print(abs(C));
		out.print("<br>");
	%>

	<a href="index.html">홈으로</a>
</body>
</html>