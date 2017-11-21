<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL</h1>
	<c:set var="name" value="LEE"></c:set>
	${name}
	${"KIM"}
	<c:out value="KIM"></c:out>
	<c:out value="${name}"></c:out>
	
	<c:if test="${name=='LEE'}">
		<h1>LEE</h1>님 하이
	</c:if>
	<c:if test="${name=='KIM'}">
		<h1>KIM</h1>님 하이
	</c:if>
	<c:choose>
		<c:when test="${name=='KIM'}">
			<h1>KIM</h1>님 하이
		</c:when>
		<c:otherwise>
			로그인하세요
		</c:otherwise>
	</c:choose>
	<c:forEach begin="1" end="5" step="1" var="i" varStatus="x">
		안녕하세요${i}${x.index}
	</c:forEach>
	
	
</body>
</html>