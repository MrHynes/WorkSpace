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
<title>登录</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/bg.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
</head>
<body style="background-color: #E2E2E2">
<div class="container">
	<div style="height: 120px;"></div>
	<div class="col-lg-4"></div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
		<div class="panel-heading" align="center">
			<strong>管理员登录</strong>
		</div>
		<div class="panel-body">
			<form action="admlogin" method="post">
				<div class="form-group">
					<input type="text" name="username" id="username" class="form-control" placeholder="请输入帐号" style="height: 40px;"><br>
				</div>
				<div class="form-group">
					<input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" style="height: 40px;"><br>
				</div>
				<input type="submit" value="登录" class="btn btn-success btn-block"><br>
				<input type="reset" value="重置" class="btn btn-warning btn-block">
				<br> 
				<input type="checkbox" name="free" value="1">下次自动登录<br>
				<br> <a href="../common/error.jsp" class="col-lg-offset-0">登录遇到问题</a>
				<a href="../index.jsp" class="col-lg-offset-6">回到主页面</a>
			</form>
		</div>
	</div>
	</div>
	<div class="col-lg-4"></div>
</div>
</body> 
<!-- <body style="background-color: #E2E2E2;">
	<div class="container">
		<div class="row text-center " style="padding-top: 100px;">
			<div class="col-md-12">
				<img src="assets/img/logo-invoice.png" />
			</div>
		</div>
		<div class="row">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel-body">
					<form role="form">
						<hr />
						<h5></h5>
						<br />
						<div class="form-group input-group">
							<span class="input-group-addon"><i class="fa fa-tag"></i></span>
							<input type="text" class="form-control"
								placeholder="Your Username " />
						</div>
						<div class="form-group input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<input type="password" class="form-control"
								placeholder="Your Password" />
						</div>
						<div class="form-group">
							<label class="checkbox-inline"> <input type="checkbox" />
								记住密码
							</label> <span class="pull-right"> <a href="index.html">Forget
									password ? </a>
							</span>
						</div>

						<a href="index.html" class="btn btn-primary ">登录系统</a>
						<hr />
					</form>
				</div>
			</div>
		</div>
	</div>
</body> -->
</html>