<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Tran Thanh Tai</h1>
	<form action="NhanVienController" action="POST">
		<lable>Ma Don Vi</lable>
		<input type="text" name="madv"/>
		<input type="submit" name="submit" value="Hien Thi"/>
	</form>
	<%=request.getAttribute("madv") %>
</body>
</html>