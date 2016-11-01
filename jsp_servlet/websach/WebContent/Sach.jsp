<%@page import="Model.Bean.SachBean"%>
<%@page import="Model.Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <!--  <base href="http://localhost:8080/070916/" target="_blank"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>

		.div1{
			text-align:center;
			width:300px;
			float:left;
			border:1px solid #e5e5e5;
			margin:5px;
			min-height:500px;
		}
		.div1 img{
			margin-bottom:50px;
			margin-top:10px;
		}
		.footer{
		border-top:1px solid #e5e5e5;
			text-align:center;
			min-height:100px;
		}
		.page{
			text-align:center;
		}
		h3{
			border:1px solid black;
			text-align:center;
		
		}
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
      <li><a href="#" data-toggle="modal" data-target="#modalSearch"><span class="glyphicon glyphicon-search" ></span> Search</a></li>
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<h3>Thể Loại</h3>
				<ul>
					<%
					
					ArrayList<LoaiBean> l = (ArrayList<LoaiBean>)request.getAttribute("lstLoai");
					
					for(int i = 0; i < l.size(); i++){
						%>
							<li><a href="SachServlet?ml=<%=l.get(i).getMaloai()%>"><%= l.get(i).getTenloai() %></a></li>
						<%
					}
					%>
				</ul>
			</div>
			<div class="col-sm-9">
			
			<%

			ArrayList<SachBean> s = (ArrayList<SachBean>)request.getAttribute("lstSach");
			int cfg[] = (int[])request.getAttribute("config");
			int start = 0;
			int limit = 12 ;
			int total_page = 5;
			int current_page = 1;
			int total_record = 1;;
			if(cfg != null)
			{
				total_record = cfg[0];
				total_page = cfg[1];
				if(total_page <= 1) 
					limit = total_record;
				current_page = cfg[2];
				start = cfg[3];
	
				
				
			}

			for(int i = start;i < start + limit; i++){
				%>
					<div class="div1">
						<img src="<%= s.get(i).getAnh()%>">
						<p>Tên Sách:<%= s.get(i).getTensach()%></p>
						<p>Tác Giả:<%= s.get(i).getTacgia()%></p>
						<p>Giá: <%= s.get(i).getGia()%></p>
						<form action="DatMuaHangController" method="POST">
							<input type="hidden" name="ID" value="<%=s.get(i).getMasach() %>" size="30" />
							<input type="submit" class="btn btn-primary" value="Đặt Mua">
						</form>
						
					</div>
				<%
			}
			%>
				
				
				
			</div>
			<div class="col-sm-1">
			
			</div>
		</div>
		<div class="page">
			<ul class="pagination">
				  <li><a href="SachServlet?page=1">First</a></li>
				  <li><a href="SachServlet?page=<%=current_page - 1%>"><<</a></li>
				  <%
				  	for(int i = 0;i<(int) Math.ceil(total_record/limit) ; i++){
				  		%>
				  			<li class="<%
				  				if(i == (current_page - 1)){
				  					out.println("active");
				  				}
				  			
				  			%>"><a href="SachServlet?page=<%=i+1%>" ><%=i+1 %></a></li>
				  		<%
				  	}
				  %>
				  <li><a href="SachServlet?page=<%=current_page + 1%>">>></a></li>
				  <li><a href="SachServlet?page=<%=total_page%>">Last</a></li>
			</ul>
		</div>
		
	</div>
	
	<footer>
	<div class="row">
			<div class="col-sm-2">
			
			</div>
			<div class="col-sm-8 footer">
				<p>@Design by: <a>Trần Thanh Tài</a></p>
				<p>18/10/2016</p>
			</div>
			<div class="col-sm-2">
			
			</div>
	</div>
	
		
	</footer>
</body>
</html>