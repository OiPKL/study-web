<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
</head>
<body>
	<h2>게시글 상세</h2>
	
	<div>ID : ${movie.id }</div>
	<div>제목 : ${movie.title }</div>
	<div>감독 : ${movie.director }</div>
	<div>장르 : ${movie.genre }</div>
	<div>상영시간 : ${movie.runningTime }</div>
	
<!-- 	<div>
		<form action="main" method="POST">
			<input type="hidden" name="action" value="delete">
			<input type="hidden" name="id" value="{movie.id}">
			<button>삭제</button>
		</form>
	</div> -->
	<div>
		<a href="main?action=delete&id=${movie.id }">삭제</a>
		<a href="main?action=updateForm&id=${movie.id }">수정</a>
	</div>
	<div>
		<a href="main?action=list">목록</a>
	</div>
</body>
</html>