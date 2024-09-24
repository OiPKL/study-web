<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
	<%
		String[] numList = {"aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee", "fffff", "ggggg"};
		pageContext.setAttribute("numList1", numList);
	%>
	
	<h3>C:forEach</h3>
	<ul>
		<c:forEach items="${numList1}" var="num">
			<li>${num}</li>
		</c:forEach>
	</ul>
	
	<hr>
	
	<c:forEach items="${numList1}" var="num" varStatus="status" begin="1" end="5" step="2">
		<div>${status.index} : ${num}</div>
	</c:forEach>
	
	<hr>
	
	<c:forEach items="${numList1}" var="num" varStatus="status" begin="1" end="5" step="2">
		<div>${status.count} : ${num}</div>
	</c:forEach>
</body>
</html>