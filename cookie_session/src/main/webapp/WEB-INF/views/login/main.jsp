<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${login == null}">
			<script type="text/javascript">
				alert("로그인 먼저하세요");
				location.href="login"
			</script>
		</c:when>
		<c:otherwise>
			<h3>로그인 성공한 사용자만 접근</h3>
			<h5>${ login }님 환영합니다!!</h5>
			<a href="logout">로그아웃</a>
			<a href="login">로그인</a>		
		</c:otherwise>
	</c:choose>
</body>
</html>