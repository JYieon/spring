<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- 변수 설정은 보통 가장 위에 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${ contextPath }/css/test.css">
</head>
<body>
	<c:set var="aaa" value="값 지정"/>
	${aaa}<br>
	
	path : ${pageContext.request.contextPath}<br>
	contextPath : ${ contextPath }
	<hr>
	<img alt="" src="<c:url value='/resources/images/김치.png' />" width="250px" height="100px">
	<img alt="" src="${contextPath}/img/김치.png" width="250px" height="100px">
	<a href="${contextPath}/register">회원가입</a>
	<a href="${contextPath}/list">모든 회원보기</a>
	<a href="${contextPath}/abc">abc</a>
</body>
</html>