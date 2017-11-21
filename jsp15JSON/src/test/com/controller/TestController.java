package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import test.com.model.TestVO;
import test.com.service.TestService;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/index.do", "/jselectOne.do", "/jselectOneAPI.do",  "/jselectAll.do",  "/jselectAllAPI.do"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public TestService service = new TestService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestController() {
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
	 * @see Served at: HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sPath = request.getServletPath();
		if(sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/jselectOne.do")) {
			
			TestVO vo = new TestVO();
			vo.setName("lee");
			TestVO tvo = service.jselectOne(vo);
			response.getWriter()
			.append("{\"name\":\""+tvo.getName()+"\",\"age\":"+tvo.getAge()+"}");
		}else if(sPath.equals("/jselectOneAPI.do")) {
			
			TestVO vo = new TestVO();
			vo.setName("lee");
			TestVO tvo = service.jselectOne(vo);
//			response.getWriter()
//			.append("{\"name\":\""+tvo.getName()+"\",\"age\":"+tvo.getAge()+"}");
			
			JSONObject jobj = new JSONObject(tvo);
			response.getWriter().print(jobj);
			
		}else if(sPath.equals("/jselectAll.do")) {
			List<TestVO> list = service.jselectAll();
			response.getWriter().append("[");
			for (int i = 0; i < list.size(); i++) {
				response.getWriter()
				.append("{\"name\":\""+list.get(i).getName()+"\",\"age\":"+list.get(i).getAge()+"}");
				if(i!=list.size()-1)response.getWriter().append(",");
			}
			response.getWriter().append("]");
			
		}else if(sPath.equals("/jselectAllAPI.do")) {
			List<TestVO> list = service.jselectAll();
			JSONArray jarray = new JSONArray(list);
			response.getWriter().print(jarray);
			
		}

	}
}
