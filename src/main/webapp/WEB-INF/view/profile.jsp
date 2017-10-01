<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>Photo: <img src="<%=request.getContextPath()%>/resources/userPhotos/${userSession.photo}" height="42" width="42"/></div>
	<div>Username: ${userSession.username}</div>
	<div>Email: ${userSession.email}</div>
	<div>Name: ${userSession.name}</div>
	<c:if test="${userSession.gender eq 'm'}"><div>Gender: Male</div></c:if>
	<c:if test="${userSession.gender eq 'f'}"><div>Gender: Female</div></c:if>
	<div>BoB: ${userSession.dob}</div>

	<a href="<%=request.getContextPath()%>/user/index">Home</a>
	<a href="<%=request.getContextPath()%>/user/edit">Edit Profile</a>
	<a href="<%=request.getContextPath()%>/user/password">Change Password</a>
	<a href="<%=request.getContextPath()%>/user/photo">Change Photo</a>
</body>
</html>