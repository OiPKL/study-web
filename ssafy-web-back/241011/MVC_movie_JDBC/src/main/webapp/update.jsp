<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 수정</title>
</head>
<body>
	<h1>영화 수정</h1>
	<form action="main" method="POST">
		<!-- POST = input 태그 필요 & action=regist 고정 & hidden -->
		<input name="action" value="update" hidden>
		<input name="id" value="${movie.id }" hidden>
		<label>제목</label>
		<input name="title" value="${movie.title }">
		<br>
		<label>감독</label>
		<input name="director" value="${movie.director }" readonly>
		<br>
		<label>장르</label>
		<input name="genre" value="${movie.genre }" readonly>
		<br>
		<label>상영시간</label>
		<input name="runningTime" value="${movie.runningTime }" readonly>
		<br>
		<button>제출</button>
	</form>
</body>
</html>