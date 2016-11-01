<%@page import="Model.BO.GioHangBO"%>
<%@page import="Model.Bean.HangBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
		.slogan{
			line-height:200px;
		}

</style>
</head>
<body>
		<div class="container-fluid text-center ">
	<h1 class="slogan">
		Bút Sờ To

	</h1>
	</div>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="SachServlet">Bút Sờ To</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="SachServlet">Trang chủ</a></li>
      <li><a href="#">Hướng dẫn</a></li>
      <li><a href="#">Liên hệ</a></li> 
    </ul>
    <ul class="nav navbar-nav navbar-right">
<%
      	if(session.getAttribute("info") == null){
      		%>
      		<li><a href="#"><span class="glyphicon glyphicon-user" data-toggle="modal" data-target="#signUp"></span> Sign Up</a></li>
      		<li><a href="#"  data-toggle="modal" data-target="#modalLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      		<%
      	}else{
      		%>
      			<lable><%=session.getAttribute("info") %></lable>
						<form method="POST" method="SachServlet">
				  		<button type="submit"  name="DangXuat">Logout</button>
						</form>
      		<%
      	}
      
      %>
      
    </ul>
  </div>
</nav>
<!--  Modal -->

<div class="modal fade" id="modalSearch" role="dialog">
    <div class="modal-dialog">   
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Tìm Kiếm:</h4>
        </div>
        <div class="modal-body">
                    	<form class="form-search" method="POST" action="SachServlet">
				<div class="form-group">
					<input type="text" class="form-control" id="email" name="search">
				</div>
					<input type="submit" class="btn btn-success" value="Search"/>
			</form>
        </div>
      </div>
      
    </div>
 </div>
  
  
  <div class="modal fade" id="modalLogin" role="dialog">
    <div class="modal-dialog">   
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Login:</h4>
        </div>
        <div class="modal-body">

			<%@include file='TieuDe.jsp' %>
        </div>
      </div>
      
    </div>
 </div>

<!-- End Model -->
	<div class="container">
  <h2>Giỏ Hàng</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Mã Hàng</th>
        <th>Tên Hàng</th>
        <th>Giá</th>
        <th>Số Lượng</th>
        <th>Sửa</th>
        <th>Xóa</th>
      </tr>
    </thead>
    <tbody>
		<% 
    	List<HangBean> lstHang =(List<HangBean>) request.getAttribute("lstHang");
	    for(int i = 0; i< lstHang.size(); i++){
	    	%>
		      <tr>
		        <td><%= lstHang.get(i).getMahang() %></td>
		        <td><%= lstHang.get(i).getTenhang()%></td>
		        <td><%= lstHang.get(i).getGia() * lstHang.get(i).getSoluong()%></td>
		        <td><%= lstHang.get(i).getSoluong()%></td>
		        <td>
		        	<form action="DatMuaHangController?action=sua" method="POST">
		        	<input type="text" name="soluong"/>
						  <input type="hidden" name="ID" value="<%=lstHang.get(i).getMahang()%>">
						  <input type="submit" class="btn btn-success" value="Cập Nhật"/>
					</form>
		        </td>
		        <td>
		        	<form action="DatMuaHangController?action=xoa" method="POST">
		        		<input type="hidden" name="ID" value="<%=lstHang.get(i).getMahang()%>">
						<input type="submit" class="btn btn-danger" value="Xóa"/>
					</form>
		        </td>
		      </tr>	    		
	    	<%
	    } 

	    %>



    </tbody>
  </table>
  <div class="well well-sm">Tổng Tiền: <%=request.getAttribute("tongtien") %></div>
</div>
</body>
</html>