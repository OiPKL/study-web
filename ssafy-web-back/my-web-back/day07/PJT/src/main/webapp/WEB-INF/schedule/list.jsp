<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 일정</title>
<style>
    body {
        background-color: #fdf5e6;
        color: #333;
        font-family: 'Arial', sans-serif;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        text-align: center;
    }
    th, td {
        padding: 10px;
        border: 1px solid #ddd;
    }
    th {
        background-color: #ffdead;
        color: #8b4513;
    }
    td a {
        color: #4682b4;
        text-decoration: none;
    }
    td a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <h2 style="text-align: center; color: #8b4513;">전체 일정</h2>
    <table>
        <tr>
            <th>날짜</th>
            <th>일정</th>
        </tr>
        <c:forEach items = "${list}" var="schedule">
            <tr>
                <td><a href="schedule?action=detail&id=${schedule.id}">${schedule.date}</a></td>
                <td>${schedule.content}</td>
            </tr>   
        </c:forEach>
        <form action="schedule" method = POST>
        	<input type="hidden" name="action" value = "find">
        	<div>
        		<input type="text" name = "str">
        		<input type = "submit" value="찾기">
        	</div>
        </form>
    </table>
</body>
</html>
