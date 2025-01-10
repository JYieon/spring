<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	<form action="${contextPath }/member/login" method="post">
		<input type="text" name="id"><br>
		<input type="text" name="pwd"><br>
		<input type="submit" value="로그인">
		<a href="${contextPath }/member/reg_form">회원가입</a>
		<br>
		자동로그인<input type="checkbox" name="autoLogin">
		<br>
	</form>
</body>
</html>






