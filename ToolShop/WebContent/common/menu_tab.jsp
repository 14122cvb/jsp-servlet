<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div id="main_content">
    <div id="menu_tab">
      <ul class="menu">
        <li><a href="index.jsp" class="nav"> Trang chủ </a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav">Sản phẩm</a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav">Mua hàng </a></li>
        <li class="divider"></li>
        <li><a href="contact.html" class="nav">Liên hệ</a></li>
        <li class="divider"></li>
        <li><a href="details.html" class="nav">Chi tiết</a></li>
        <%
        if(session.getAttribute("username")!=null)
        {
        	%>
        	<li class="divider"></li>
	        <li><a href="product_mng.jsp" class="nav">Quản lý hàng</a></li>
	        <li class="divider"></li>
	        <li><a href="category.jsp" class="nav">Quản lý danh mục</a></li>
	        <li class="divider"></li>
	        <li><a href="trademark.jsp" class="nav">Quản lý thương hiệu</a></li>
        	<%
        }
        %>
      </ul>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation"> Trang hiện tại: <span class="current">Trang chủ</span> </div>