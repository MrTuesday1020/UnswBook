<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Profile</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
</head>
<body>
	<%@ include file="head.jsp" %>
	<div class="div_layer" align="center">
		<p></p>
		<form name="editProfile" action="<%=request.getContextPath()%>/user/editProfile" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td><input class="text" type="text" id="email" name="email" value="${userSession.email}"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input class="text" type="text" id="name" name="name" value="${userSession.name}" required></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><select name="gender" class="text">
							<option value="f">Female</option>
							<option value="m">Male</option>
					</select></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input class="text" type="text" id="dob" name="dob" placeholder="YYYY-MM-DD" value="${userSession.dob}" required>
					<td>
				</tr>
			</table>
			<input type="submit" id="editProfile" name="submit" class="signbutton" style="width:200px" value="Submit" />
		</form>
		<p></p>
	</div>
</body>
</html>