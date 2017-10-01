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
		Message Notice:
		<c:forEach items="${messageNotices}" var="messageNotice">
			<div>
				<div>${messageNotice.username} liked ur message: ${messageNotice.messagetext}</div>
			</div>
		</c:forEach>
	</div>

	<div style="margin-top: 40px;">
		Friend Request:
		<c:forEach items="${friendNotices}" var="friendNotice">
			<div>
				<div>${friendNotice.username} wants to add you!<a href="<%=request.getContextPath()%>/user/confirmFriend?id=${friendNotice.id}">Confirm</a></div>
		</c:forEach>
	</div>

</body>
</html>