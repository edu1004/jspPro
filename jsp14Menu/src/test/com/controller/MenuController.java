package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.MenuDAO;
import test.com.model.MenuDAOimpl;
import test.com.model.MenuVO;
import test.com.service.MenuService;

/**
 * Servlet implementation class MenuController
 */
@WebServlet({ "/index.do", "/insert.do", "/insertOK.do", "/update.do", "/updateOK.do", "/deleteOK.do", "/select.do" })
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService mService = new MenuService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath:" + sPath);
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("menu/insert.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insertOK.do")) {
			
			MenuVO vo = new MenuVO();
			vo.setMenu(request.getParameter("menu"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			vo.setStore(request.getParameter("store"));
			vo.setKcal(Integer.parseInt(request.getParameter("kcal")));
			int result = mService.insert(vo);
			if (result == 1) {
				System.out.println("insert successed");
				response.sendRedirect("select.do");
			} else {
				System.out.println("insert failed");
			}
		} else if (sPath.equals("/select.do")) {
			
			List<MenuVO> list = mService.selectAll();
			System.out.println("list.size():" + list.size());

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("menu/select.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/update.do")) {
			
			MenuVO vo = new MenuVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			MenuVO mvo = mService.selectOne(vo);
			request.setAttribute("mvo", mvo);
			RequestDispatcher rd = request.getRequestDispatcher("menu/update.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/updateOK.do")) {
			
			MenuVO vo = new MenuVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setMenu(request.getParameter("menu"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			vo.setStore(request.getParameter("store"));
			vo.setKcal(Integer.parseInt(request.getParameter("kcal")));
			int result = mService.update(vo);
			if (result == 1) {
				System.out.println("update successed");
				response.sendRedirect("select.do");
			} else {
				System.out.println("update failed");
				response.sendRedirect("update.do?num="+request.getParameter("num"));
			}
		}else if (sPath.equals("/deleteOK.do")) {
			
			MenuVO vo = new MenuVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			int result = mService.delete(vo);
			if (result == 1) {
				System.out.println("delete successed");
				response.sendRedirect("select.do");
			} else {
				System.out.println("delete failed");
				response.sendRedirect("select.do");
			}
		}

	}// end doProcess()

}// end class
