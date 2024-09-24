<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<H2>C: out</H2>
	<c:out value = "Hello JSTL1"></c:out> <br>
	<c:out value = "Hello JSTL2"/> <br>
	<!-- (태그 사이 내용 없을 때)닫는 태그 없어도 작동 -->
	
	<hr>
	<H2>C: set</H2>
	<c:set var="name1">yang1</c:set> ${name1} <br>
	<c:set var="name2" value="yang2"/> ${name2} <br>
	
	<c:set var="person" value="<%= new com.ssafy.dto.Person() %>"/>
	<c:set target="${person}" property="name" value="yang3"/>
	
	${person}
	
</body>
</html>