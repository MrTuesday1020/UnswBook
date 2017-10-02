<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<title>AdvSearch</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
</head>
<body>
<%@ include file="head.jsp" %>
<div class="div_layer" align="center">
	<form class="search_form"action="<%=request.getContextPath()%>/user/advSearch" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input class="text" type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input class="text" type="email" id="email" name="email"></td>
		</tr>
		<tr>
			<td>Birthday:</td>
			<td><input class="text" type="text" id="dob" name="dob" placeholder="YYYY-MM-DD"></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><select name="gender" class="text">
				<option value="a">Any</option>
				<option value="f">Female</option>
				<option value="m">Male</option>
			</select></td>
			</tr>
	</table>
	<div class="adcanced_search_button">
		<input type="submit" id="editProfile" name="submit" class="signbutton" style="width:200px" value="Search" onclick="return isEveryInputEmpty();"/>
	</div>
	</form>
</div>
</body>
</html>