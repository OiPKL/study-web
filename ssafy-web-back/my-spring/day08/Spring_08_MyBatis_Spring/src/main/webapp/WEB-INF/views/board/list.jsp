<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>게시글 목록</h2>
		<hr>
		<table class="table text-center">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${boards }" var="board">
			<tr>
				<td>${board.id }</td>
				<td><a href="detail?id=${board.id }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.viewCnt }</td>
				<td>${board.regDate }</td>
			</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-end">
			<a href="writeform" class="btn btn-outline-primary">등록</a> 
		</div>
	</div>
</body>
</html>