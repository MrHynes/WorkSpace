<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
	var xhr;
	var flag;
	function createXHR() {
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else {
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
	}

	function checkuser(user) {
		createXHR();
		xhr.open("GET", "process?user=" + user);
		xhr.onreadystatechange = checkuserCalBack;
		xhr.send(null);
	}
	function checkuserCalBack() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var text = xhr.responseText;
				if (text == "true") {
					flag = true;
					document.getElementById("text").innerHTML="可以注册";
				} else {
					flag=false;
					document.getElementById("text").innerHTML="不可以注册";
				}
			}
		}
	}
	function checkForm() {
		return flag;
	}
</script>
<body style="background-color: #f4f4f4">
	<div class="container">
		<div style="height: 30px;"></div>
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<div class="panel panel-success">
				<div class="panel-heading" align="center">
					<strong>注 册</strong>
				</div>
				<div class="panel-body">
					<form action="register" method="post" onsubmit="return checkForm()">
						<table class="table table-hover">
							<tr>
								<td>用户名</td>
								<td>
									<div class="form-group">
										<input type="text" name="user" class="form-control"
											onblur="checkuser(this.value)">
									</div>
								</td>
								<td><span id="text"></span></td>
							</tr>
							<tr>
								<td>密码</td>
								<td><div class="form-group">
										<input type="password" name="pwd" class="form-control">
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>密码</td>
								<td><div class="form-group">
										<input type="password" name="pwd2" class="form-control">
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>真实姓名</td>
								<td><div class="form-group">
										<input type="text" name="name" class="form-control">
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>性别</td>
								<td><input type="radio" name="sex" value="nan">男 <input
									type="radio" name="sex" value="nv">女</td>
								<td></td>
							</tr>
							<tr>
								<td>生日</td>
								<td><input type="text" name="birth" class="form-control"></td>
								<td></td>
							</tr>
							<tr>
								<td>电子邮箱</td>
								<td><div class="form-group">
										<input type="text" name="email" class="form-control">
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>手机</td>
								<td><div class="form-group">
										<input type="text" name="phone" class="form-control">
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>地址</td>
								<td><div class="form-group">
										<input type="text" name="address" class="form-control">
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>邮编</td>
								<td><div class="form-group">
										<input type="text" name="code" class="form-control">
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td><input type="submit" value="提交" class="btn btn-primary"></td>
								<td><input type="reset" name="重置" class="btn btn-success"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div style="height: 120px;"></div>
</body>
</html>