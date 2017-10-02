<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/page.css">
</head>
<body>
<%@ include file="head.jsp" %>
<c:forEach items="${messages}" var="message">
	<div class="main">
		<div id="out_layer"  class="content">
		
			<div id="top_layer">
				<div id="top_image">
				 	<div onclick="javascript:location.href='<%=request.getContextPath()%>/user/userProfile?id=${message.userid}'">
					<img src="<%=request.getContextPath()%>/resources/userPhotos/${message.photo}" height="120px" width="120px" />
					</div>
				</div>
				<span id="top_info">
                			<p style="padding-left:10%; padding-top: 20px;"> ${message.username}</p>
                			<p style="padding-left:10%; padding-top: 20px;"> ${message.time}</p>
            		</span>
			</div>
			
			<c:if test="${not empty message.image}">
				<div id="middle_layer">
					<img src="<%=request.getContextPath()%>/resources/messageImgs/${message.image}" height="42" width="42" />
				</div>
			</c:if>
			
			<div id="text_layer">
				<div>${message.text}</div>
        		</div>
			
			<div id="like_layer">
			<c:if test="${message.isliked == 0}">
				<a href="<%=request.getContextPath()%>/user/like?id=${message.id}">
					<div class="heart" id="like3" rel="like"></div>Like
				</a>
				<div class="likeCount" id="likeCount3" style="padding-left:42px; padding-top: 16px;"> ${message.likes}</div>
				
			</c:if>
			<c:if test="${message.isliked == 1}">
				<a href="<%=request.getContextPath()%>/user/dislike?id=${message.id}">
					<div class="heart" id="like3" rel="like"></div>Dislike
				</a>
				<div class="likeCount" id="likeCount3" style="padding-left:42px; padding-top: 16px;"> ${message.likes}</div>
			</c:if>
			</div>
			
		</div>
	</div>
</c:forEach>

</body>
</html>