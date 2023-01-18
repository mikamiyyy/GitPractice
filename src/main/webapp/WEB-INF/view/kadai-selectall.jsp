<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Kadai" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>氏名</th>
	<th>年齢</th>
	<th>性別</th>
	<th>電話番号</th>
	<th>メールアドレス</th>
</tr>
<%
List<Kadai> list = (ArrayList<Kadai>)request.getAttribute("list");
for(Kadai k : list){
%>
<tr>
	<td><%=k.getName() %></td>
	<td><%=k.getAge() %></td>
	<td><%=k.getGender() %></td>
	<td><%=k.getTel() %></td>
	<td><%=k.getMail() %></td>
</tr>
<%} %>
</table>
<a href="./">戻る</a>
</body>
</html>