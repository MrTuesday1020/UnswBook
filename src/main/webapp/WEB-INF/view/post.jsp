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
<title>Insert title here</title>
</head>
<body>

<form name="postMessage"
			action="<%=request.getContextPath()%>/user/postMessage" method="post" enctype="multipart/form-data">
			<input class="text" type="text" id="text" name="text"
				placeholder="text" >
			<p></p>
			
			<input type='file' onchange="readURL(this);" name="image"/>
    			<img id="blah" src="#" alt="your image" height="42" width="42"/>
			<input type="submit" value="Post" />
		</form>

</body>
</html>