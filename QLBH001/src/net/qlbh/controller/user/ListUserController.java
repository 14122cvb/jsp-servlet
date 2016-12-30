package net.qlbh.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.qlbh.dao.impl.EmployeeDaoImpl;
import net.qlbh.entities.Employee;
import net.qlbh.util.Common;

/**
 * Servlet implementation class ListUserController
 */
@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
			List<Employee> list = new ArrayList<Employee>();
			HttpSession session = request.getSession();
			//name for search and display
			String keyNameSearch = "";
			String message = "";
			
			//current page
//			int currentPage = 0;

			String contextPath = request.getContextPath();
			if(!Common.checkLogin(session)){
                response.sendRedirect(contextPath + "/admin/login.jsp");
			}
			else{		
				//check and get data from request
//				if (session.getAttribute("key_name_search") == null) {
//					if(request.getParameter("key_name_search") != null){
//					keyNameSearch = request.getParameter("key_name_search").toString();
//					}
//                } else {
//                    	keyNameSearch = session.getAttribute("key_name_search").toString();
//                    }
				if (request.getParameter("key_name_search_user") != null) {
					keyNameSearch = request.getParameter("key_name_search").toString();
                } else {
                    if (session.getAttribute("key_name_search_user") != null) {
                    	keyNameSearch = session.getAttribute("key_name_search_user").toString();
                    }
                }

				list = employeeDaoImpl.getListEmployees(0, 100, Common.escapeInjection(keyNameSearch), "asc", "asc", "asc");
				System.out.println(Common.escapeInjection(keyNameSearch));
				if(list.size() == 0){
					message = "Không tìm thấy bản ghi nào!";
				}
				
				//response data to jsp page
				request.setAttribute("list_employee", list);
				request.setAttribute("message", message);
				session.setAttribute("key_name_search_user", keyNameSearch);
				RequestDispatcher req = request.getRequestDispatcher("list_user.jsp");
	            req.forward(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
