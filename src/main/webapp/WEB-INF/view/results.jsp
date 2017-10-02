<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/result.css">
</head>
<body>
<%@ include file="head.jsp" %>
	<c:forEach items="${users}" var="user">
		<div id="out_layer">
		<div id="photo_layer" onclick="javascript:location.href='<%=request.getContextPath()%>/user/userProfile?id=${user.id}'">
    			<img src="<%=request.getContextPath()%>/resources/userPhotos/${user.photo}" width="200" height="200"/>
   		</div>
   		<span id="info_layer">
			<p>Username: ${user.username}</p>
			<p>Email: ${user.email}</p>
			<p>Name: ${user.name}</p>
			<c:if test="${user.gender eq 'm'}">
				<p>Gender: Male</p>
			</c:if>
			<c:if test="${user.gender eq 'f'}">
				<p>Gender: Female</p>
			</c:if>
			<p>BoB: ${user.dob}</p>
		</span>
		</div>
	</c:forEach>
</body>
</html>