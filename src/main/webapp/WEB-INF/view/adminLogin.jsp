<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="adminLogin" action="<%=request.getContextPath()%>/admin/login" method="post">
		<div>
			<span>Username:</span><input type="text" id="Username"
				name="Username">
		</div>
		<div>
			<span>Password:</span><input type="text" id="Password"
				name="Password">
		</div>
		<div>
			<input type="submit" id="Login" value="Login" />
		</div>
	</form>

</body>
</html>