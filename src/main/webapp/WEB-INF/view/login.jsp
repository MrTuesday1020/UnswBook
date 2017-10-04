<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/login.css">
<title>Login</title>
</head>
<body>
	<div align="center">
		<center>
			<h1>UNSW Book</h1>
		</center>
		<p></p>
		<form name="doLogin" action="<%=request.getContextPath()%>/user/login"
			method="post">
			<input class="text" type="text" id="username" name="username"
				placeholder="Username" required>
			<p></p>
			<input class="text" type="password" id="password" name="password"
				placeholder="Password" required>
			<p></p>
			<input type="submit" name="submit" class="signbutton" value="Log in" />
		</form>
		<p></p>
		<b>Don't have an account? <font size="3" color="#000099"><a
				href="<%=request.getContextPath()%>/register">Sign up</a></font></b>
		<p></p>
	</div>

	<c:if test="${not empty errormsg}">
	<center>
		<p class="errormsg">${errormsg}</p>
	</center>
	</c:if>
</body>
</body>
</html>