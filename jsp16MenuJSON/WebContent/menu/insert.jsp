<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>메뉴입력페이지</h1>
		</hgroup>
		<nav>
			<jsp:include page="topMenu.html"></jsp:include>
		</nav>
	</header>
	
	<section>
		<form action="insertOK.do" method="post">
			<label>menu:</label><input type="text" name="menu" value="doncasu"/><br/>
			<label>price:</label><input type="number" name="price" value="10000"/><br/>
			<label>store:</label><input type="text" name="store" value="doncasuzip"/><br/>
			<label>kcal:</label><input type="number" name="kcal" value="400"/><br/>
			<input type="submit" value="save"/>
			<input type="reset" value="reset"/>
		</form>
	</section>
	
</body>
</html>