<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세부일정</title>
<style>
    body {
        background-color: #f0f8ff;
        font-family: Arial, sans-serif;
        color: #333;
    }
    div {
        margin: 10px 0;
        padding: 10px;
        font-size: 16px;
    }
    a {
        margin-right: 10px;
        padding: 10px 20px;
        background-color: #ff6347;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }
    a:hover {
        background-color: #ff4500;
    }
</style>
</head>
<body>
    <h2 style="text-align: center; color: #4682b4;">세부일정</h2>
    <div>날짜: ${schedule.date}</div>
    <div>일정: ${schedule.content}</div>
    <div>세부일정: ${schedule.semicontent}</div>
    <div>오늘의 운세: ${schedule.today_luck }</div>
    
    <div style="text-align: center;">
        <a href="schedule?action=delete&id=${schedule.id}">삭제</a>
        <a href="schedule?action=updateform&id=${schedule.id}">수정</a>
    </div>
</body>
</html>
