<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<%= request.getParameter("id") %> <br>
	${param.id} <br>
	<!-- null은 출력되지 않음 -->
	<!-- url에 쿼리 스트링 입력 = (임시)출력 -->
						
	== : <%= request.getParameter("id") == "ssafy" %> <br>
	<!-- false -->
	equals() <%= request.getParameter("id").equals("ssafy") %> <br>
	<!-- true -->
	
	== (EL) : ${param.id == "ssafy"} <br>
	<!-- true -->
	eq (EL) : ${param.id eq "ssafy"} <br>
	<!-- true -->
</body>
</html>