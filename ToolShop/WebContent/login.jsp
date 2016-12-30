<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include header -->
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>
    <!-- center content -->
    <div class="center_content">
      <div class="center_title_bar">Trạng thái đăng nhập</div>
      <div class="prod_box_big">
        <div class="center_prod_box_big">
			<% if (session.getAttribute("username")==null) { %>

            <form method="post" action="login.do">          
            <div>
	        	<input type="text" name="username" value="" placeholder="Tên đăng nhập">
	        </div>
	        <p>
	        </p>
	       <div>
	        <input type="password" name="password" value="" placeholder="Mật khẩu"></p>
	        </div>
	        <p>
	        </p>
	        <p class="remember_me">
	          <label>
	            <input type="checkbox" name="remember_me" id="remember_me">
	            Lưu đăng nhập
	          </label>
	        </p>
	        <p class="prod_details"><input type="submit" name="commit"  value="Đăng nhập"></p>
	      </form>
	      <% } else { %>
				<div>Bạn đang đăng nhập với tài khoản <%= session.getAttribute("username") %></div>
		  <% } %>

        </div>
      </div>
    </div>
    <!-- end of center content -->
    
    <%@ include file="common/right.jsp" %>
    <%@ include file="common/footer.jsp" %>
    

  