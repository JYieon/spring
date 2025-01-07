<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk(){
		location.href = "cookieCreate";
		window.close();		
	}
</script>
</head>
<body>
	<h3>- 팝 업 창 -</h3>
	<hr>
	<input type="checkbox" id="check" onclick="chk()">
	<label for="check">하루동안 열지 않음</label>
</body>
</html>