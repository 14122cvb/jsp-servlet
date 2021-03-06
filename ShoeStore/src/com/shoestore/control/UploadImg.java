package com.shoestore.control;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shoestore.model.Dbconnection;

/**
 * Servlet implementation class UploadImg
 */
public class UploadImg extends HttpServlet {
	   
	   private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 50 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;
	   

	   
	   public void init(ServletConfig config ){
	      // Get the file location where it would be stored.
	      filePath = config.getServletContext().getRealPath("/");
	      filePath+="myfiles"+"\\";
	      System.out.println("filepath:"+ filePath);
	      //filePath = config.getServletContext().getRealPath("/");
	   }
	   public void doPost(HttpServletRequest request, 
	               HttpServletResponse response)
	              throws ServletException, java.io.IOException {
	      // Check that we have a file upload request
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );
	      if( !isMultipart ){
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>Servlet upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	    
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("c:\\temp"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{ 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);
		
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();
	      String id = "";
	      String name = "";
	      String images = "";
	      String description = "";
	      String datetime = "";
	      String price = "";
	      String dkt_categories_id = "";
	      String fname="";
	    		  
	      
	      while ( i.hasNext () ) 
	      {
	    	  
	         FileItem fi = (FileItem)i.next();
	         
	         if(fi.isFormField())
	         {
	        	 if(fi.getFieldName().equals("name")){
	        		 name=new String(fi.getString().getBytes("iso-8859-1"),"UTF-8");
	        	 }
	        	 if(fi.getFieldName().equals("description")){
	        		 description=fi.getString();
	        	 }
	        	 if(fi.getFieldName().equals("datetime")){
	        		 datetime=fi.getString();
	        	 }
	        	 if(fi.getFieldName().equals("price")){
	        		 price=fi.getString();
	        	 }
	        	 if(fi.getFieldName().equals("dkt_categories_id")){
	        		 dkt_categories_id=fi.getString();
	        	 }
	        	 
	         }
	         if (!fi.isFormField())
	         {	           
	            String fileName = fi.getName();
	            fileName=fileName.substring(fileName.indexOf('.'),fileName.length());
	            fname=getNameByTime()+fileName;
	            file = new File( filePath + fname);
//	            if( fileName.lastIndexOf("\\") >= 0 ){
//	               file = new File( filePath + 
//	               fileName.substring( fileName.lastIndexOf("\\"))) ;
//	            }else{
//	               file = new File( filePath + 
//	               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
//	            }
	            fi.write( file ) ;
	            
	         }
	      }
	      String tablename = "dkt_products";
	      String fields = "name,image,description,price,dkt_categories_id";
	      String value = "";
	      Dbconnection db = new Dbconnection();
	      db.insertData(tablename, fields,"'"+name+"','"+fname+"','"+description+"',"+price+","+dkt_categories_id+"");
	      
	      
	      
	   }catch(Exception ex) {
	       System.out.println(ex);
	   }
	   }
	   public void doGet(HttpServletRequest request, 
	                       HttpServletResponse response)
	        throws ServletException, java.io.IOException {

	   } 
	   
	   public static String getNameByTime(){
		   String name="";
		   Date now=new Date();
		   name+=now.getYear()+"_"+now.getMonth()+"_"+now.getDay()+"_"+now.getHours()+"_"+now.getMinutes()+"_"+now.getSeconds()+Math.random();
		   return name;
	   }
	   
	}
