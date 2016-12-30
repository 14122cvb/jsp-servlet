package com.shoestore.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoestore.model.Dbconnection;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.length()!=0 && password.length()!=0)
		{
			Dbconnection db = new Dbconnection();
			int kt = db.checklogin(username, password);
			db.closeconnection();
			System.out.println("kt_end = "+kt);
			if(kt==1)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("admin/index.jsp");
				
			}
			else
			{
				String referer = request.getHeader("Referer");
				response.sendRedirect(referer);
			}
		}
		else
		{
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer);
		}
		}
	}
