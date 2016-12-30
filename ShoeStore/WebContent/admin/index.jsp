<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.shoestore.model.ProductModel"%>
<%@page import="com.shoestore.bean.Product"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Transdmin Light</title>

<!-- CSS -->
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/jNice.js"></script>
</head>

<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>Transdmin Light</span></a></h1>
        
        <!-- You can name the links with lowercase, they will be transformed to uppercase by CSS, we prefered to name them with uppercase to have the same effect with disabled stylesheet -->
        <ul id="mainNav">
        	<li><a href="#" class="active">DASHBOARD</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="#">ADMINISTRATION</a></li>
        	<li><a href="#">DESIGN</a></li>
        	<li><a href="#">OPTION</a></li>
        	<li class="logout"><a href="#">LOGOUT</a></li>
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="#">Exchange</a></li>
                    	<li><a href="#" class="active">Print resources</a></li>
                    	<li><a href="#">Training &amp; Support</a></li>
                    	<li><a href="#">Books</a></li>
                    	<li><a href="#">Safari books online</a></li>
                    	<li><a href="#">Events</a></li>
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">Dashboard</a> &raquo; <a href="#" class="active">Print resources</a></h2>
                
                <div id="main">
                	<form action="" class="jNice">
					<h3>Sample section</h3>
                    	<table cellpadding="0" cellspacing="0">
                    	    <%ArrayList<Product> list=ProductModel.getAll();
                    	    for(int i=0;i<list.size();i++) 
                    	    {%>
							<tr>
                                <td><%=list.get(i).getName()%></td>
                                <td class="action"><a href="Productdetail.jsp?id=<%= list.get(i).getId()%>" class="view">View</a><a href="#" class="edit">Edit</a><a href="#" class="delete">Delete</a></td>
                            </tr>
                            <%}%>                        
                        </table>
					<h3>Another section</h3>
					</form>
					<form name="add_form" action="uploadimg.do" charset="UTF-8" method="post" enctype="multipart/form-data"> 
                    	<fieldset>
                    	
                    	  	<p><label>id:</label><input type="text" name="id" class="text-long" /></p>
                        	<p><label>Tên Sản Phẩm:</label><input type="text" name="name" class="text-long" /></p>
                        	<p><label>Mô tả:</label><input type="text" name="description" class="text-long" /></p>
                        	<p><label>Ngày nhập:</label><input type="date" name="date_made" class="text-long" /></p>
                        	<p><label>Giá:</label><input type="text" name="price" class="text-long" /></p>
                        	<p><label>Category_id:</label><input type="text" name="dkt_categories_id" class="text-long" /></p>
              
                        	<p><label>Ảnh:</label><input type="file" name="file" size="50" /></p>
                        	<p><input type="submit" value="Thêm sản phẩm" /></p>
                          
                        </fieldset>
                        </form>
                    
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
        <p id="footer">Feel free to use and customize it. <a href="http://www.perspectived.com">Credit is appreciated.</a></p>
    </div>
    <!-- // #wrapper -->
</body>
</html>


