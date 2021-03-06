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
<title>Success</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="/common/head.jsp"></jsp:include>
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
                    <p>您的帐号是:<%=request.getAttribute("registername") %></p>
                </div>
                <a href="<%=basePath %>index.jsp" class="btn btn-success">立即登录</a>
                <br><br><br>
            </div>
        </div>
    </div>
</div>
</body>
</html>