<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/font-awesome.css" rel="stylesheet" />
<link href="<%=basePath%>css/basic.css" rel="stylesheet" />
<link href="<%=basePath%>css/custom.css" rel="stylesheet" />
<script src="<%=basePath%>js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<script src="<%=basePath%>js/jquery.metisMenu.js"></script>
<script src="<%=basePath%>js/custom.js"></script>
<script src="<%=basePath%>js/backend.js"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
</head>
<body>
<div id="wrapper">
<jsp:include page="menue.jsp"></jsp:include>
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="tab-content">
					<div class="col-md-12">
						<h1 class="page-head-line">系统用户管理</h1>
						<h1 class="page-subhead-line"></h1>		
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-lg-12" style="background-color: black; height: 60px; text-align: center; color: white; line-height: 60px;">
		Copyright ©2017, 程祺004 All rights reserved.</div>
</body>
</html>