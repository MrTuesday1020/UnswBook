<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">
</head>
<div class="header">
    <%--<font size="100">UNSW BOOK</font>--%>
    <div class="block">
    		<a href="<%=request.getContextPath()%>/user/index">UNSWBOOK</a>
    </div>
    <a size="" class="button" href="<%=request.getContextPath()%>/user/toAdvSearch" style="padding-right:30px;" >
        <img class="image" src="<%=request.getContextPath()%>/resources/images/search.jpeg" >
    </a>
    <a class="button" href="<%=request.getContextPath()%>/user/notice" style="padding-right:10px;" >
        <img class="image" src="<%=request.getContextPath()%>/resources/images/notice.jpeg">
    </a>
    <a class="button" href="<%=request.getContextPath()%>/user/profile" style="padding-right:10px">
        <img class="image" src="<%=request.getContextPath()%>/resources/images/user.jpeg">
    </a>
    <a class="button" href="<%=request.getContextPath()%>/user/post" style="padding-right:10px">
    		 <img class="image" src="<%=request.getContextPath()%>/resources/images/post.png">
    	</a>
    
	<form action="<%=request.getContextPath()%>/user/basicSearch" method="post">
	    <!-- hidden input tag to identify this form action as search -->
		<!-- <input  type="hidden" name="action"  value="search"> </input> -->
		<input class="search" type="text" name="keywords" size="20" placeholder="search by username" required>
	</form>
</div>
</body>
</html>