<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp 안녕하세요</h1>
	<jsp:include page="menu.html"></jsp:include>
	
	
	<h1>Servlet : 사용자 요청에대한 처리를 할때 제어부문을 담당</h1>
	<div>HttpServlet객체를 상속받아서 구현한다.</div>
	<div>post,get 방식처리를 분리해서 처리할 수 있다.</div>
	<div>request 처리 전,후에도 로직에 관여할 수 있다.</div>
	<a href="test.do?id=웹">test페이지</a>
	<a href="insert.do">insert페이지</a>
	<form action="test.do" method="post">
		<input type="text" name="id" value="웹"/>
		<input type="submit" value="send"/>
	</form>
</body>
</html>