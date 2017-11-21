<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert page</title>
</head>
<body>
	<h1>Insert Page</h1>
	<button onclick="location.href='../index.jsp'">INDEX</button>
	<button onclick="location.href='./select.jsp'">회원목록</button>
	
	<form action="insertOK.jsp" method="post">
		<label>ID:</label><input type="text" name="id" value="admin"/><br>
		<label>PW:</label><input type="text" name="pw" value="hi123456"/><br>
		<label>NAME:</label><input type="text" name="name" value="kim"/><br>
		<label>TEL:</label><input type="text" name="tel" value="010"/><br>
		<input type="submit" value="전송"/><br>
	</form>
</body>
</html>