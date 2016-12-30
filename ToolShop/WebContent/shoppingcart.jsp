<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include header -->
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>

<%
 String id_prd=request.getParameter("id_prd");
 String func=request.getParameter("func");
 if(id_prd!=null)
 {
	 try
	 {
		 String desc=request.getParameter("desc");
		 Double price=new Double(request.getParameter("price"));
		 cart.addItem(id_prd, desc, price, 1);
	 }
	 catch(Exception ex){}
 }
%>
	<div class="center_content">
	<table class="gridtable">
			   <tr>
			    <th>STT</th>
			    <th>Tên</th>
			    <th>Giá</th>
			    <th>Số lượng</th>
			    <th>Tiền</th>
			    <th>Xem</th>
			   </tr>
	<%
	Enumeration enums=cart.getEnumeration();
	String[] tmpItem;
	int j=0;
	while(enums.hasMoreElements())
	{
		tmpItem=(String[])enums.nextElement();
		%>
		  <tr>
		   <td><%=(j+1) %></td>
		   	<td><%=tmpItem[1] %></td>
		   	<td><%=tmpItem[2] %></td>
		   	<td><%=tmpItem[3] %></td>
		   	<td><%=tmpItem[3] %></td>
		   	<td><a href="details.jsp?id_prd=<%=tmpItem[0]%>">Chi tiết</a></td>
		   </tr>
		<%
	}
	%>
	
	</div>

    
<%@ include file="common/right.jsp" %>
<%@ include file="common/footer.jsp" %>
