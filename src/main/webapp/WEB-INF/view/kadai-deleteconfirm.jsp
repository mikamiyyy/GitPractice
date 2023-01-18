<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>下記のアカウントを削除します</p><br>
<%
	String mail = (String)session.getAttribute("input_data");
%>
メールアドレス：<%=mail %><br>
<a href="KadaiDeleteExecuteServlet">OK</a><br>
<a href="KadaiDelteFormServlet">戻る</a>
</body>
</html>