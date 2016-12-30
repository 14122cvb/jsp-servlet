<%@page import="com.tav.toolshop.bean.Product"%>
<%@page import="com.tav.toolshop.model.ProductModel"%>
<%@page import="com.tav.toolshop.model.CategoryModel"%>
<%@page import="com.tav.toolshop.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="left_content">
      <div class="title_box">Danh mục</div>
      <ul class="left_menu">     
        <%
         	ArrayList<Category> list=CategoryModel.getAllCategory();
        	for(int i=0;i<list.size();i++)
        	{
        		String stl="odd";
        		if(i%2!=0)
        		{
        			stl="even";
        		}
        %>
        	<li class="<%=stl%>"><a href="list_product.jsp?idcat=<%=list.get(i).getId() %>"><%=list.get(i).getName()%></a></li>
		  
        <%
        	}
        %>
        
      </ul>
      <div class="title_box">Sản phẩm tiêu biểu</div>
      <div class="border_box">
      <%
       Product prd_hot=ProductModel.getHotProduct();
      if(prd_hot!=null)
      {
      %>
        <div class="product_title"><a href="#"><%=prd_hot.getName() %></a></div>
        <div class="product_img"><a href="#"><img src="images/p1.jpg" alt="" border="0" /></a></div>
        <div class="prod_price"> <span class="price"><%=prd_hot.getPrice() %>$</span></div>
      <% }%>
      </div>
      <div class="title_box">Liên lạc</div>
      <div class="border_box">
        <input type="text" name="newsletter" class="newsletter_input" value="your email"/>
        <a href="#" class="join">Gửi</a> </div>
      <div class="banner_adds"> <a href="#"><img src="images/bann2.jpg" alt="" border="0" /></a> </div>
    </div>
    <!-- end of left content -->