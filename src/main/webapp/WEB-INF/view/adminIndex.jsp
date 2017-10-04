<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminSearch</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
</head>
<body>
<div class="div_layer" style="top: 10%;" align="center">
	<p></p>
	<form action="<%=request.getContextPath()%>/admin/findUsers" method="post">
			<input type="text" style="width:60%" class="text" name="keywords" placeholder="search for customers" required> 
			<select name="selection" class="select">
				<option value="username">Username</option>
				<option value="email">Email</option>
				<option value="name">Name</option>
			</select>
	<input type="submit"  class="signbutton" style="width:150px; position:relative; right:80px; top:50px; " value="Search Users" />
	</form>
	<a href="<%=request.getContextPath()%>/admin/findAllUsers"  >
	<input type="submit"  class="signbutton" style="width:150px; position:relative; left:80px; top:15px;" value="All Users" />
	</a>
	<p></p>
</div>
</body>
</html>