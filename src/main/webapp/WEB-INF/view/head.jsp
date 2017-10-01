<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">
 <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
</head>
<div class="header">
    <%--<font size="100">UNSW BOOK</font>--%>
    <div class="block">
        <a href="page.jsp">
            UNSWBOOK
        </a>
    </div>
    <a size="" class="button" href='search.jsp'style="padding-right:30px;" >
        <img src="image/find.png" width="60" height="50" alt="find">
    </a>
    <a class="button" href='notification.jsp' style="padding-right:10px;" >
        <img src="image/notification.png" width="70" height="50" alt="notification">
    </a>
    <a class="button" href='profile.jsp'  style="padding-right:10px; ">
        <img src="image/profile.png" alt="profile">
    </a>
    <!-- hidden input tag to identify this form action as search -->
    <input  type="hidden" name="action"  value="search"> </input>
    <input class="search" type="text" name="content" size="20" style="padding-left:5px;"  placeholder = "Search"> </input>
    <%--<input type="submit" value="search" class="searchbutton"></input>--%>
</div>
</body>
</html>