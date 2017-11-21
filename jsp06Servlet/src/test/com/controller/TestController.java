package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.TestDAO;
import test.com.model.TestDAOimpl;
import test.com.model.TestVO;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/index.do", "/test.do", "/insert.do", 
	"/insertOK.do","/selectAll.do","/update.do"  })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()....");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()....");
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPrecess()....");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getServletPath().equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if(request.getServletPath().equals("/test.do")) {
			System.out.println(request.getParameter("id"));
			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
		}else if(request.getServletPath().equals("/insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/insert.jsp");
			rd.forward(request, response);
		}else if(request.getServletPath().equals("/insertOK.do")) {
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("pw"));
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("tel"));
			TestVO vo = new TestVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			
			TestDAO dao = new TestDAOimpl();
			int result = dao.insert(vo);
			System.out.println("result:"+result);
			
			if(result==1){
				System.out.println("successed...move to select...");
				response.sendRedirect("selectAll.do");
			}else{
				System.out.println("fail...go back");
				response.sendRedirect("insert.do");
			}
		}else if(request.getServletPath().equals("/selectAll.do")) {
			
			TestDAO dao = new TestDAOimpl();
			List<TestVO> list = dao.selectAll();
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/select.jsp");
			rd.forward(request, response);
		}else if(request.getServletPath().equals("/update.do")) {
			
			TestVO vo = new TestVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			TestDAO dao = new TestDAOimpl();
			TestVO tvo = dao.selectOne(vo);
			
			request.setAttribute("tvo", tvo);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/update.jsp");
			rd.forward(request, response);
		}
	}

}
