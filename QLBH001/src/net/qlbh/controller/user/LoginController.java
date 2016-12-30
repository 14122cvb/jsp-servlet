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

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();        
        String template = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        if(!employeeDaoImpl.checkLogin(username, password)){
        	template = contextPath + "/admin/login.jsp";
        	response.setStatus(response.SC_MOVED_TEMPORARILY);
        	response.setHeader("location", template);
        }
        else{
        	session.setAttribute("username", username);
        	response.sendRedirect(contextPath + "/admin/ListUser.do");       	
        }
	}

}
