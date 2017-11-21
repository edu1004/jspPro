<%@page import="test.com.TestVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("key", "value");
		out.print(request.getAttribute("key"));
// 		System.out.println(request.getAttribute("key"));
		String test = (String)request.getAttribute("key");
		
		String[] names = new String[]{"aaaa","bbbb"};
		request.setAttribute("names", names);
		
		TestVO vo = new TestVO();
		request.setAttribute("vo", vo);
		
		List<String> list = new ArrayList<String>();
		list.add("kim1");
		list.add("kim2");
		list.add("kim3");
		request.setAttribute("list", list);
		
		List<TestVO> list2 = new ArrayList<TestVO>();
		list2.add(new TestVO());
		list2.add(new TestVO());
		request.setAttribute("list2", list2);
		
		
		out.print("<>"+session.getAttribute("id"));
		out.print("<>"+application.getAttribute("autoLogin"));
		
	%>
	<a href="next.jsp">이전페이지</a>
	<a href="session.jsp">session.jsp</a>
	<h1>attribute.jsp</h1>
	<h1><%=test %></h1>
	<h1>${key}</h1>
	<h1>${names[0]},${names[1]}</h1>
	<h1>${vo.id},${vo.pw}</h1>
	<h1>${list[0]},${list[1]}</h1>
	<h1>${list2[0].id},${list2[0].pw}</h1>
	<h1>application:${autoLogin}</h1>
</body>
</html>