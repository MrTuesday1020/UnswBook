<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserProfile</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
</head>
<body>
<%@ include file="head.jsp" %>
 <div class="main">
  <div id="out_layer" class="position">
   <div id="photo_layer">
    <img src="<%=request.getContextPath()%>/resources/userPhotos/${user.photo}" height="200" width="200"/>
    <p></p>
    <p></p>
    <p></p>
    	<c:if test="${user.friendstatus == 0}">
		<a href="<%=request.getContextPath()%>/user/addFriend?id=${user.id}">
		<input type="button" name="add" class="signbutton" value="Add Friend"></a>
	</c:if>
	<c:if test="${user.friendstatus == 1}">
		<span>request sent!</span>
	</c:if>
	<c:if test="${user.friendstatus == 2}">
		<a href="<%=request.getContextPath()%>/user/deleteFriend?id=${user.id}">
		<input type="button" name="delete" class="signbutton" value="Delete Friend"></a>
	</c:if>
   </div>
   
   <span id="info_layer">
	<p>Username: ${user.username}</p>
	<p>Email: ${user.email}</p>
	<p>Name: ${user.name}</p>
	<c:if test="${user.gender eq 'm'}"><p>Gender: Male</p></c:if>
	<c:if test="${user.gender eq 'f'}"><p>Gender: Female</p></c:if>
	<p>BoB: ${user.dob}</p>
	<p></p>
	</span>
</body>
</html>