<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.com.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	System.out.println("updateOK.jsp");
	//get>>>?id=admin&pw=hi123456&name=kim&tel=010
	System.out.println(request.getParameter("num"));
	System.out.println(request.getParameter("id"));
	System.out.println(request.getParameter("pw"));
	System.out.println(request.getParameter("name"));
	System.out.println(request.getParameter("tel"));
	
	
	TestVO vo = new TestVO();
	vo.setNum(Integer.parseInt(request.getParameter("num")));
	vo.setId(request.getParameter("id"));
	vo.setPw(request.getParameter("pw"));
	vo.setName(request.getParameter("name"));
	vo.setTel(request.getParameter("tel"));
	
	TestDAO dao = new TestDAOimpl();
	int result = dao.update(vo);
	if(result==1){
		System.out.println("successed...move to select...");
		response.sendRedirect("select.jsp");
	}else{
		System.out.println("fail...go back");
		response.sendRedirect("update.jsp?num="+request.getParameter("num"));
	}
	
%>