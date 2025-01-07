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
	<c:forEach var="dto" items="${ list }">
		id : ${ dto.id }<br>
		name : ${ dto.name }<hr>
	</c:forEach>
	<a href="index">index이동</a>
</body>
</html>