<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="<%=request.getContextPath()%>/admin/findAllUsers">AllUsers</a>
	</div>

	<form action="<%=request.getContextPath()%>/admin/findUsers" method="post">
			<input type="text" name="keywords" placeholder="search for customers" required> 
			<select name="selection">
				<option value="username">Username</option>
				<option value="email">Email</option>
				<option value="name">Name</option>
			</select>
			<input type="submit" value="Search Users">
	</form>

</body>
</html>