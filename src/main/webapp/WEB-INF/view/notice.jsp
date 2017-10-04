<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin.css"> 
</head>
<body>
<%@ include file="head.jsp" %>
<div class='table-a'>
<table style="position:relative; left:15%; top:100px; width: 70%" cellspacing="30"  >
<tr>
	<th align="left">Message Notice:</th>
</tr>
<c:forEach items="${messageNotices}" var="messageNotice">
<tr>
	<td>${messageNotice.username} liked ur message: ${messageNotice.messagetext}</td>
</tr>
</c:forEach>
</table>
<table style="position:relative; left:15%; top:100px; width: 70%" cellspacing="30"  >
<tr>
	<th align="left">Friend Request:</th>
</tr>
<c:forEach items="${friendNotices}" var="friendNotice">
<tr>
	<td>${friendNotice.username} wants to add you!<a class="requestConfirm" href="<%=request.getContextPath()%>/user/confirmFriend?id=${friendNotice.id}">Confirm</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>