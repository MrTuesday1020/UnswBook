<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Graph</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/vis.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/graph.css">
<script src="<%=request.getContextPath()%>/resources/js/vis.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	$.get('<%=request.getContextPath()%>/user/showGraph', {}, function(data) {
		var obj = JSON.parse(data);
		var graph = {
			nodes : obj.nodes,
			edges : obj.edges
		};
		var options = {};
		var container = document.getElementById("graph");
		var network = new vis.Network(container, graph, options);
	});

	function search() {
		var keyword = $('#keyword').val();
		var selection = $('#selection').val();
		if(keyword == ''){
			alert("Keyword can not be empty!");
		}
		else{
				$.get('<%=request.getContextPath()%>/user/showGraph', {keyword:keyword,selection:selection}, function(data) {
				var obj = JSON.parse(data);
				var graph = {
					nodes : obj.nodes,
					edges : obj.edges
				};
				var options = {};
				var container = document.getElementById("graph");
				var network = new vis.Network(container, graph, options);
			});
		}
	}
</script>
</head>
<body>
	<%@ include file="head.jsp"%>

	<input type="text" id="keyword" name="keyword"
		placeholder="search for ..." required>
	<select id="selection">
		<option value="people">People</option>
		<option value="message">Message</option>
	</select>
	<input type="submit" value="search" onclick="search()" />

	<div id="graph"></div>

</body>
</html>