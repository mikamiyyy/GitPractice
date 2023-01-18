<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Kadai" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>新規会員登録</h3>
	<form action="KadaiRegisterConfirmServlet" method="post">
		名前：<input type="text" name="name"><br>
		年齢：<input type="number" name="age"><br>
		性別：<input type="radio" name="gender" value="0">男
			  <input type="radio" name="gender" value="1">女<br>
		電話番号：<input type="tel" name="tel"><br>
		メール：<input type="email" name="email"><br>
		パスワード：<input type="password" name="pw"><br>
		<input type="submit" value="登録">
	</form>
</body>
</html>