<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<hr>
	<form action="/ssato" method="post" id="form">
	<div id="line">
		<div id="type">
			<div>
				<label for="auto">자 동</label>
				<input type="radio" name="type" value="auto" id="auto" checked>
			</div>
			<div>
				<label for="hand">수 동</label>
				<input type="radio" name="type" value="hand" id="hand">
			</div>
		</div>
		<input type="number" name="num" class="num">
		<input type="number" name="num" class="num">
		<input type="number" name="num" class="num">
		<input type="number" name="num" class="num">
		<input type="number" name="num" class="num">
		<input type="number" name="num" class="num">
	</div>
	<hr>
	
	<div id="${msg.status}">${msg.body}</div>
	<div id="submit">
	<input type="submit" value="응모하기" id="submitButton">
	</div>
	</form>

<%@ include file="footer.jsp" %>
