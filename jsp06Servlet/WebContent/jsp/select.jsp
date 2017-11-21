<%@ page import="java.util.*"%>
<%@ page import="test.com.model.*"%>
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
	<h1>Select Page</h1>
	<!-- 	jsp 액션태그 -->
	<jsp:include page="../menu.html"></jsp:include>
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
					List<TestVO> list = 
						(ArrayList<TestVO>)request.getAttribute("list");
					for(int i=0;i<list.size();i++){
				%>
				<tr>
					<td><%= list.get(i).getNum() %></td>
					<td><a href="update.do?num=<%= list.get(i).getNum() %>"><%= list.get(i).getId() %></a></td>
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