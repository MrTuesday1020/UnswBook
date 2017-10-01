<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/login">login</a>

	<form name="doRegister" action="<%=request.getContextPath()%>/user/register" method="post">
		<div>
			<span>Username:</span><input type="text" id="Username" name="Username" required>
		</div>
		<div>
			<span>Email:</span><input type="text" id="Email" name="Email" required>
		</div>
		<div>
			<span>Password:</span><input type="text" id="Password" name="Password" required>
		</div>
		<div>
			<span>Confirm Password:</span><input type="text" id="ConPassword" name="ConPassword" required>
		</div>
		<div>
			<input type="submit" id="Register" value="Register" />
		</div>
	</form>
</body>
</html>