<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>

<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<title>Post</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
</head>
<body>
<%@ include file="head.jsp" %>	
<div class="main">
 <div id="out_layer" class="position">
  <div id="change_layer">
   <form name="postMessage"
			action="<%=request.getContextPath()%>/user/postMessage" method="post" enctype="multipart/form-data">
	<div id="image_layer" style="height:160px; width:160px">
	 <img id="blah" src="#" height="160px" width="160px"/>
	</div>
	<input type='file' id="left" style="left:10px;top:200px;font-size:16px" onchange="readURL(this);" name="image"/>
	<p></p>
	<input type="submit" id="left" style="left:10px;font-size:14px;top:20px" class="signbutton" value="Post" />
	<textarea rows="5" cols="40" class="text" type="text" id="text" name="text" style="margin-left:10%;width:50%;height:200px" placeholder="text" required></textarea>
   </form>
  </div>
 </div>
</div>
</body>
</html>