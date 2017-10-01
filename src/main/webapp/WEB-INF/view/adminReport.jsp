<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div><img src="<%=request.getContextPath()%>/resources/userPhotos/${user.photo}" height="42" width="42"/></div>
		<div>Id: ${user.id}</div>
		<div>Username: ${user.username}</div>
		<div>Email: ${user.email}</div>
		<div>Name: ${user.name}</div>
		<c:if test="${user.gender eq 'm'}"><div>Gender: Male</div></c:if>
		<c:if test="${user.gender eq 'f'}"><div>Gender: Female</div></c:if>
		<div>Birth: ${user.dob}</div>
		<div>Time: ${user.time}</div>
	</div>
	<div>
		<c:forEach items="${messages}" var="message">
			<div>
				<span> MessageID: </span>
				<c:out value="${message.id}"></c:out>
				<span> UserId: </span>
				<c:out value="${message.userid}"></c:out>
				<span> Text: </span>
				<c:out value="${message.text}"></c:out>
				<span> Image: </span>
				<c:out value="${message.image}"></c:out>
				<span> Time: </span>
				<c:out value="${message.time}"></c:out>
			</div>
		</c:forEach>
	</div>
	<div>
		<c:forEach items="${friends}" var="friend">
			<div>
				<span> friendID: </span>
				<c:out value="${friend.id}"></c:out>
				<span> Username: </span>
				<c:out value="${friend.username}"></c:out>
				<span> Name: </span>
				<c:out value="${friend.name}"></c:out>
				<span> They became friends <c:out value="${friend.time}"></c:out> ago </span>
				
			</div>
		</c:forEach>
	</div>
</body>
</html>