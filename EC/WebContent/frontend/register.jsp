<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/head.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/bootstrapValidator.min.js"></script>
<script src="../js/my.js" type="text/javascript"></script>
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
					document.getElementById("username").innerHTML="可以注册";
				} else {
					flag=false;
					document.getElementById("username").innerHTML="不可以注册";
				}
			}
		}
	}
	function checkForm() {
		return flag;
	}
</script>
<body  style="background-color: #f4f4f4">
<!--导航栏-->
<div class="navbar navbar-inverse">
    <div class="collapse navbar-collapse">
        <div class="nav navbar-nav navbar-right">

            <li><a href="#">返回登录界面</a></li>
            <li><a href="#">帮助</a></li>
        </div>
    </div>
</div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div class="panel panel-success">
                    <div class="panel-heading" align="center"><p style="font-size: large"><strong>帐号注册</strong></p></div>
                    <div class="panel-body">
                    	<form action="register" method="post">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input class="form-control" type="text" id="username" name="username" placeholder="请输入用户名" onblur=" checkuser(this.value);">
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input class="form-control" type="password" id="password" name="password" placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            <label for="repassword">密码</label>
                            <input class="form-control" type="password" id="repassword" name="repassword" placeholder="请再次输入密码">
                        </div>
                        <div class="form-group">
                            <label for="relname">真实姓名</label>
                            <input class="form-control" type="text" id="relname" name="relname" placeholder="请输入真实姓名">
                        </div>
                        <div class="form-group">
                            <label for="sex">性别</label>
                            <select class="form-control" id="sex" name="sex">
                                <option>请选择性别</option>
                                <option>男</option>
                                <option>女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="birthday">生日</label>
                            <input class="form-control" type="date" id="birthday" name="birthday" placeholder="请输入生日">
                        </div>
                        <div class="form-group">
                            <label for="telephone">电话号码</label>
                            <input class="form-control" type="text" id="telephone" name="telephone" placeholder="请输入电话号码">
                        </div>
                        <div class="form-group">
                            <label for="email">电子邮箱</label>
                            <input class="form-control" type="email" id="email" name="email" placeholder="请输入电子邮箱">
                        </div>

                        <div class="form-group">
                            <label for="postcode">邮编</label>
                            <input class="form-control" type="text" id="postcode" name="postcode" placeholder="请输入邮编">
                        </div>
                        <div class="form-group">
                            <label for="address">地址</label>
                            <input class="form-control" type="text" id="address" name="address" placeholder="请输入地址">
                        </div>
                        <div class="col-lg-5 col-lg-offset-1">
                            <input type="submit" id="subBut" class="btn btn-primary btn-block " value="注册"></button>
                        </div>
                        <div class="col-lg-5">
                            <input type="reset" id="rstBut" class="btn btn-warning btn-block" value="重置"></button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>
</body>
</body>
</html>