<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	id : ${ id }<br>
	Session id = ${sessionScope.id}<br>
	name : ${ name }<br>
	addr : ${ addr }<br> <!-- model에서 전달 -->
	<a href="make_session">세션 생성</a>
	<a href="del_session">세션 삭제</a>
</body>
</html>