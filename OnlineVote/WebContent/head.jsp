<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String name = (String)session.getAttribute("users");
%>
<body style="background: url(img/bgimg.jpg) center">
	<div class="navbar navbar-inverse">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target="x">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="javascript:location.reload();" class="navbar-brand">OnlineVoting</a>
		</div>
		<div class="collapse navbar-collapse">
			<div class="nav navbar-nav navbar-right">
				<%
					if (name != null) {
				%>
				<li><a>欢迎您：<%=name%></a></li>
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