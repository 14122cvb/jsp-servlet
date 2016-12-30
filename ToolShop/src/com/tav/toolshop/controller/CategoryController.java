package com.tav.toolshop.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tav.toolshop.bean.Category;
import com.tav.toolshop.model.CategoryModel;
import com.tav.toolshop.util.BaseFunction;

public class CategoryController extends HttpServlet {
	
	public CategoryController() { 
	    super(); 
	  }
	
	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException{

		HttpSession session = request.getSession();
		if (BaseFunction.checkRole(session)!=0)
		{
		if(request.getParameter("function")!=null)
		{
			if(request.getParameter("function").equals("edit"))
			{
				if(request.getParameter("id")!=null)
				{
					Category ctg=new Category();
					ctg.setName(BaseFunction.convertUTF8Param(request,"name"));
					System.out.println(ctg.getName());
					try
					{
						ctg.setId(Integer.parseInt(request.getParameter("id")));
						ctg.setOrder_sort(Integer.parseInt(request.getParameter("order_sort")));				
					}
					catch(NumberFormatException ex){}
					if(CategoryModel.editCategory(ctg)==1)
						response.sendRedirect("category.jsp");
				}
				
			}
			if(request.getParameter("function").equals("delete"))
			{
				if(request.getParameter("id")!=null)
				{
					try
					{
						CategoryModel.deleteCategory(Integer.parseInt(request.getParameter("id")));
						
					}
					catch(NumberFormatException ne){}
					response.sendRedirect("category.jsp");
				}
				
			}
			if(request.getParameter("function").equals("add"))
			{
				Category ctg=new Category(); 
				ctg.setName(BaseFunction.convertUTF8Param(request,"name"));
				try
				{
					ctg.setOrder_sort(Integer.parseInt(request.getParameter("order_sort")));				
				}
				catch(NumberFormatException ex){}
				if(CategoryModel.addNewCategory(ctg)==1)
					response.sendRedirect("category.jsp");
			}
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
