<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include header -->
<%@ include file="common/header.jsp" %>
<%@ include file="common/menu_tab.jsp" %>
<%@ include file="common/left.jsp" %>

<div class="center_content">
      <div class="center_title_bar">Theem san pham</div>
      <div class="prod_box_big">
        <div class="center_prod_box_big">
        <center>
        <form action="add_product.do" enctype="multipart/form-data" method="get">
            <table border="0">
                <tr>
                    <td>Tên: </td>
                    <td><input type="text" name="name" size="50"/></td>
                </tr>
                <tr>
                    <td>Giá: </td>
                    <td><input type="text" name="price" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Hãng: </td>
                    <td><input type="text" name="trademark_id" size="50"/></td>
                </tr>
                <tr>
                    <td>Danh mục: </td>
                    <td><input type="text" name="category_id" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Tiểu biểu: </td>
                    <td><input type="text" name="hot" size="50"/></td>
                </tr>
                <tr>
                    <td>Available: </td>
                    <td><input type="text" name="available" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Warranties: </td>
                    <td><input type="text" name="warranties" size="50"/></td>
                </tr>
                <tr>
                    <td>Transport: </td>
                    <td><input type="text" name="transport" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Include: </td>
                    <td><input type="text" name="include_st" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Mô tả: </td>
                    <td><input type="text" name="description" size="50"/></td>
                </tr>
                
                <tr>
                    <td>Ảnh: </td>
                    <td><input type="file" name="uploadFile" size="50"/></td>
                </tr>
                <tr>
                	<td></td>
                    <td colspan="2">
                        <input type="submit" value="Thêm">
                    </td>
                </tr>
            </table>
        </form>
	</center>
    </div>
      </div>
    </div>
    <%@ include file="common/right.jsp" %>
    <%@ include file="common/footer.jsp" %>