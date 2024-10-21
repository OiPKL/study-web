<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ� ���</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>�Խñ� ���</h2>
		<hr>
		<table class="table text-center">
			<tr>
				<th>��ȣ</th>
				<th>����</th>
				<th>�۾���</th>
				<th>��ȸ��</th>
				<th>��¥</th>
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
			<a href="writeform" class="btn btn-outline-primary">���</a> 
		</div>
	</div>
</body>
</html>