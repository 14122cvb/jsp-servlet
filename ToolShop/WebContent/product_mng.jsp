<%@page import="com.tav.toolshop.model.ProductModel"%>
<%@page import="com.tav.toolshop.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include header -->
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>
<%
	String id_prd=request.getParameter("id_prd");
    String dis_bt="disabled"; 
    String st="";
    Product prd=null;
	if(id_prd!=null)
	{
		dis_bt="";	
		try
		{
			prd=ProductModel.getProductById(Integer.parseInt(id_prd));
		}
		catch(NumberFormatException ex){}
	}
	
%>
<div class="center_content">
      <div class="center_title_bar">Thêm sản phẩm</div>
      <div class="prod_box_big">
        <div class="center_prod_box_big">
        <center>
        <form action="add_product.do" method="post">
            <table border="0">
                <tr>
                    <td>Tên: </td>
                    <td><input type="text" name="name" size="50" value="<%= (prd!=null) ? prd.getName() : st %>"/></td>
                </tr>
                <tr>
                    <td>Giá: </td>
                    <td><input type="text" name="price" size="50" value="<%= (prd!=null) ? prd.getPrice() : st %>"/></td>
                </tr>
	                
                
                <tr>
                    <td>Hãng: </td>
                    <td>
                    	<select name="trademark_id">
	                    	<option value="">Chọn hãng sản xuất..</option>
							  <%
							  ArrayList<Trademark> list_trademark=TrademarkModel.getAllTrademark();
					        	for(int i=0;i<list_trademark.size();i++)
					        	{
					        		String selected="";
					        		if(prd!=null)
									 selected=(list_trademark.get(i).getId()==prd.getTrademark_id()) ? "selected" : "";
						        %>
						        	<option value="<%=list_trademark.get(i).getId() %>" <%=selected %>><%=list_trademark.get(i).getName() %></option>
								  
						        <%
						        	}
						        %>
						  
						</select>
                    
                    </td>
                </tr>
                

                <tr>
                	<td>Danh mục: </td>
                    <td>
	                    <select name="category_id">
	                    	<option value="">Chọn danh mục...</option>
							  <%
					        	for(int i=0;i<list.size();i++)
					        	{
					        		String selected="";
					        		if(prd!=null)
					        	 		 selected=(list.get(i).getId()==prd.getCategory_id()) ? "selected" : "";
							        
						        %>
						        	<option value="<%=list.get(i).getId() %>" <%=selected %>><%=list.get(i).getName() %></option>
								  
						        <%
						        	}
						        %>
						  
						</select>
                    </td>
                </tr>
                
                <tr>
                    <td>Tiểu biểu: </td>
                    <td>
	                    <select name="hot">
	                     <%
	                       String selected_hot="";
	                       String selected_no_hot="";
	                       if(prd!=null)
	                       {
	                       if(prd.getHot()==1)	
	                    	  selected_hot="selected";
	                       if(prd.getHot()==0)
	                    	   selected_no_hot="selected";
	                       }
	                     %>
	                      <option value="0" <%=selected_no_hot %>>Không</option>
						  <option value="1" <%=selected_hot %>>Có</option>						  
						</select>
                    </td>
                </tr>               
                <tr>
                    <td>Mô tả: </td>
                    <td>
                    <textarea name="description" cols="39" rows="6" ><%= (prd!=null) ? prd.getDescription() : st %></textarea>
                    </td>
                </tr>
                
                <tr>
                    <td>Ảnh: </td>
                    <td><input type="file" name="uploadFile" size="50"/></td>
                </tr>
                <% if(prd!=null){ %>
                <tr>
                    <td></td>
                    <td><img src="upload/photos/<%=prd.getPhoto()%>" alt=" <%=prd.getName() %>" height="42" width="42"></td>
                </tr>
                <%} %>
                <tr>
                	<td></td>
                    <td colspan="2">
                        <input type="submit" value="Thêm">
                        <input type="submit" value="Sửa" <%=dis_bt%>>
                        <input type="submit" value="Xóa" <%=dis_bt%>>
                    </td>
                </tr>
            </table>
        </form>
	</center>
    </div>
      </div>
    </div>
    <%@ include file="common/right.jsp" %>
    <%@ include file="common/footer.jsp" %>