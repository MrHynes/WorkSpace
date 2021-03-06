<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/head.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/bootstrapValidator.min.js"></script>
<script src="../js/my.js" type="text/javascript"></script>
</head>
<body style="background-color: #f4f4f4">
<div class="container">
	<div style="height: 120px;"></div>
	<div class="col-lg-4"></div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
		<div class="panel-heading" align="center">
			<strong>用户登录</strong>
		</div>
		<div class="panel-body">
			<form action="login" method="post">
				<div class="form-group">
					<input type="text" name="user" id="user" class="form-control" placeholder="请输入用户名" style="height: 40px;"><br>
				</div>
				<div class="form-group">
					<input type="password" name="pwd" id="pwd" class="form-control" placeholder="请输入密码" style="height: 40px;"><br>
				</div>
				<input type="submit" value="登录" class="btn btn-success btn-block"><br>
				<input type="reset" value="重置" class="btn btn-warning btn-block">
				<br> 
				<input type="checkbox" name="free" value="1">下次自动登录<br>
				<br> <a href="../public/error.jsp" class="col-lg-offset-0">登录遇到问题</a>
				<a href="register.jsp" class="col-lg-offset-6">立即注册</a>
			</form>
		</div>
	</div>
	</div>
	<div class="col-lg-4"></div>
</div>
</body>
</html>