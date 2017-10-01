<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="editProfile" action="<%=request.getContextPath()%>/user/editProfile"
		method="post">
		<div>
			<span>Email:</span><input type="text" id="email" name="email" value="${userSession.email}">
		</div>
		<div>
			<span>Name:</span><input type="text" id="name" name="name" value="${userSession.name}">
		</div>
		<div>
			<span>Gender:</span>
			<select name="gender">
				<option value="f">Female</option>
				<option value="m">Male</option>
			</select>
		</div>
		<div>
			<span>Date of Birth:</span><input type="text" id="dob" name="dob" value="${userSession.dob}">
		</div>
		<div>
			<input type="submit" id="editProfile" value="Submit" />
		</div>
	</form>
</body>
</html>