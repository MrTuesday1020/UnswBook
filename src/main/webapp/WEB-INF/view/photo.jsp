<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/profile.css">
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<title>Change Photo</title>

</head>
<body>
<%@ include file="head.jsp" %>
<div class="main">
	<div id="out_layer" class="position">
		<div id="change_layer">
			<form action="<%=request.getContextPath()%>/user/uploadPhoto" enctype="multipart/form-data" method="post" >
				<div id="image_layer">
					<img id="blah" src="#" height="380px" width="380px"/>
				</div>
				<input type='file' id="left" style="left:400px;top:100px;font-size:16px" onchange="readURL(this);" name="photo" required/>
				<p></p>
				<input type="submit" id="left" style="left:420px;font-size:14px" class="signbutton" value="Submit" />
			</form>
        	</div>
	</div>
</div>
</body>
</html>