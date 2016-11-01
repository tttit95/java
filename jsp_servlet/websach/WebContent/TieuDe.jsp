	
			<%
				if(session.getAttribute("info") == null){
					
						%>
				<form method="POST" method="SachServlet">
				  <div class="form-group">
				    <label for="email">Email address:</label>
				    <input type="email" class="form-control" id="email" name="Email">
				  </div>
				  <div class="form-group">
				    <label for="pwd">Password:</label>
				    <input type="password" class="form-control" id="pwd" name="Password">
				  </div>
				  <div class="checkbox">
				    <label><input type="checkbox"> Remember me</label>
				  </div>
				  <button type="submit" class="btn btn-success">Login</button>
				</form>
										<%
					
				}else{
					%>
						<lable><%=session.getAttribute("info") %></lable>
						<form method="POST" method="SachServlet">
				  <button type="submit" class="btn btn-success" name="DangXuat">Đăng Xuất</button>
				</form>
					<%
				}
			%>
	