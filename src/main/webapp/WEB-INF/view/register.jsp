<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/login.css">
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</head>
<body>
	<div class="center" align="center">
		<center>
			<h1>UNSW Book</h1>
		</center>
		<p class="obique">Find your friends in UNSW</p>
		<form name="doRegister"
			action="<%=request.getContextPath()%>/user/register" method="post" onsubmit="return form_onsubmit()">
			<input class="text" type="text" id="username" name="username"
				placeholder="Username" required>
			<p></p>
			<input class="text" type="email" id="email" name="email"
				placeholder="Email" required>
			<p></p>
			<input class="text" type="password" id="password" name="password"
				placeholder="Password" required>
			<p></p>
			<input class="text" type="password" id="conPassword" name="conPassword"
				placeholder="Confirm Password" required>
			<p></p>
			<input type="submit" id="Register" name="submit"	class="signbutton" value="Sign up"/>
		</form>
		<p></p>
		<b>Have an account? <font size="3" color="#000099"><a
				href="<%=request.getContextPath()%>/login">login</a></font></b>
		<p></p>
	</div>
	
	<c:if test="${not empty errormsg}">
	<center>
		<p class="errormsg">${errormsg}</p>
	</center>
	</c:if>
</body>
</html>