<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<h1 align="center">CARE LAB</h1>
	<a href="${contextPath }">HOME</a>
	<a href="${contextPath }/member/list">회원 정보</a>
	
	<c:if test="${username != null }">
				<a href="${contextPath }/member/logout">로그아웃</a>
	</c:if>
	<c:if test="${username == null }">
		<a href="${contextPath }/member/login">로그인</a>
	</c:if>
	
	<HR>
</body>
</html>











