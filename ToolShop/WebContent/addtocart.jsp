<jsp:useBean id="cart" scope="session" class="com.tav.toolshop.bean.ShoppingCart"/>
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

String referer = request.getHeader("Referer");
response.sendRedirect(referer);
%>