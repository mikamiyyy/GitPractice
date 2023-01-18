<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="KadaiLoginServlet" method="post">
	IDとPWを入力してください。<br>
	ログインID：<input type="text" name="mail"><br>
	PW：<input type="password" name="pw"><br>
	<input type="submit" value="ログイン">
</form>
</body>
</html>