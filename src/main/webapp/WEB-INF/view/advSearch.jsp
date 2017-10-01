<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<title>Insert title here</title>
</head>
<body>
<form class="search_form"action="<%=request.getContextPath()%>/user/advSearch" method="post">
			<div>
				<div>Name:</div>
				<input type="text" id="name" name="name" placeholder="search for name">
			</div>
			<div>
				<div>Email:</div>
				<input type="text" id="email" name="email" placeholder="search for email">
			</div>
			<div>
				<div>DoB:</div>
				<input type="text" id="dob" name="dob" placeholder="example: 2012-10-20">
			</div>
			<div>
				<div>Gender:</div>
				<select name="gender">
					<option value="a">Any</option>
					<option value="f">Female</option>
					<option value="m">Male</option>
				</select>
			</div>
			<div>
				<div class="adcanced_search_button"><input type="submit" value="Search Users" onclick="return isEveryInputEmpty();"></div>
			</div>
		</form>
</body>
</html>