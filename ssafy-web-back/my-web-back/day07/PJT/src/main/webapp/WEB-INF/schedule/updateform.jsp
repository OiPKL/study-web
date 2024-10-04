<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정수정</title>
<style>
    body {
        background-color: #fffaf0;
        font-family: Arial, sans-serif;
        color: #333;
    }
    h2 {
        text-align: center;
        color: #ffa07a;
        padding: 20px;
    }
    form {
        width: 60%;
        margin: auto;
        background-color: #fafad2;
        padding: 20px;
        border-radius: 10px;
    }
    input[type="text"], textarea {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        background-color: #ff6347;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #ff4500;
    }
</style>
</head>
<body>
    <h2>일정수정</h2>
    <form action="schedule" method="POST">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${schedule.id}">
        <div>
            날짜 <input type="text" name="date" value="${schedule.date}">
        </div>
        <div>
            일정 <input type="text" name="content" value="${schedule.content}">
        </div>
        <div>
            세부일정 : <textarea rows="10" cols="30" name="semicontent">${schedule.semicontent}</textarea>
        </div>
        <div style="text-align: center;">
            <input type="submit" value="일정 수정"><br>
        </div>
    </form>
</body>
</html>
