<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<hr>
<div id="result">
	<div id="line">
		당첨 : 
		<c:forEach var="num" items="${serverSatto.nums}">
			<c:if test="${userSatto.nums.contains(num)}">
				<div class="num blink">${num}</div>
			</c:if>
			<c:if test="${!userSatto.nums.contains(num)}">
				<div class="num">${num}</div>
			</c:if>
		</c:forEach>
	</div>
	<div id="line">
		당신 : 
		<c:forEach var="num" items="${userSatto.nums}">
			<c:if test="${serverSatto.nums.contains(num)}">
				<div class="num blink">${num}</div>
			</c:if>
			<c:if test="${!serverSatto.nums.contains(num)}">
				<div class="num">${num}</div>
			</c:if>
		</c:forEach>
	</div>
	<hr>
	<div>맞은 개수 : ${match}개</div>
</div>
	
<hr>
	<div id="submit">
		<a href="/ssato">다시하기</a>
	</div>


<%@ include file="footer.jsp" %>
