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
	<div>
		<a href="<%=request.getContextPath()%>/user/profile">Profile</a>
		<a href="<%=request.getContextPath()%>/user/notice">Notice</a>
	</div>
	
	<div>
		<a href="<%=request.getContextPath()%>/user/toAdvSearch">Advanced Search</a>
	</div>

	<div>
		<form action="<%=request.getContextPath()%>/user/basicSearch" method="post">
			<input type="text" name="keywords" placeholder="search by usernames"required>
			<input type="submit" value="Search Users">
		</form>
	</div>

	<c:forEach items="${messages}" var="message">
		<div style="margin-top: 40px;">
			<div>${message.id}</div>
			<div
				onclick="javascript:location.href='<%=request.getContextPath()%>/user/userProfile?id=${message.userid}'">
				<img
					src="<%=request.getContextPath()%>/resources/userPhotos/${message.photo}"
					height="42" width="42" /> ${message.username} ${message.time}
			</div>
			<c:if test="${not empty message.image}">
				<div>
					<img
						src="<%=request.getContextPath()%>/resources/messageImgs/${message.message}"
						height="42" width="42" />
				</div>
			</c:if>
			<div>${message.text}</div>
			<div>${message.likes}</div>
			<c:if test="${message.isliked == 0}">
				<a href="<%=request.getContextPath()%>/user/like?id=${message.id}">Like</a>
			</c:if>
			<c:if test="${message.isliked == 1}">
				<a href="<%=request.getContextPath()%>/user/dislike?id=${message.id}">Dislike</a>
			</c:if>
		</div>
	</c:forEach>

</body>
</html>