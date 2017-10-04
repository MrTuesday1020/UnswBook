<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/index.css">
</head>
<body>
	<%@ include file="head.jsp"%>
	<c:forEach items="${messages}" var="message">
		<div class="message">
			<div class="top">
				<div class="photo"
					onclick="javascript:location.href='<%=request.getContextPath()%>/user/userProfile?id=${message.userid}'">
					<img
						src="<%=request.getContextPath()%>/resources/userPhotos/${message.photo}">
				</div>
				<div class="info">
					<p
						onclick="javascript:location.href='<%=request.getContextPath()%>/user/userProfile?id=${message.userid}'">${message.username}</p>
					<p style="font-size:80%">${message.time} ago</p>
				</div>
			</div>

			<c:if test="${not empty message.image}">
				<div class="image">
					<img
						src="<%=request.getContextPath()%>/resources/messageImgs/${message.image}">
				</div>
			</c:if>

			<c:if test="${not empty message.text}">
				<div class="text">
					<p>${message.text}</p>
				</div>
			</c:if>

			<div class="like">
				<c:if test="${message.isliked == 1}">
					<div class="image"
						onclick="javascript:location.href='<%=request.getContextPath()%>/user/dislike?id=${message.id}'">
						<img src="<%=request.getContextPath()%>/resources/images/dislike.jpeg">
					</div>
				</c:if>
				<c:if test="${message.isliked == 0}">
					<div class="image"
						onclick="javascript:location.href='<%=request.getContextPath()%>/user/like?id=${message.id}'">
						<img src="<%=request.getContextPath()%>/resources/images/like.jpeg">
					</div>
				</c:if>
				<c:if test="${message.likes == 0}">
					<div class="number">${message.likes} like</div>
				</c:if>
				<c:if test="${message.likes == 1}">
					<div class="number">${message.likes} like</div>
				</c:if>
				<c:if test="${message.likes != 1 and message.likes != 0}">
					<div class="number">${message.likes} likes</div>
				</c:if>
			</div>
		</div>
	</c:forEach>
</body>
</html>