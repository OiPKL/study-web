<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대준영의 스터디플래너</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        color: #333;
    }
    h2 {
        color: #4682b4;
        text-align: center;
        padding: 20px;
    }
    a {
        display: inline-block;
        margin: 10px;
        padding: 10px 20px;
        background-color: #87ceeb;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }
    a:hover {
        background-color: #1e90ff;
    }
</style>
</head>
<body>
    <h2>너두 비형 딸수있어!</h2>
    <div style="text-align: center;">
        <a href="schedule?action=writeform">일정등록</a>
        <a href="schedule?action=list">일정목록</a>
    </div>
</body>
</html>
