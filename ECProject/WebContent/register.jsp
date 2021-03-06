<%@page import="java.nio.file.Path"%>
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
<title>注册</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/bg.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
</head>

<body>
	<!--导航栏-->
	<jsp:include page="common/head.jsp"></jsp:include>
	<div style="height: 35px;"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-8">
					<div class="panel">
						<div class="panel-body">
							<legend>
								<label><span class="glyphicon glyphicon-hand-right"></span>&nbsp;注册帐号</label>
							</legend>
							<div class="col-lg-12">
								<div class="col-lg-1"></div>
								<div class="col-lg-10">
									<form action="<%=basePath%>register" method="post">
											<div class="form-group">
												<label for="username">用户名</label> <input
													class="form-control" type="text" id="username"
													name="username" placeholder="请输入用户名"
													onblur="checkuser(this.value)">
												<div id="text" style="color: #A94442; font-size: 10px;"></div>
											</div>
											<div class="form-group">
												<label for="password">密码</label> <input class="form-control"
													type="password" id="password" name="password"
													placeholder="请输入密码">
											</div>
											<div class="form-group">
												<label for="repassword">密码</label> <input
													class="form-control" type="password" id="repassword"
													name="repassword" placeholder="请再次输入密码">
											</div>
											<div class="form-group">
												<label for="relname">真实姓名</label> <input
													class="form-control" type="text" id="relname"
													name="relname" placeholder="请输入真实姓名">
											</div>
											<div class="form-group">
												<label for="sex">性别</label> <select class="form-control"
													id="sex" name="sex">
													<option>请选择性别</option>
													<option value="男">男</option>
													<option value="女">女</option>
												</select>
											</div>
											<div class="form-group">
												<label for="birthday">生日</label> <input class="form-control"
													type="date" id="birthday" name="birthday"
													placeholder="请输入生日">
											</div>
											<div class="form-group">
												<label for="telephone">电话号码</label> <input
													class="form-control" type="text" id="telephone"
													name="telephone" placeholder="请输入电话号码">
											</div>
											<div class="form-group">
												<label for="email">电子邮箱</label> <input class="form-control"
													type="email" id="email" name="email" placeholder="请输入电子邮箱">
											</div>

											<div class="form-group">
												<label for="postcode">邮编</label> <input class="form-control"
													type="text" id="postcode" name="postcode"
													placeholder="请输入邮编">
											</div>
											<div class="form-group">
												<label for="address">地址</label> <input class="form-control"
													type="text" id="address" name="address" placeholder="请输入地址">
											</div>
											<div class="col-lg-5 col-lg-offset-1">
												<input type="submit" id="subBut"
													class="btn btn-primary btn-block " value="注册">
												</button>
											</div>
											<div class="col-lg-5">
												<input type="reset" id="rstBut"
													class="btn btn-warning btn-block" value="重置">
												</button>
											</div>
										</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="panel">
						<div class="panel-body">
							<legend>
								<label>&nbsp;社区</label>
							</legend>
							<a style="color: gray;">QQ群：123456789</a><br>
							<br> <span class="glyphicon glyphicon-globe"></span>&nbsp;<a
								href="#" style="color: red;">问答社区</a>
						</div>
					</div>
					<div class="panel">
						<div class="panel-body">
							<legend>
								<label>&nbsp;下载</label>
							</legend>
							<button class="btn btn-success btn-block" style="height: 40px;">会员操作手册下载</button><br>
							<button class="btn btn-warning btn-block" style="height: 40px;">管理员操作手册下载</button>
							<br>
						</div>
					</div>

					<div class="panel">
						<div class="panel-body" style="height: 300px;">
							<legend>
								<label>&nbsp;新鲜事</label>
								
							</legend>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>
	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</body>
</html>