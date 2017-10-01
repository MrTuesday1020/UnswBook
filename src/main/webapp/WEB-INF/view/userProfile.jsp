<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>Photo: <img src="<%=request.getContextPath()%>/resources/userPhotos/${user.photo}" height="42" width="42"/></div>
	<div>Username: ${user.username}</div>
	<div>Email: ${user.email}</div>
	<div>Name: ${user.name}</div>
	<c:if test="${user.gender eq 'm'}"><div>Gender: Male</div></c:if>
	<c:if test="${user.gender eq 'f'}"><div>Gender: Female</div></c:if>
	<div>BoB: ${user.dob}</div>
	
	<a href="<%=request.getContextPath()%>/user/index">Home</a>
	
	<c:if test="${user.friendstatus == 0}">
		<a href="<%=request.getContextPath()%>/user/addFriend?id=${user.id}">Add</a>
	</c:if>
	<c:if test="${user.friendstatus == 1}">
		<span>request sent!</span>
	</c:if>
	<c:if test="${user.friendstatus == 2}">
		<a href="<%=request.getContextPath()%>/user/deleteFriend?id=${user.id}">Delete</a>
	</c:if>
</body>
</html>