<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<body  style="background-color: #f4f4f4">
<%
String name=(String)session.getAttribute("username");
if(name==null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
}

%>
<!--导航栏 2-->
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="col-lg-12">
                <div class="panel panel-success">
                    <div class="panel-heading">购物车</div>
                    <div class="panel-body">
                        panel-body
                    </div>
                    <div class="panel-footer">panel-footer</div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--foot-->
<div class="foot col-lg-12" style="position: fixed; bottom: 0px;">
    Copyright ©2017, 程祺004 All rights reserved.
</div>
</body>
</html>