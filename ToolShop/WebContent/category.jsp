<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
%>
<%@page import="com.tav.toolshop.model.CategoryModel"%>
<%@page import="com.tav.toolshop.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- include header -->
<%@ include file="common/check_admin.jsp" %>
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>
<%
	String id_st="";
	String order_st="";
	String name_st="";
	String function="add";
	String disabled_add="";
	String disabled_edit="disabled";
	if(request.getParameter("id")!=null)
	{
		id_st=request.getParameter("id");
	}
	if(request.getParameter("order_st")!=null)
	{
		order_st=request.getParameter("order_st");
	}
	if(request.getParameter("name_st")!=null)
	{
		name_st=request.getParameter("name_st");
	}
	if(request.getParameter("function")!=null)
	{
		function=request.getParameter("function");
		if(function.equals("edit"))
		{
			disabled_add="disabled";
			disabled_edit="";
		}
			
	}
 

%>
<div class="center_content">
      <div class="center_title_bar">Thêm danh mục</div>
      <div class="prod_box_big">
        <div class="center_prod_box_big">
        <center>
        <form name="add_form" action="category.do" charset="UTF-8" method="get">
        
            <table border="0">
            	<tr>
                    <td><input type="hidden" name="function" value="<%=function %>"/></td>
                    <td><input type="hidden" name="id" value="<%=id_st %>"/></td>
                </tr>
                <tr>
                    <td>Tên: </td>
                    <td><input type="text" name="name" size="50" value="<%=name_st %>"/></td>
                </tr>
                <tr>
                    <td>Thứ tự: </td>
                    <td><input type="text" name="order_sort" size="20" value="<%=order_st %>" onblur="check_int()"/></td>
                </tr>
                <tr>
                	<td></td>
                    <td colspan="2">
                        <input type="submit" value="Thêm" <%=disabled_add%>>
                        <input type="submit" value="Sửa" <%=disabled_edit%>>
                    </td>
                </tr>
            </table>
        </form>
	</center>
	<p></p>
	<center>
        <table class="gridtable">
		   <tr>
		    <th>Số thứ tự</th>
		    <th>Tên</th>
		    <th>Thứ tự ưu tiên</th>
		    <th>Sửa/xóa</th>
		   </tr>
        <%
        	for(int i=0;i<list.size();i++)
        	{
        %>
        	
		   <tr>
		   <td><%=i+1 %></td>
		   	<td><%=list.get(i).getName() %></td>
		   	<td><%=list.get(i).getOrder_sort() %></td>
		   	<td><a href="category.jsp?function=edit&id=<%=list.get(i).getId() %>&order_st=<%=list.get(i).getOrder_sort() %>&name_st=<%=list.get(i).getName() %>">Sửa</a>/<a href="category.do?function=delete&id=<%=list.get(i).getId() %>">Xóa</a></td>
		   </tr>
		  
        <%
        	}
        %>
        </table>
		</center>
	
    </div>
      </div>
    </div>

    <%@ include file="common/right.jsp" %>
    <%@ include file="common/footer.jsp" %>