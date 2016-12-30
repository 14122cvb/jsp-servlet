<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng nhập </title>
<style type="text/css">
h2{color:rgb(0, 255, 235)}

body{
background:#144C94;
}
.wapper{width:1080px;height:600px;background:url(images/hinh-nen.jpg);margin:0px auto;}
</style>
</head>
<body>
<div class = "wapper">
<h2><p>Welcom To Shoe Store </p></h2>
<h3 style="color:rgb(255, 0, 122)"><p> Đăng nhập tài khoản </p></h3>
<% if(session.getAttribute("username") == null) { %>
<form action="login" method="post">
	<table>
		<tr>
			<td>Tên tài khoản</td>
			<td><input type="text" name="username" id="username"/></td>
		</tr>
		<tr>
			<td>Mật khẩu</td>
			<td><input type="password" name="password" id="password"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" name="submit" id="submit" value="Đăng nhập" style="color:blue"/></td>
		</tr>
	</table>
</form>
<%}
else
  { %>
		<h2>Chào Mừng <%=session.getAttribute("username") %> đến với ShoeStore </h2>
<%}%>
</div>
</body>
</html>