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
<title>head</title>
</head>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/head.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/bootstrapValidator.min.js"></script>
<script src="../js/my.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#exit").click(function() {
			bootbox.setDefaults("locale", "zh_CN");
			bootbox.confirm("确认退出系统吗?", function(result) {
				if (result) {
					location.href = "exit.jsp";
				} else {
					return;
				}
			});
		});
	});
</script>
<%
	String name = (String) session.getAttribute("username");
%>
<body style="background-color: #f4f4f4">
	<div class="navbar navbar-inverse">
		<!--#2ea3fd-->
		<ul class="nav navbar-nav">
			<li><a href="<%=path%>/index.jsp">主页<span
					class="label label-danger">New</span></a></li>
			<li><a href="<%=path%>/index.jsp">商城<span
					class="label label-default">New</span></a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">分类 <span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="index.jsp">儿童</a></li>
					<li><a href="index.jsp">教材</a></li>
					<li><a href="index.jsp">文学</a></li>
					<li><a href="index.jsp">名著</a></li>
					<li><a href="index.jsp">生活</a></li>
				</ul></li>

			<li><a href="index.jsp">店铺<span class="label"></span></a></li>
			<li><a href="index.jsp">活动<span class="label"></span></a></li>
			<li><a href="index.jsp">折扣<span class="label"></span></a></li>
		</ul>
		<div class="collapse navbar-collapse">
			<div class="nav navbar-nav navbar-right">
				<%
					if (name != null) {
				%>
				<li><a>欢迎您：<%=name%></a></li>
				<li><a href="shoppingCart.jsp">购物车</a></li>
				<li><a href="userInfo.jsp">我的帐户</a></li>
				<li><a id="exit">退出</a></li>
				<li><a href="error.jsp">帮助</a></li>
				<%
					} else {
				%>
				<li><a data-toggle="modal" data-target="#login">登录</a></li>
				<li><a href="<%=path%>/public/error.jsp">帮助</a></li>
				<%
					}
				%>
			</div>
		</div>
	</div>

	<div class="modal fade" id="login" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog" style="width: 370px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only"></span>
					</button>
					<h5 class="modal-title" id="myModalLabel">用户登录</h5>
				</div>
				<div class="modal-body">
					<form action="login" method="post">
						<div class="form-group">
							<input type="text" name="username" id="username" class="form-control"
								placeholder="请输入用户名" style="height: 40px;"><br>
						</div>
						<div class="form-group">
							<input type="password" name="password" id="password" class="form-control"
								placeholder="请输入密码" style="height: 40px;"><br>
						</div>
						<input type="submit" value="登录" class="btn btn-success btn-block"><br>
						<input type="reset" value="重置" class="btn btn-warning btn-block">
						<br> <input type="checkbox" name="free" value="1">下次自动登录<br>
						<br> <a href="<%=path%>/public/error.jsp"
							class="col-lg-offset-0">登录遇到问题</a> <a
							href="<%=path%>/frontend/register.jsp" class="col-lg-offset-6">立即注册</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>