<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<br><br><br><br><br>
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<form action="registerProcess" method="post">
					<div class="panel panel-success">
						<div class="panel-heading" align="center">
							<p style="font-size: large">
								<strong>帐号注册</strong>
							</p>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="txtUserName2">用户名</label> <input
									class="form-control" type="text" id="txtUserName2"
									placeholder="请输入用户名" name="rusername">
							</div>
							<div class="form-group">
								<label for="txtPassWord2">密码</label> <input class="form-control"
									type="password" id="txtPassWord2" placeholder="请输入用密码"
									name="rpassword">
							</div>
							<div class="form-group">
								<label for="txtPassWord3">密码</label> <input class="form-control"
									type="password" id="txtPassWord3" placeholder="请重新输入用密码"
									name="rpassword2">
							</div>
							<div class="col-lg-5 col-lg-offset-1">
								<input type="submit" class="btn btn-primary btn-block "
									value="注册" onclick="checkform()">
								</button>
							</div>
							<div class="col-lg-5">
								<input type="reset" class="btn btn-warning btn-block" value="重置" onclick="reset()">
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>
</body>
</html>