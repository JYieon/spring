<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = () => {
		//alert(111)
		console.log("model cook : " + '${cook}');
		console.log("cookie : " + document.cookie);
		console.log("비교 : " + (document.cookie == "key=cookie값"));
		let url = "popup02";
		let setWindow = "width=300, height=200, top=500, left=500";
		if(!(document.cookie == "key=cookie값")){
		//if('${cook}' != "key"){
			window.open(url, "", setWindow);		
		}
	}
</script>
</head>
<body>
	cookie02
</body>
</html>