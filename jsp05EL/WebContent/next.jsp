<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>next.jsp</h1>
	<a href="index.jsp">이전페이지</a>
	<a href="attribute.jsp">attribute.jsp</a>
	<%= request.getParameter("name") %>
	<% System.out.println(request.getParameter("name")); %>
	<% out.print(request.getParameter("name")); %>
	${param.name}
	${param.tel}
	
	<h1>${key}</h1>
	<h1>session:${id}</h1>
	<h1>application:${autoLogin}</h1>
</body>
</html>