<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminUserActive</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css">
</head>
<body>
<div align="center">
	<p></p>
	<c:if test="${not empty username}">
	<br><centre><font color='green'>${username} has been activated!</font></centre><br>
	</c:if>
	<c:if test="${empty username}">
	<br><centre><font color='red'>Activate user ${username} failed</font></centre><br>
	</c:if>
	<p></p>
	<a href="<%=request.getContextPath()%>/admin/findAllUsers">
	<input type="submit"  value="Return to All User" class="signbutton" />
	</a>
	<p></p>
</div>
</body>
</html>