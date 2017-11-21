<%@page import="test.com.TestDAO"%>
<%@page import="test.com.TestDAOimpl"%>
<%@page import="test.com.TestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select page</title>
<style type="text/css">
body {
	background-color: #ffff55;
}

/* #title01 { */
/* 	color: blue; */
/* } */

/* #title02 { */
/* 	color: #0000ff; */
/* } */
hgroup .title {
	color: #00ff00;
}

.title.select3 {
	color: #00ffff;
}
</style>
</head>
<body>
	<header>
		<hgroup>
			<h1 id="title01" class="title">select Page1</h1>
		</hgroup>
		<h3 id="title02" class="title select1">select Page2</h3>
		<h3 id="title02" class="title select2">select Page2</h3>
		<h3 id="title02" class="title select3">select Page2</h3>
		<nav>
			<button onclick="location.href='../index.jsp'">INDEX</button>
			<button onclick="location.href='./insert.jsp'">회원가입</button>
		</nav>
	</header>
	<section>
		<table border="1">
			<thead>
				<tr>
					<th>NUM</th>
					<th>ID</th>
					<th>PW</th>
					<th>NAME</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<% 
				TestDAO dao = new TestDAOimpl();
				List<TestVO> list = dao.selectAll();
				for(int i=0;i<list.size();i++){
			%>
				<tr>
					<td><%= list.get(i).getNum() %></td>
					<td><a href="update.jsp?num=<%= list.get(i).getNum() %>"><%= list.get(i).getId() %></a></td>
					<td><%= list.get(i).getPw() %></td>
					<td><%= list.get(i).getName() %></td>
					<td><a href="deleteOK.jsp?num=<%= list.get(i).getNum() %>">삭제</a></td>
				</tr>
			<% }%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">tfoot</td>
				</tr>
			</tfoot>
		</table>
	</section>



</body>
</html>