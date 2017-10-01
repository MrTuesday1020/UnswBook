<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/login.css">
</head>
<body>
	<div class="center" align="center">
		<center>
			<h1>UNSW Book</h1>
		</center>
		<p class="obique">Find your friends in UNSW</p>
		<form name="doRegister"
			action="<%=request.getContextPath()%>/user/register" method="post">
			<input class="text" type="text" id="username" name="username"
				placeholder="Username" required>
			<p></p>
			<input class="text" type="email" id="email" name="email"
				placeholder="Email" required>
			<p></p>
			<input class="text" type="text" id="password" name="password"
				placeholder="Password" required>
			<p></p>
			<input class="text" type="text" id="ConPassword" name="ConPassword"
				placeholder="Confirm your password" required>
			<p></p>
			<input type="submit" id="Register" name="submit"
				style="width: 230px; height: 35px padding-left:5px;"
				class="signbutton" value="Sign up" />
		</form>
		<p></p>
		<b>Have an account? <font size="3" color="#000099"><a
				href="<%=request.getContextPath()%>/login">login</a></font></b>
		<p></p>
	</div>
</body>
</html>