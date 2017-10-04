<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/report.css"> 
</head>
<body>
<div class="main">
	<div id="out_layer" class="position">
		<div id="photo_layer">
			<img src="<%=request.getContextPath()%>/resources/userPhotos/${user.photo}" height="200" width="200"/>
			<p></p><p></p><p></p><p></p>
			<a href="<%=request.getContextPath()%>/admin/index">
			<input type="button" name="add" class="signbutton" value="Return To Search Page"></a>
		</div>
		<span id="info_layer">
		<p>UserID: ${user.id}</p>
		<p>Username: ${user.username}</p>
		<p>Email: ${user.email}</p>
		<p>Name: ${user.name}</p>
		<c:if test="${user.gender eq 'm'}"><p>Gender: Male</p></c:if>
		<c:if test="${user.gender eq 'f'}"><p>Gender: Female</p></c:if>
		<p>Birth: ${user.dob}</p>
		<p>Registered: ${user.time}</p>
	</span>
	</div>
	<div class='table-a'>
	<table style="position:relative; left:15%; top:100px; width: 70%" cellspacing="30"  >
	<tr>
		<th align="left">MessageID</th>
		<th align="left">UserId</th>
		<th align="left">Text</th>
		<th align="left">Image</th>
		<th align="left">Time</th>
	</tr>
	<c:forEach items="${messages}" var="message">
	<tr>
		<td><c:out value="${message.id}"></c:out></td>
		<td><c:out value="${message.userid}"></c:out></td>
		<td><c:out value="${message.text}"></c:out></td>
		<td><c:out value="${message.image}"></c:out></td>
		<td><c:out value="${message.time}"></c:out></td>
	</tr>
	</c:forEach>
	</table>
	<table style="position:relative; left:15%; top:100px; width: 70%" cellspacing="30"  >
	<tr>
		<th align="left">FriendID</th>
		<th align="left">Username</th>
		<th align="left">Name</th>
		<th align="left">Time</th>
	</tr>
	<c:forEach items="${friends}" var="friend">
	<tr>
		<td><c:out value="${friend.id}"></c:out></td>
		<td><c:out value="${friend.username}"></c:out></td>
		<td><c:out value="${friend.name}"></c:out></td>
		<td><span> They became friends <c:out value="${friend.time}"></c:out> ago </span></td>
	</tr>
	</c:forEach>
</div>
</body>
</html>