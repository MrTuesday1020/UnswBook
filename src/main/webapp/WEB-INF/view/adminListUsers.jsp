<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListUsers</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin.css"> 
<body>
<div class='table-a'>
<table style="position:relative; left:15%; top:100px; width: 70%" cellspacing="30"  >
	<tr>
		<th align="left">UserID</th>
		<th align="left">Username</th>
		<th align="left">Name</th>
		<th align="left">Email</th>
		<th align="left">Detail</th>
		<th align="left">Status</th>
    </tr>
	<c:forEach items="${users}" var="user">
	<tr>
		<td><c:out value="${user.id}"></c:out></td>
		<td><c:out value="${user.username}"></c:out></td>
		<td><c:out value="${user.name}"></c:out></td>
		<td><c:out value="${user.email}"></c:out></td>
        <td><a href="<%=request.getContextPath()%>/admin/getReport?id=${user.id}" >Get Report</a></td>
        <td>
    	    	<c:if test="${user.active == 1}">
        	<a href="<%=request.getContextPath()%>/admin/banUser?id=${user.id}" ><font color='red'>Ban</font></a>
		</c:if>
		<c:if test="${user.active == 0}">
		<a href="<%=request.getContextPath()%>/admin/activeUser?id=${user.id}"><font color='green'>Active</font></a>
		</c:if>
      	</td>
    </tr>
	</c:forEach>
</body>
</html>