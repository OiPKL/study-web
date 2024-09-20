<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다른 JSP include</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="template/header.jsp" %>
	<h2>메인 내용</h2>
	<!-- 푸터 -->
	<%@ include file="template/footer.jsp" %>

</body>
</html>