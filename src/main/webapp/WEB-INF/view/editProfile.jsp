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
		<p></p>
		<form name="editProfile"
			action="<%=request.getContextPath()%>/user/editProfile" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td><input class="text" type="text" id="email" name="email"
						value="${userSession.email}"></td>
				</tr>
				<tr>
					<td>Nickname:</td>
					<td><input class="text" type="text" id="name" name="name"
						value="${userSession.name}"></td>
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
					<td><input class="text" type="text" id="dob" name="dob"
						placeholder="YYYY-MM-DD" value="${userSession.dob}">
					<td>
				</tr>
			</table>
			<input type="submit" id="editProfile" name="submit"
				style="width: 230px; height: 35px padding-left:5px;"
				class="signbutton" value="Submit" />
		</form>
		<p></p>
	</div>
</body>
</html>