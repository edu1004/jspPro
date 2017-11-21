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
			<h1>메뉴 수정페이지</h1>
		</hgroup>
		<nav>
			<jsp:include page="topMenu.html"></jsp:include>
		</nav>
	</header>
	
	<section>
		<form action="updateOK.do" method="post">
			<label>num:</label>${mvo.num}<input type="hidden" name="num" value="${mvo.num}"/><br/>
			<label>menu:</label><input type="text" name="menu" value="${mvo.menu}"/><br/>
			<label>price:</label><input type="number" name="price" value="${mvo.price}"/><br/>
			<label>store:</label><input type="text" name="store" value="${mvo.store}"/><br/>
			<label>kcal:</label><input type="number" name="kcal" value="${mvo.kcal}"/><br/>
			<input type="submit" value="save"/>
			<input type="reset" value="reset"/>
		</form>
	</section>
	
</body>
</html>