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
	<jsp:include page="../menu.html"></jsp:include>
	<form action="updateOK.jsp" method="get">
		<label>NUM:</label><span>${param.num}</span>
						<input type="hidden" name="num" value="${param.num}"/><br>
		<label>ID:</label><input type="text" name="id" value="${tvo.id}"/><br>
		<label>PW:</label><input type="text" name="pw" value="${tvo.pw}"/><br>
		<label>NAME:</label><input type="text" name="name" value="${tvo.name}"/><br>
		<label>TEL:</label><input type="text" name="tel" value="${tvo.tel}"/><br>
		<input type="submit" value="전송"/><br>
	</form>
</body>
</html>