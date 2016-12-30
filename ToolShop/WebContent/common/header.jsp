<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType ("text/html; charset=UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
 <%
 String status="<a href=\"login.jsp\" class=\"title_box_out\">Đăng nhập</a>";
 if(session.getAttribute("username")!=null)
	 status="<a href=\"login.do?out=true\" class=\"title_box_out\">Đăng xuất</a>";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Cửa hàng dụng cụ</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />

<script type="text/javascript" src="js/boxOver.js"></script>

<script language=JavaScript>

function check_int()
{
   var txtOrder = document.add_form.order;
   if (!((parseFloat(txtOrder.value) == parseInt(txtOrder.value)) && !isNaN(txtOrder.value)))
   {
      alert("Số thứ tự phải là số tự nhiên");
      txtAge.focus();
      txtAge.select();
   }
}
</script>

</head>
<body>
<div id="main_container">
  <div id="header">
    <div class="top_right">

      <div class="languages">
        <div class="lang_text">Ngôn ngữ </div>
        <a href="#" class="lang"><img src="images/en.gif" alt="" border="0" /></a> <a href="#" class="lang"><img src="images/de.gif" alt="" border="0" /></a> </div>
      <div class="status_login">
          <%=status %>
          </div>
      <div class="big_banner"> <a href="#"><img src="images/banner728.jpg" alt="" border="0" /></a> </div>
    </div>
    <div id="logo"> <a href="#"><img src="images/logo.png" alt="" border="0" width="182" height="85" /></a> </div>
  </div>