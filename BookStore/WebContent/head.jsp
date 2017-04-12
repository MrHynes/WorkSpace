<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>head</title>
</head>
<%
	String name = (String) session.getAttribute("username");
%>
<body style="background-color: #f4f4f4">
	<div class="navbar navbar-inverse">
		<!--#2ea3fd-->
		<ul class="nav navbar-nav">
			<li><a href="#">主页<span class="label label-danger">New</span></a></li>
			<li><a href="#">商城<span class="label label-default">New</span></a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">分类 <span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">儿童</a></li>
					<li><a href="#">教材</a></li>
					<li><a href="#">文学</a></li>
					<li><a href="#">名著</a></li>
					<li><a href="#">生活</a></li>
				</ul></li>

			<li><a href="#">店铺<span class="label"></span></a></li>
			<li><a href="#">活动<span class="label"></span></a></li>
			<li><a href="#">折扣<span class="label"></span></a></li>
		</ul>
		<div class="collapse navbar-collapse">
			<div class="nav navbar-nav navbar-right">
				<%
					if (name != null) {
				%>
				<li><a>欢迎您：<%=name %></a></li>
				<li><a href="shoppingChat.jsp">购物车</a></li>
				<li><a href="#">我的帐户</a></li>
				<li><a href="exit.jsp">退出</a></li>
				<li><a href="error.jsp">帮助</a></li>
				<%
					} else {
				%>
				<li><a href="login.jsp">登录</a></li>
				<li><a href="error.jsp">帮助</a></li>
				<%
					}
				%>
			</div>
		</div>
	</div>

</body>
</html>