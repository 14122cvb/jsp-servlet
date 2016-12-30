<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include header -->
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>


    <div class="center_content">
    <% 
    try
    {
    	
        int id_prd=Integer.parseInt(request.getParameter("id_prd"));
    	Product prd_by_id=ProductModel.getProductById(id_prd);
    	String trademark_name="Chưa cập nhập";
    	Trademark tm=TrademarkModel.getTrademarkById(prd_by_id.getTrademark_id());
    	if(tm!=null)
    		trademark_name=tm.getName();
    	String category_name="Chưa cập nhật";
    	Category ct=CategoryModel.getCategoryById(prd_by_id.getCategory_id());
    	if(ct!=null)
    		category_name=ct.getName();
    	    		
    %>
      <div class="center_title_bar"><%=prd_by_id.getName() %></div>
      <div class="prod_box_big">
        <div class="center_prod_box_big">
          <div class="product_img_big"> <a href="javascript:popImage('images/big_pic.jpg','Some Title')" title="header=[Zoom] body=[&nbsp;] fade=[on]"><img src="images/p3.jpg" alt="" border="0" /></a>
            <div class="thumbs"> <a href="#" title="header=[Thumb1] body=[&nbsp;] fade=[on]"><img src="images/thumb1.jpg" alt="" border="0" /></a> <a href="#" title="header=[Thumb2] body=[&nbsp;] fade=[on]"><img src="images/thumb2.jpg" alt="" border="0" /></a> <a href="#" title="header=[Thumb3] body=[&nbsp;] fade=[on]"><img src="images/thumb1.jpg" alt="" border="0" /></a> </div>
          </div>
          <div class="details_big_box">
            <div class="product_title_big"><%=prd_by_id.getName() %></div>
            <div class="specifications"> Giá: <span class="blue"><%=prd_by_id.getPrice() %> $</span><br />
              Hãng: <span class="blue"><%= trademark_name %></span><br />
              Danh mục: <span class="blue"> <%=category_name %></span><br />
              Mô tả :<span class="blue"><%=prd_by_id.getDescription() %> </span><br />
            </div>
            <a href="#" class="prod_buy">Thêm vào giỏ </a> <a href="index.jsp" class="prod_compare">Trang chủ</a> </div>
        </div>
      </div>
      <% }
    	catch(Exception ex){}
    %>
    </div>
    
    <%@ include file="common/right.jsp" %>
    <%@ include file="common/footer.jsp" %>
