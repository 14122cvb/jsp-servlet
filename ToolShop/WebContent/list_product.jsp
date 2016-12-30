<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include header -->
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>

	<div class="center_content">

	<center>
        
        <%
        	int pos=0;
        	int el=10;
        	try
        	{
        		pos=Integer.parseInt(request.getParameter("pos"));
        		el=Integer.parseInt(request.getParameter("el"));
        	}
        	catch(Exception ex){}
        	if((request.getParameter("idcat")!=null)||(request.getParameter("idtrade")!=null))
        	{
        	ArrayList<Product> list_ofCat=null;
        	if(request.getParameter("idcat")!=null)
        		list_ofCat=ProductModel.getTopProductOfCat_trade(pos,el,"category_id="+request.getParameter("idcat"));
        	if(request.getParameter("idtrade")!=null)
            	list_ofCat=ProductModel.getTopProductOfCat_trade(pos,el,"trademark_id="+request.getParameter("idtrade"));
        	%>
        	<div></div>
	        <table class="gridtable">
			   <tr>
			    <th>STT</th>
			    <th>Tên</th>
			    <th>Giá</th>
			    <th>Mô tả</th>
			    <th>Xem</th>
			   </tr>
        	<%
        	for(int i=0;i<list_ofCat.size();i++)
        	{
        %>
        
		   <tr>
		   <td><%=(i+1) %></td>
		   	<td><%=list_ofCat.get(i).getName() %></td>
		   	<td><%=list_ofCat.get(i).getPrice() %></td>
		   	<td><%=list_ofCat.get(i).getDescription() %></td>
		   	<td><a href="details.jsp?id_prd=<%=list_ofCat.get(i).getId() %>">Chi tiết</a></td>
		   </tr>
		  
        <%
        	}
        	}
        %>
        </table>
		</center>
	
	</div>

    
<%@ include file="common/right.jsp" %>
<%@ include file="common/footer.jsp" %>
