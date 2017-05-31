<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrapValidator.min.js" type="text/javascript"></script>
<script src="js/my2.js"></script>
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
                    <input type="checkbox" name="free" value="1">下次自动登录
                    <a href="../common/error.jsp" class="col-lg-offset-5">登录遇到问题</a>
                    <!--<a href="../index.jsp" class="col-lg-offset-6">回到主页面</a>-->
                </form>
            </div>
        </div>
    </div>
    <div class="col-lg-4"></div>
</div>
</body>
</html>