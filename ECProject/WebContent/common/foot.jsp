<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>foot</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
</head>
<body>
	<div class="col-lg-12" style="background-color: black; height: 60px; text-align: center; color: white; line-height: 60px;">
		Copyright ©2017, 程祺004 All rights reserved.</div>
</body>
</html>