<%@page import="test.com.TestDAOimpl"%>
<%@page import="test.com.TestDAO"%>
<%@page import="test.com.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
</head>
<body>
	<h1>Update Page</h1>
	<button onclick="location.href='../index.jsp'">INDEX</button>
	<button onclick="location.href='./select.jsp'">회원목록</button>
	<%
		TestVO vo = new TestVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		
		TestDAO dao = new TestDAOimpl();
		TestVO tvo = dao.selectOne(vo);
	%>
	<form action="updateOK.jsp" method="get">
		<label>NUM:</label><span><%= request.getParameter("num") %></span>
						<input type="hidden" name="num" value="<%= request.getParameter("num") %>"/><br>
		<label>ID:</label><input type="text" name="id" value="<%= tvo.getId()%>"/><br>
		<label>PW:</label><input type="text" name="pw" value="<%= tvo.getPw()%>"/><br>
		<label>NAME:</label><input type="text" name="name" value="<%= tvo.getName()%>"/><br>
		<label>TEL:</label><input type="text" name="tel" value="<%= tvo.getTel()%>"/><br>
		<input type="submit" value="전송"/><br>
	</form>
</body>
</html>