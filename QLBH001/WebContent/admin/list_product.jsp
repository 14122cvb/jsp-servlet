<%@page import="net.qlbh.entities.ProductInfo"%>
<%@page import="net.qlbh.entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.qlbh.entities.Group"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Adminstrator</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">
    <link href="dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">
    <link href="bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">ADMIN</a>
                <a class="navbar-brand" href="/Logout.do">LOG OUT</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                

                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
             
                        <li>
                            <a href="ListUser.do">Danh sách sản phẩm</a>
                        </li>
                        <li>
                            <a href="ListProduct.do">Danh mục sản phẩm</a>
                        </li>
                        <li>
                            <a href="">Danh mục nhóm sản phẩm</a>
                        </li>
                        <li>
                            <a href="">Hóa đơn</a>
                        </li>
                        <li>
                            <a href="">Phản hồi khách hàng</a>
                        </li>
                        <li>
                            <a href="forms.html">Danh sách bảo hành</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Danh sách nhân viên</h1>
                </div>
                <div class="col-lg-6"  padding-bottom: 20px;">
				<form method="post" action="ListUser.do">
				<div class="form-group">
				
                    <label>Nhóm sản phẩm</label>
                  	<select class="form-control" name="group_id">
                <%
                	if(Integer.parseInt(session.getAttribute("group_id").toString()) == 0){
                		%>
                		<option value="0">Tất cả</option>
                		<%
                	}
					if(request.getAttribute("list_group") != null){
						List<Group> listGroup = (ArrayList<Group>)request.getAttribute("list_group");
						for(Group group : listGroup){
							if(Integer.parseInt(session.getAttribute("group_id").toString()) == group.getGroupId()){
							%>
								<option value="<%= group.getGroupId()%>" selected="selected"><%= group.getGroupName() %></option>
							<% }else{
							%>
								<option value="<%= group.getGroupId()%>"><%= group.getGroupName() %></option>
							<%	
							}
						}
					}
				%>
              		</select>
                </div>
				<div class="input-group custom-search-form">
				<%if(session.getAttribute("key_name_search") != null) {%>
                                <input type="text" name="key_name_search" class="form-control" value="<%= session.getAttribute("key_name_search")%>">
                                <%} else{%>
                                <input type="text" name="key_name_search" class="form-control">
                                <%}%>
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                
                </div>
                </form>
				</div>		
				</br>
                <!-- /.col-lg-12 -->
            </div>
			<div>
				<div class="panel panel-default">
                        <div class="panel-body">
							<div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Mã sản phẩm</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Mô tả</th>
                                            <th>Giá</th>
                                            <th>Số lượng</th>
											<th>Nhà cung cấp</th>
											<th>Loại sản phẩm</th>
											<th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    if(request.getAttribute("list_product") != null){
                                 		List<ProductInfo> listProduct = (ArrayList<ProductInfo>)request.getAttribute("list_product");
                                 		for(ProductInfo product : listProduct){                                   
                                    %>
                             			<tr>
                             				<td><%= product.getProductId() %></td>
                             				<td><%= product.getProductName() %></td>
                             				<td><%= product.getDescribe() %></td>
                             				<td><%= product.getPrice() %></td>
                             				<td><%= product.getAmount() %></td>
                             				<td><%= product.getGroupName() %></td>
                             				<td><%= product.getSupplyName() %></td>
                             				<td>
                             					<a href="../admin/edit_user.jsp?id=<%=product.getProductId()%>"> Sửa</a>
                             					<a href="../admin/delete_user.jsp?id=<%=product.getProductId()%>" onclick="return confirm('Bạn có chắc muốn xóa?')"> Xóa</a>
                             				</td>
                             			</tr>
                             			<% } }%>
                                        
                                    </tbody>
                                </table>
                            </div>
                            <a href="../admin/add_product.jsp">Thêm mới sản phẩm</a>										
                        </div>
                        <!-- /.panel-body -->
                    </div>
			</div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../bower_components/raphael/raphael-min.js"></script>
    <script src="bower_components/raphael/raphael-min.js"></script>

    <script src="../bower_components/morrisjs/morris.min.js"></script>
	<script src="bower_components/morrisjs/morris.min.js"></script>

    <script src="../js/morris-data.js"></script>
    <script src="js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>