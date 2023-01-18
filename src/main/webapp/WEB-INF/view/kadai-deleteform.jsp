<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>会員削除</p><br>
<form action="KadaiDeleteConfirmServlet" method="post">
	メールアドレス：<input type="email" name="email"><br>
	<input type="submit" value="削除">
</form>
</body>
</html>