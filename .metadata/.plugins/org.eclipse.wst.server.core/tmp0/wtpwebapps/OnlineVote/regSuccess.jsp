<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<body style="background:url(img/bgimg.jpg) center">
<div class="navbar navbar-inverse">
    <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="x" >
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="javascript:location.reload();" class="navbar-brand">OnlineVoting</a>
    </div>
    <div class="collapse navbar-collapse">
            <div class="nav navbar-nav navbar-right">
                <li><a href="login.jsp">登录</a></li>
                <li><a href="error.jsp">帮助</a></li>
            </div>
    </div>
</div>
<div class="container">
    <div class="col-lg-12" align="center">
        <div class="col-lg-12 login_y"></div>
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <div class="panel panel-success">
                <div class="panel-heading">&nbsp;</div>
                <div class="panel-body">
                    <label style="font-size: 50px;color:#4cae4c"><span class="glyphicon glyphicon-ok-circle"></span></label>
                    <p>恭喜您！注册成功！</p>
                    <p>您的帐号是:<%=request.getAttribute("name") %></p>
                </div>
                <a href="login.jsp" class="btn btn-success">立即登录</a>
                <br><br><br>
            </div>
        </div>
    </div>
</div>
</body>
</html>