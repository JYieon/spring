<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>get 방식 전송</h3>
	<form action="result" method="get">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="get 전송"><br>
	</form>
	
	<h3>post 방식 전송</h3>
	<form action="result" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="post 전송"><br>
	</form>
</body>
</html>