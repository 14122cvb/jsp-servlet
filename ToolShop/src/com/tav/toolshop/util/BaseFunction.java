package com.tav.toolshop.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tav.toolshop.model.dao.DbConnection;

public class BaseFunction {
	public static String getNameByTime()
	{
		String name="";
		Date now=new Date();
		name+=now.getYear()+"_"+now.getMonth()+"_"+now.getDay()+"_"+now.getHours()+"_"+now.getMinutes()+"_"+now.getSeconds()+Math.random();
		return name;		
	}
	public static String getFileNameExt(Part part) { 
		String fileExt=null;
	    for (String cd : part.getHeader("content-disposition").split(";")) { 
	      if (cd.trim().startsWith("filename")) { 
	        String fn= cd.substring(cd.indexOf('=') + 1).trim() 
	            .replace("\"", ""); 
	        fileExt=fn.substring(fn.indexOf('.')+1);
	      } 
	    } 
	    return fileExt;
	  }
	public static int checkRole(HttpSession session)
	{
		int role=0;
		if(session.getAttribute("username")!=null)
		{
			DbConnection dbcon=new DbConnection();
			String[] field=new String[1];
			field[0]="role";
			Object[][] ob=dbcon.selectDataWhere("role", "user", field, " username= '"+session.getAttribute("username")+"'");

		if(ob.length!=0)		
			role=Integer.parseInt(ob[0][0].toString());
		}
		return role;
		
	}
	public static String convertUTF8Param(HttpServletRequest request, String param)
	{
		String name=null;
		try
		{
			name = new String(request.getParameter(param).getBytes("iso-8859-1"), "UTF-8");
		}
		catch(Exception ex){}
		return name;
	}
	public static String getTimeFormat(Date time)
	{
		return (time.getYear()+1900)+"-"+time.getMonth()+"-"+time.getDay()+" "+time.getHours()+":"+time.getMinutes()+":"+time.getSeconds();
	}


}
