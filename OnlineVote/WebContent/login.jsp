<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<link href="css/bootstrapValidator.min.css" rel="stylesheet"
	type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrapValidator.min.js" type="text/javascript"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>

<body style="background: url(img/bgimg.jpg) center">
	<%
		String users = (String) session.getAttribute("users");
		//实现自动登录
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(users)) {
				if (users != null) {
					request.getRequestDispatcher("getVoters").forward(request, response);
				}
			}
		}
	%>
	<div class="container">
		<div class="row">
			<div class="login_y"></div>
			<div class="col-lg-8">
				<div class="jumbotron jumbot">
					<h1>OnlineVoting</h1>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Get Online Votes is a
						supportive and active community for people in contests requiring
						online voting.</p>
					<p>在线投票系统是一个为需要投票的比赛提供支持的社区。</p>
					<p>
						<button class="btn btn-primary">开始使用>></button>
					</p>
				</div>
			</div>
			<form action="loginProcess" method="post">
				<div class="col-lg-4">
					<div class="panel panel-success">
						<div class="panel-heading" align="center">
							<p style="font-size: large">
								<strong>帐号登录</strong>
							</p>
						</div>
						<div class="panel-body">
							<!--  
							<br> <input type="text" class="form-control input_H"
								name="username" placeholder="输入用户名" id="username"> <input
								type="password" class="form-control input_H" name="password"
								placeholder="输入密码" id="password"> <br> <input
								type="checkbox" name="free" value="1">下次自动登录 <br> <br>
							<input type="submit" class="btn btn-primary btn-block input_H"
								value="登录""> <br> <a href="error.jsp"
								class="col-lg-offset-0">登录遇到问题</a> <a href="register.jsp"
								class="col-lg-offset-6">立即注册</a>
                              -->
							<div class="form-group">
								<input type="text" class="form-control input_H" name="username"
									placeholder="输入用户名" />
							</div>
							<div class="form-group">
								<input type="password" class="form-control input_H"
									name="password" placeholder="输入密码" />
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-primary btn-block input_H"
									value="登录"">
							</div>
							<br> <input type="checkbox" name="free" value="1">下次自动登录<br>
							<br> <a href="error.jsp" class="col-lg-offset-0">登录遇到问题</a>
							<a href="register.jsp" class="col-lg-offset-6">立即注册</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>