<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:choose>
		<c:when test="${ username != null }">
			${ username } 인증되었습니다!!
		</c:when>
		<c:otherwise>
			<form action="auth" method="post">
				<input type="test" name="email" value="dkcl.8642@gmail.com">
				<input type="submit" value="인증하기">
			</form>
		</c:otherwise>	
	</c:choose>
</body>
</html>