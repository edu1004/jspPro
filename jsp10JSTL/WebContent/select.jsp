<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	background-color: black;
}
tr{
	background-color: white;
}
</style>
</head>
<body>
	<h1>select.jsp</h1>
	
	<table>
		<thead>
			<tr>
				<th>NUM</th>
				<th>NAME</th>
				<th>TEL</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><a href="update.do?num=${vo.num}">${vo.num}</a></td>
					<td>${vo.name}</td>
					<td>${vo.tel}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">aaa@aaa.com</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>