<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//scriptlet  TAG  jsp 필수아이템
	System.out.println("home.jsp");
	out.print("home.jsp");
	out.print("<h1>home.jsp</h1>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>home.jsp</h1>
	<label>이름  : </label><span>yangssem</span>
	<% out.print("<h1>home.jsp</h1>"); %>
</body>
</html>