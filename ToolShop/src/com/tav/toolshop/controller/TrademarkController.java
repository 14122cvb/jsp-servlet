package com.tav.toolshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tav.toolshop.bean.Trademark;
import com.tav.toolshop.model.TrademarkModel;
import com.tav.toolshop.util.BaseFunction;

public class TrademarkController  extends HttpServlet{

	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if (BaseFunction.checkRole(session)!=0)
		{
		if(BaseFunction.convertUTF8Param(request,"function")!=null)
		{
			if(BaseFunction.convertUTF8Param(request,"function").equals("edit"))
			{
				if(BaseFunction.convertUTF8Param(request,"id")!=null)
				{
					Trademark ctg=new Trademark();
					ctg.setName(BaseFunction.convertUTF8Param(request,"name"));
					System.out.println(ctg.getName());
					try
					{
						ctg.setId(Integer.parseInt(BaseFunction.convertUTF8Param(request,"id")));
						ctg.setOrder_sort(Integer.parseInt(BaseFunction.convertUTF8Param(request,"order_sort")));				
					}
					catch(NumberFormatException ex){}
					if(TrademarkModel.editTrademark(ctg)==1)
						response.sendRedirect("trademark.jsp");
				}
				
			}
			if(BaseFunction.convertUTF8Param(request,"function").equals("delete"))
			{
				if(BaseFunction.convertUTF8Param(request,"id")!=null)
				{
					try
					{
						TrademarkModel.deleteTrademark(Integer.parseInt(BaseFunction.convertUTF8Param(request,"id")));
						
					}
					catch(NumberFormatException ne){}
					response.sendRedirect("trademark.jsp");
				}
				
			}
			if(BaseFunction.convertUTF8Param(request,"function").equals("add"))
			{
				Trademark ctg=new Trademark();
				ctg.setName(BaseFunction.convertUTF8Param(request,"name"));
				System.out.println(ctg.getName());
				try
				{
					ctg.setOrder_sort(Integer.parseInt(BaseFunction.convertUTF8Param(request,"order_sort")));				
				}
				catch(NumberFormatException ex){}
				if(TrademarkModel.addNewTrademark(ctg)==1)
					response.sendRedirect("trademark.jsp");
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
