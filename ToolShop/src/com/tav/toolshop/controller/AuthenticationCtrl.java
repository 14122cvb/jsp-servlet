package com.tav.toolshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tav.toolshop.model.Authentication;

public class AuthenticationCtrl extends HttpServlet{
	
	public AuthenticationCtrl()
	{
		super();
	}
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException
	{
		String out=rq.getParameter("out");	
		
		if(out!=null)
		if(out.equals("true"))
		{
			HttpSession session = rq.getSession();
			session.removeAttribute("username");
		}		
		System.out.println(rq.getHeader("Referer") );
		String referer = rq.getHeader("Referer");
		rp.sendRedirect(referer);
		//rq.getRequestDispatcher((String)rq.getAttribute("javax.servlet.forward.request_uri")).forward(rq, rp);
	}
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException
	{
		String username=rq.getParameter("username");
		String password=rq.getParameter("password");
		System.out.println(username+password);
		Authentication au=new Authentication();
		if(au.checkLogin(username, password))
		{
			HttpSession session = rq.getSession();
			session.setAttribute("username", username);
			String referer = rq.getHeader("Referer");
			rp.sendRedirect(referer);
		}
		else
		{
			String referer = rq.getHeader("Referer");
			rp.sendRedirect(referer);
		}
	}

}
