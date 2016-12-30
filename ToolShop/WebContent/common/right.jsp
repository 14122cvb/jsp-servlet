<%@page import="com.tav.toolshop.bean.ShoppingCart"%>
<%@page import="com.tav.toolshop.model.ProductModel"%>
<%@page import="com.tav.toolshop.bean.Product"%>
<%@page import="com.tav.toolshop.model.TrademarkModel"%>
<%@page import="com.tav.toolshop.bean.Trademark"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 ShoppingCart ct=(ShoppingCart)session.getAttribute("cart");
 %>
<div class="right_content">
      <div class="title_box">Tìm kiếm</div>
      <div class="border_box">
        <input type="text" name="newsletter" class="newsletter_input" value="keyword"/>
        <a href="#" class="join">Tìm</a> </div>
      <div class="shopping_cart">
        <div class="title_box">Giỏ hàng của bạn</div>
        <div class="cart_details"><%=ct.getNumberItem() %> <br />
          <span class="border_cart"></span> Tổng: <span class="price"><%=ct.getCost() %> $</span> </div>
        <div class="cart_icon"><a href="#"><img src="images/shoppingcart.png" alt="" width="35" height="35" border="0" /></a></div>
      </div>
      <div class="title_box">Sản phẩm giá trẻ</div>
      <% 
       Product prd_cheap=ProductModel.getProductCheap();
      if(prd_cheap!=null)
      {
      %>
      <div class="border_box">
        <div class="product_title"><a href="#"><%=prd_cheap.getName() %></a></div>
        <div class="product_img"><a href="#"><img src="images/p2.jpg" alt="" border="0" /></a></div>
        <div class="prod_price"> <span class="price"><%=prd_cheap.getPrice() %> $</span></div>
      </div>
      <%} %>
      <div class="title_box">Nhà sản xuất</div>
      <ul class="left_menu">       
        <%
        ArrayList<Trademark> list_trademark_right=TrademarkModel.getAllTrademark();
        	for(int i=0;i<list_trademark_right.size();i++)
        	{
        		String stl="odd";
        		if(i%2!=0)
        		{
        			stl="even";
        		}
        %>
        	<li class="<%=stl%>"><a href="list_product.jsp?idtrade=<%=list_trademark_right.get(i).getId() %>"><%=list_trademark_right.get(i).getName()%></a></li>
        <%
        	}
        %>
        
      </ul>
      <div class="banner_adds"> <a href="#"><img src="images/bann1.jpg" alt="" border="0" /></a> </div>
    </div>
    <!-- end of right content -->
  </div>