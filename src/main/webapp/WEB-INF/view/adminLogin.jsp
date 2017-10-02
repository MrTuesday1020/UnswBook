<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AdminLogin</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css"> 
</head>
<body>
	<div align="center">
		<center><h1> UNSW Book</h1></center>
		<p></p>
		<form name="adminLogin" action="<%=request.getContextPath()%>/admin/login" method="post">
			<input class="text" type="text"  id="username" name="username" placeholder="Username" required>
			<p></p>
			<input class="text" type="password" id="password" name="password" placeholder="Password" required>
			<p></p>
			<input type="submit" id="Login" name="submit" class="signbutton" value="Log in" />
	</form>
	<p></p>
</div>
</body>
</html>





