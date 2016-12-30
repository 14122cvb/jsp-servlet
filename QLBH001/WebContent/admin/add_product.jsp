<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Adminstrator</title>

<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="bower_components/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
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
							
                                    <form name="form" method="post" action="AddProduct.do" onsubmit="return validateForm()">
										<div class="form-group">
                                            <input name="productId" class="form-control" type="hidden">
                                        </div>
										<div class="form-group">
                                            <label>Tên sản phẩm</label>
                                            <input name="productName" class="form-control"  >
                                        </div>
										<div class="form-group">
                                            <label>Mô tả</label>
                                            <input name="describe" class="form-control">
                                        </div>
										<div class="form-group">
                                            <label>Giá sản phẩm</label>
                                            <input name="price" class="form-control">
                                        </div>
										<div class="form-group">
                                            <label>Số lượng</label>
                                            <input name="amount" class="form-control">
                                        </div>
										<div class="form-group">
                                            <label>Nhà Cung cấp</label>
                                            <select name="supplyId" class="form-control">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Loai sản phẩm</label>
                                            <select name="groupId" class="form-control">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Chọn ảnh 1</label>
                                            <input name="file1" type="file">
                                        </div>
										<div>
											<input type="submit" value="Thêm mới">
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
    var x = document.forms["form"]["productName"].value;
    if (x == null || x == "") {
        alert("Tên không được để trống");
        return false;
    }
    x = document.forms["form"]["describe"].value;
    if (x == null || x == "") {
        alert("Mô tả sản phẩm không được để trống");
        return false;
    }
    x = document.forms["form"]["price"].value;
    if (x == null || x == "") {
        alert("Giá không được để trống");
        return false;
    }
    x = document.forms["form"]["amount"].value;
    if (x == null || x == "") {
        alert("Số lượng sản phẩm không được để trống");
        return false;
    }

}
</script>
</body>
</html>