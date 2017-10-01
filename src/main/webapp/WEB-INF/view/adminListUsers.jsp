<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listUsers</title>
<body>

	<c:forEach items="${users}" var="user">
		<div>
			<span>UserID:</span>
			<c:out value="${user.id}"></c:out>
			<span>Username:</span>
			<c:out value="${user.username}"></c:out>
			<span>Name</span>
			<c:out value="${user.name}"></c:out>
			<span>Email:</span>
			<c:out value="${user.email}"></c:out>
			<a href="<%=request.getContextPath()%>/admin/getReport?id=${user.id}">Get Report</a>
			<c:if test="${user.active == 1}">
				<a href="<%=request.getContextPath()%>/admin/banUser?id=${user.id}">Ban</a>
			</c:if>
			<c:if test="${user.active == 0}">
				<a href="<%=request.getContextPath()%>/admin/activeUser?id=${user.id}">Active</a>
			</c:if>
		</div>
	</c:forEach>

</body>
</html>