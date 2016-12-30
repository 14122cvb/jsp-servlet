<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String LOGIN_PAGE = request.getContextPath()+"/login.jsp"; %>  
 <%
 if(session.getAttribute("username")==null)
	 response.sendRedirect(LOGIN_PAGE);
 %>