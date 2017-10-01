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
	<c:if test="${not empty username}">
		<div>${username} has been banned!</div>
	</c:if>
	<c:if test="${empty username}">
		<div>Ban user ${username} failed</div>
	</c:if>
	<a href="<%=request.getContextPath()%>/admin/index">Index</a>
</body>
</html>