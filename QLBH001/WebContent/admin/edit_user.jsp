<%@page import="net.qlbh.entities.Employee"%>
<%@page import="net.qlbh.dao.impl.EmployeeDaoImpl"%>
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
	<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
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
                            <a href="tables.html">Tables</a>
                        </li>
                        <li>
                            <a href="forms.html">Forms</a>
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
				</br>
                <!-- /.col-lg-12 -->
            </div>
			<div>
				<div class="panel panel-default">
                        <div class="panel-body">
							<div class="col-lg-6">
							<%
								int id = Integer.parseInt(request.getParameter("id"));
								EmployeeDaoImpl edi = new EmployeeDaoImpl();
								Employee employee = edi.getEmployeeById(id);
								request.setAttribute("id", id);
			
							%>
                                    <form name="form" method="post" action="EditUser.do" onsubmit="return validateForm()">
										<div class="form-group">
                                            <label>Id</label>
                                            <input name="employeeId" class="form-control" value="<%= id%>" >
                                        </div>
										<div class="form-group">
                                            <label>Fullname</label>
                                            <input name="fullname" class="form-control" value="<%= employee.getName() %>" >
                                        </div>
										<div class="form-group">
                                            <label>Address</label>
                                            <input name="address" class="form-control" value="<%= employee.getAddress() %>" >
                                        </div>
										<div class="form-group">
                                            <label>Phone</label>
                                            <input name="phone" class="form-control" value="<%= employee.getPhone() %>" >
                                        </div>
										<div class="form-group">
                                            <label>Email</label>
                                            <input name="email" class="form-control" value="<%= employee.getEmail() %>" >
                                        </div>
										<div class="form-group">
                                            <label>Role</label>
                                            <select name="role" class="form-control">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                            </select>
                                        </div>
										<div class="form-group">
                                            <label>Username</label>
                                            <input name="username" class="form-control" value="<%= employee.getUsername() %>" >
                                        </div>
										<div class="form-group">
                                            <label>Password</label>
                                            <input name="password" class="form-control" value="<%= employee.getPassword() %>" >
                                        </div>
										<div>
											<input type="submit" value="Sửa">
										</div>
									</form>
							</div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
			</div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="bower_components/raphael/raphael-min.js"></script>

	<script src="bower_components/morrisjs/morris.min.js"></script>

    <script src="js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>


</body>

<script type="text/javascript">
function validateForm() {
    var x = document.forms["form"]["fullname"].value;
    if (x == null || x == "") {
        alert("Tên không được để trống");
        return false;
    }
    x = document.forms["form"]["address"].value;
    if (x == null || x == "") {
        alert("Địa chỉ không được để trống");
        return false;
    }
    x = document.forms["form"]["phone"].value;
    if (x == null || x == "") {
        alert("Số điện thoại không được để trống");
        return false;
    }
    x = document.forms["form"]["email"].value;
    if (x == null || x == "") {
        alert("Email không được để trống");
        return false;
    }
    x = document.forms["form"]["username"].value;
    if (x == null || x == "") {
        alert("Username không được để trống");
        return false;
    }
    x = document.forms["form"]["password"].value;
    if (x == null || x == "") {
        alert("Password không được để trống");
        return false;
    }
}
</script>

</html>