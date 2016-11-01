<%@page import="Model.Bean.NhanVienBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.table{
		width:100%;
		
	}
	.table td{
		border:1px solid black;
	}
</style>
</head>
<body>
	<h1>Tran Thanh Tai </h1>
	<form action="NhanVienController" action="POST" >
		<lable>TimKiem</lable>
		<input type="text" name="timkiem"/>
		<input type="submit" name="submit" value="Hien Thi"/>
	</form>
	<table class="table" >
		<tr>
			<th>Ten Nhan Vien</th>
			<th>Ngay Sinh</th>
			<th>He So Luong</th>
			<th>Phu Cap</th>
			<th>Don Vi</th>
		</tr>
	
<%
  if(request.getAttribute("lstNhanVien") != null){
	ArrayList<NhanVienBean> lstNhanVien = (ArrayList<NhanVienBean>)request.getAttribute("lstNhanVien");
	for(int i = 0;i<lstNhanVien.size();i++){
		%>
			<tr>
				<td><%=lstNhanVien.get(i).getHoten() %></td>
				<td><%=lstNhanVien.get(i).getNgaysinh() %></td>
				<td><%=lstNhanVien.get(i).getHsl() %></td>
				<td><%=lstNhanVien.get(i).getPhucap() %></td>
				<td><%=lstNhanVien.get(i).getManv() %></td>
				
			</tr>
		<%
	}
}  
%>
</table>

<form action ="ThemController" method="POST">
	<input  type="text" name="manv"/>
	<input  type="text" name="tennv"/>
	<input  type="text" name="ngaysinh"/>
	<input  type="text" name="hsl"/>
	<input  type="text" name="phucap"/>
	<input  type="text" name="madv"/>
	<input type="submit" name="submit" value="THem"/>
</form>
<%= request.getAttribute("kt") %>
<%= request.getAttribute("madv") %>
</body>
</html>