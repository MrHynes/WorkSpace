<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BootStrap*JSP开发案例</title>
<meta name="viewport" content="midth=device-width,inital-scale=1">
<%--bootstrap基于jquery，所有要先导入jquery --%>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form action="check" id="loginForm" method="post" class="form-horizontal">
		<fieldset>
			<legend><label><span class="glyphicon glyphicon-user"></span>&nbsp;用户登录</label></legend>
			<%--输入用户名 --%>
			<div class="form-group">
				<label class="col-md-3 control-label" for="mid">用户名：</label>
				<div class="col-md-5">
					<%--id是为js服务的，name是为jsp接收数据服务的，一般要求name和id保持一致 --%>
					<input type="text" name="mid" id="mid" class="form-control" placeholder="请输入登录名">
				</div>
				<div class="col-md-4"></div>
			</div>
			<%--输入密码 --%>
			<div class="form-group">
				<label class="col-md-3 control-label" for="password">密码：</label>
				<div class="col-md-5">
					<%--id是为js服务的，name是为jsp接收数据服务的，一般要求name和id保持一致 --%>
					<input type="password" name="password" id="password" class="form-control" placeholder="请输入登录密码">
				</div>
				<div class="col-md-4"></div>
			</div>
			<%--登录,重置按钮 --%>
			<div class="form-group">
				<div class="col-md-5 col-md-offset-3">
					<button type="submit" id="subBut" class="btn btn-xs btn-primary">登录</button>
					<button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
				</div>
				<div class="col-md-4"></div>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>