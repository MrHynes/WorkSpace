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
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="col-lg-12" align="center">
        <div class="col-lg-12 login_y"></div>
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <div class="panel panel-success">
                <div class="panel-heading">&nbsp;</div>
                <div class="panel-body">
                    <label style="font-size: 50px;color:#4cae4c"><span class="glyphicon glyphicon-ok-circle"></span></label>
                    
                    <p>对不起，距离上次投票时间少于10s，不允许投票</p>
                    <p>3秒后，将自动跳转回主页面。如果不能跳转，请</p>
                    <%
                    	response.setHeader("refresh", "3;url=getVoters");
                    %>
                </div>
                 <a href="getVoters" class="btn btn-success">点击这里</a>
                <br><br><br>
            </div>
        </div>
    </div>
</div>
</body>
</html>