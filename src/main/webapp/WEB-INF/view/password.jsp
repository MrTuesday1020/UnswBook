<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/login.css">
</head>
<body>
	<div class="center" align="center">
		<form name="changePwd"
			action="<%=request.getContextPath()%>/user/changePwd" method="post">
			<p></p>
			<input type="password" class="text" id="password" name="password"
				placeholder="New Password" required>
			<p></p>
			<input type="password" class="text" id="conPassword"
				name="conPassword" placeholder="Comfirm New Password" required>
			<p></p>
			<br> <input type="submit" id="changePwd"
				style="width: 200px; height: 35px padding-left:5px;"
				class="signbutton" value="Change Password" />
			<p></p>
		</form>
	</div>
</body>
</html>