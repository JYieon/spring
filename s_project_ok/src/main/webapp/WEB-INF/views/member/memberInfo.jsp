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
	<table border="1">
		<tr>
			<th>아이디</th> <th>비밀번호</th> <th>주소</th>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>
				<a href="${contextPath }/member/info?id=${dto.id }">
					${dto.id }
				</a>
			</td>
			<td>${dto.pwd }</td>
			<td>${dto.addr }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>




