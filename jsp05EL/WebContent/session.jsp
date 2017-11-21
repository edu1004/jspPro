<%@page import="test.com.TestVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("id", "admin");
// 		session.removeAttribute("id");
		session.setMaxInactiveInterval(10);//
		
	%>
	<a href="next.jsp">이전페이지</a>
	<h1>session.jsp</h1>
	<h1>session:${id}</h1>
	<h1>application:${autoLogin}</h1>
</body>
</html>