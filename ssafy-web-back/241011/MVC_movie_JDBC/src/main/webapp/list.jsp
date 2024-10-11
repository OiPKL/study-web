<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
</head>
<body>
	<h1>영화 목록</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>감독</th>
			<th>장르</th>
			<th>상영시간</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.id }</td>
				<td><a href="main?action=detail&id=${movie.id }">${movie.title }</a></td>
				<td>${movie.director }</td>
				<td>${movie.genre }</td>
				<td>${movie.runningTime }</td>
				<!-- 삭제할 영화 ID까지 전달해야 함!! -->
				<td><a href="main?action=delete&id=${movie.id }">삭제</a></td>
				<td><a href="main?action=updateForm&id=${movie.id }">수정</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="main?action=registForm">영화 등록</a>
</body>
</html>