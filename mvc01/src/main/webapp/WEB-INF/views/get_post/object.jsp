<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 두가지 방식으로 사용 가능. 단, getter가 있어야 함 -->
	name : ${ member.name }<br>
	age : ${ member.getAge() }<br>
	<a href="index">index 이동</a>
</body>
</html>