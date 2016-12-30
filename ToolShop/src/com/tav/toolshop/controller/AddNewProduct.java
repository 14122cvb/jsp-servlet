package com.tav.toolshop.controller;

import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tav.toolshop.bean.Product;
import com.tav.toolshop.model.ProductModel;
import com.tav.toolshop.util.BaseFunction;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
 
import javax.imageio.ImageIO;


public class AddNewProduct extends HttpServlet {

	  private static Logger logger = Logger.getLogger(AddNewProduct.class);
	  public static String path;
	  public AddNewProduct() { 
	    super(); 
	  }
	  public void init(ServletConfig config) {
          path = config.getServletContext().getRealPath("/");
     }

	  
	  protected void doPost(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException { 
		  Date now=new Date();
		  FileOutputStream os = null; 
		  String fname=BaseFunction.getNameByTime();		
		  String fileExt="";
		  for (Part part : request.getParts())
		  {
			  if(BaseFunction.getFileNameExt(part)!=null)
				  fileExt=BaseFunction.getFileNameExt(part);
		  }
		  String filename=fname +"."+fileExt;
		  for (Part part : request.getParts()) { 
		      logger.info(part.getName()); 
		      InputStream is = request.getPart(part.getName()).getInputStream(); 
		      int i = is.available(); 
		      byte[] b  = new byte[i]; 
		      is.read(b); 
		      
		      os = new FileOutputStream(path+"upload/photos/" +filename);
		      os.write(b); 
		      is.close();  
		      os.close();
		  }
		  System.out.println(path);
		  Product prd=new Product();
		  
		  if(BaseFunction.convertUTF8Param(request,"category_id")!=null)
		  try
		  {
				  prd.setCategory_id(Integer.parseInt(BaseFunction.convertUTF8Param(request,"category_id")));
		  }
		  catch(Exception ex){}
			  
		  prd.setName(BaseFunction.convertUTF8Param(request,"name"));
		  if(BaseFunction.convertUTF8Param(request,"price")!=null)
			  try
			  {
				  prd.setPrice(Double.parseDouble(BaseFunction.convertUTF8Param(request,"price")));
			  }
			  catch(Exception ex){}
		  prd.setDescription(BaseFunction.convertUTF8Param(request,"description"));
		  try
		  {
			  prd.setTrademark_id(Integer.parseInt(BaseFunction.convertUTF8Param(request,"trademark_id")));
		  }
		  catch(Exception ex){}
		  try
		  {
			  prd.setCategory_id(Integer.parseInt(BaseFunction.convertUTF8Param(request,"category_id")));
		  }
		  catch(Exception ex){}
		  HttpSession session = request.getSession();
		  prd.setUser_username((String)session.getAttribute("username"));
		  try
		  {
			  prd.setHot(Integer.parseInt(BaseFunction.convertUTF8Param(request,"hot")));
		  }
		  catch(Exception ex){}

		  prd.setUpdate_time(new Date());
		  prd.setPhoto(filename);
		  ProductModel.addNewProcduct(prd);
		  System.out.println("ok!");
		  
	  }
	  
	  
}