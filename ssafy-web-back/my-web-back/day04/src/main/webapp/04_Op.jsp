<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	\${5+2} : ${5+2} <br>
	\${5+2} : ${5/2} <br>			<!-- 실수연산 -->
<%-- 	\${5 div 2} : ${5 div 2} <br>	<!-- 빨간줄 무시 --> --%>
	\${5 gt 2} : ${5 gt 2} <br>
	\${5 < 2} : ${5 < 2} <br>
</body>
</html>