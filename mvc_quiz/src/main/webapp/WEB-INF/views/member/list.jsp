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
	<table border="1">
		<tr>
			<th>id</th><th>password</th><th>name</th>
		</tr>
			<c:if test="${ member.size() == 0 }">
				<tr>
					<td colspan="3"><b>데이터 없음</b></td>
				</tr>
			</c:if>
			<c:if test="${ member.size() != 0 }">
				<c:forEach var="m" items="${ member }">
					<tr>
						<td>${ m.id }</td>
						<td>${ m.pwd }</td>
						<td>${ m.name }</td>
					</tr>
				</c:forEach>
			</c:if>
		<tr>
			<td colspan="3">
				<a href="main">index 이동</a>
			</td>
		</tr>
	</table>
</body>
</html>