<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="main">
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
 </div>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <img src="<%=request.getContextPath()%>/resources/userPhotos/${userSession.photo}" width="200" height="200"/>
   </div>
   <span id="info_layer">
    <p>Username: ${userSession.username}</p>
    <p>Email: ${userSession.email}</p>
    <p>Name: ${userSession.name}</p>
    <c:if test="${userSession.gender eq 'm'}"><p>Gender: Male</p></c:if>
    <c:if test="${userSession.gender eq 'f'}"><p>Gender: Female</p></c:if>
    <p>DoB: ${userSession.dob}</p>
   </span>

   <a href="<%=request.getContextPath()%>/user/edit">
	<input type="submit" name="edit" class="signbutton" value="Edit Profile"></a>
   <a href="<%=request.getContextPath()%>/user/password">
	<input type="submit" name="change_password" class="signbutton" value="Change Password" /></a>
   <a href="<%=request.getContextPath()%>/user/photo">
	<input type="submit" name="change_photo" class="signbutton" value="Change Photo" /></a>
   
  </div>
 </div>
</body>
</html>