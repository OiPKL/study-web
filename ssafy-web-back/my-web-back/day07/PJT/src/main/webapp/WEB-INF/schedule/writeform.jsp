<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정등록</title>
<style>
    body {
        background-color: #f5fffa;
        font-family: Arial, sans-serif;
        color: #333;
    }
    h2 {
        text-align: center;
        color: #32cd32;
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
        background-color: #32cd32;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #228b22;
    }
</style>
</head>
<body>
    <h2>일정등록</h2>
    <form action="schedule" method="POST">
        <input type="hidden" name="action" value="write">
        <div>
            날짜 <input type="text" name="date">
        </div>
        <div>
            일정 <input type="text" name="content" value="오늘도 화이팅">
        </div>
        <div>
            세부일정 : <textarea rows="10" cols="30" name="semicontent"></textarea>
        </div>
        <div style="text-align: center;">
            <input type="submit" value="일정 등록"><br>
        </div>
    </form>
</body>
</html>
