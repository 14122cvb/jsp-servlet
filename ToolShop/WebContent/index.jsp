<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include header -->
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>
    <!-- center content -->
    <div class="center_content">
      <div class="oferta"> <img src="images/p1.png" width="165" height="113" border="0" class="oferta_img" alt="" />
        <div class="oferta_details">
        <% 
         Product prd_new=ProductModel.getNewProduct();
         if(prd_new!=null)
         {
        %>
          <div class="oferta_title"><%=prd_new.getName() %></div>
          <div class="oferta_text"> <%=prd_new.getDescription() %></div>
          <a href="details.jsp?id_prd=<%= prd_new.getId()%>" class="prod_buy">Chi tiết</a> </div>
        <%} %>
      </div>
      <div class="center_title_bar">Sản phẩm mới nhất</div>
      <%
       ArrayList<Product> list_top_product= ProductModel.getTopNewProduct(1, 6);
       for(int i=0;i<list_top_product.size();i++)
       {
    	   %>
    	    <div class="prod_box">
	        <div class="center_prod_box">
	          <div class="product_title"><a href="#"><%=list_top_product.get(i).getName() %></a></div>
	          <div class="product_img"><a href="details.jsp?id_prd=<%=list_top_product.get(i).getId() %>"><img src="images/p1.jpg" alt="" border="0" /></a></div>
	          <div class="prod_price"> <span class="price"><%=list_top_product.get(i).getPrice() %></span></div>
	        </div>
	        <div class="prod_details_tab"> <a href="addtocart.jsp?id_prd=<%=list_top_product.get(i).getId() %>&price=<%=list_top_product.get(i).getPrice() %>" class="prod_buy">Thêm vào giỏ</a> <a href="details.jsp?id_prd=<%= list_top_product.get(i).getId()%>" class="prod_details">Chi tiết</a> </div>
	      </div>
    	   <%
       }
      %>
      
     


      <div class="center_title_bar">Sản phẩm được quan tâm nhiều nhất</div>
      <%
       ArrayList<Product> list_hot_product= ProductModel.getTopHotProduct(1, 3);
       for(int i=0;i<list_hot_product.size();i++)
       {
      %>
      <div class="prod_box">
        <div class="center_prod_box">
          <div class="product_title"><a href="#"><%=list_hot_product.get(i).getName() %></a></div>
          <div class="product_img"><a href="details.jsp?id_prd=<%=list_top_product.get(i).getId() %>" ><img src="images/p7.jpg" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="price"><%= list_hot_product.get(i).getPrice()%> $</span></div>
        </div>
        <div class="prod_details_tab"> <a href="#" class="prod_buy">Thêm vào giỏ</a> <a href="details.jsp?id_prd=<%=list_top_product.get(i).getId() %>" class="prod_details">Chi tiết</a> </div>
      </div>
      <%
       }
      %>

    </div>
    <!-- end of center content -->
    <%@ include file="common/right.jsp" %>
    <%@ include file="common/footer.jsp" %>
    

  