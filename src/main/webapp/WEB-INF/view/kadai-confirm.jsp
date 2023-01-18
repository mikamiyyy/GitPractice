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
	<p>下記の内容で登録します。</p>
	<%
		Kadai kd = (Kadai)session.getAttribute("input_data");
	%>
	名前：<%=kd.getName() %><br>
	年齢：<%=kd.getAge() %><br>
	性別：<%=kd.getGender() %><br>
	電話番号：<%=kd.getTel() %><br>
	mail：<%=kd.getMail() %><br>
	パスワード：*********<br>
	<a href="KadaiRegisterExecuteServlet">OK</a><br>
	<a href="KadaiRegisterFormServlet">戻る</a>
</body>
</html>