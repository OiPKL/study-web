<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
</head>
<body>
	<h1>영화 등록</h1>
	<form action="main" method="POST">
		<!-- POST = input 태그 필요 & action=regist 고정 & hidden -->
		<input name="action" value="regist" hidden>
		<label>제목</label>
		<input name="title">
		<br>
		<label>감독</label>
		<input name="director">
		<br>
		<label>장르</label>
		<input name="genre">
		<br>
		<label>상영시간</label>
		<input name="runningTime">
		<br>
		<button>제출</button>
	</form>
</body>
</html>