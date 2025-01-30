<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${ info.imgFileName }" name="origin">
		<input type="text" readonly name="id" value=${ info.id }><br>
		<input type="text" name="name" value=${ info.name }><br>
		<input type="file" name="file"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>