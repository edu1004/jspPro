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
		pageContext.setAttribute("title", "EL test");
		
	%>
	<a href="next.jsp">이전페이지</a>
	<h1>page.jsp</h1>
	<h1>pageContext:${title}</h1>
</body>
</html>