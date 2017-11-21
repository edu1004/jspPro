<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.com.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	System.out.println("deleteOK.jsp");
	//get>>>?num=77
	System.out.println(request.getParameter("num"));
	
	
	TestVO vo = new TestVO();
	vo.setNum(Integer.parseInt(request.getParameter("num")));
	
	TestDAO dao = new TestDAOimpl();
	int result = dao.delete(vo);
	if(result==1){
		System.out.println("successed...move to select...");
		response.sendRedirect("select.jsp");
	}else{
		System.out.println("fail...go back");
		response.sendRedirect("select.jsp");
	}
	
%>