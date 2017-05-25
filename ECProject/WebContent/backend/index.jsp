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
<title>后台管理</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/font-awesome.css" rel="stylesheet" />
<link href="<%=basePath%>css/basic.css" rel="stylesheet" />
<link href="<%=basePath%>css/custom.css" rel="stylesheet" />
<script src="<%=basePath%>js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<script src="<%=basePath%>js/jquery.metisMenu.js"></script>
<script src="<%=basePath%>js/custom.js"></script>
<script type="text/javascript">
	$(function() {
		$("#exit").click(function() {
			//http://www.weixuehao.com/archives/415 中文
			bootbox.confirm({
				size : "small",
				message : "确认退出系统吗?",
				callback : function(result) {
					if (result) {
						location.href = "/ECProject/backend/login.jsp";
					} else {
						return;
					}
				}
			});
		});
		$("#exit2").click(function() {
			bootbox.confirm({
				size : "small",
				message : "确认退出系统吗?",
				callback : function(result) {
					if (result) {
						location.href = "/ECProject/backend/login.jsp";
					} else {
						return;
					}
				}
			});
		});
	
	
	var i=0;
	
		$("#showInfo").click(function() {
				$("#username").attr("disabled",true);
				$("select").attr("disabled", true);
				$("#relname").attr("disabled", true);
				$("#birthday").attr("disabled", true);
				$("#telephone").attr("disabled", true);
				$("#email").attr("disabled", true);
				$("#postcode").attr("disabled", true);
				$("#address").attr("disabled", true);
			$("#alter").remove();
			i=0;
		});
		$("#alterInfo").click(function() {
			if(i==0){
				$("input").removeAttr("disabled");
				$("select").removeAttr("disabled");
				var info = $("<div id='alter'><br><div class='col-lg-5 col-lg-offset-1'><input type='submit' id='btnsubmit' class='btn btn-primary btn-block'></input></div>"
					+ "<div class='col-lg-5'><input type='reset' id='btnreset' class='btn btn-warning btn-block'></input></div></div>");
				$("#addressDiv").append(info);
				i++;
			}
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0px;;background-color:#00C979;">
		<div class="navbar-header">
			<a class="navbar-brand" href="" style="color: white;">在线购物系统后台管理</a>
		</div>
		<div class="header-right">
			<a class="btn btn-danger" title="New Task"><b id="exit">退出系统</b><i
				class="fa fa-sign-in "></i></a>
		</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li>
					<div class="user-img-div">
						<img src="../simg/9787894204622.jpg" class="img-thumbnail" /></br>
						<div class="inner-text">管理员姓名：${sessionScope.adminName }</div>
					</div>
				</li>
				<li><a class="active-menu" href="index.html"><i
						class="fa fa-dashboard "></i>商品管理 <span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#A" data-toggle="tab"><i
								class="fa fa-toggle-on"></i>商品类别管理</a></li>
						<li><a href="#B" data-toggle="tab"><i class="fa fa-bell "></i>商品信息管理</a>
						</li>
					</ul></li>
				<li><a href="#"><i class="fa fa-desktop "></i>用户管理 <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#C" data-toggle="tab"><i
								class="fa fa-circle-o "></i>注册用户管理</a></li>
						<li><a href="#D" data-toggle="tab"><i class="fa fa-code "></i>系统用户管理</a>
						</li>
					</ul></li>
				<li><a href="#"><i class="fa fa-yelp "></i>个人资料管理 <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#E" data-toggle="tab" id="showInfo"><i
								class="fa fa-coffee"></i>显示个人资料</a></li>
						<li><a href="#E" data-toggle="tab" id="alterInfo"><i
								class="fa fa-flash "></i>个人资料修改</a></li>
						<li><a href="#G" data-toggle="tab"><i class="fa fa-key "></i>密码修改</a>
						</li>
					</ul></li>
				<li><a href=""><i class="fa fa-flash "></i>订单管理 <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#H" data-toggle="tab"><i
								class="fa fa-recycle "></i>订单管理</a></li>
					</ul></li>
				<li><a id="exit2"><i class="fa fa-sign-in "></i>退出系统 <span
						class="fa arrow"></span></a></li>
			</ul>
		</div>
		</nav>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">商品管理</h1>
						<h1 class="page-subhead-line">This is dummy text , you can
							replace it with your original text.</h1>
					</div>
					<div class="tab-content">
						<!-- 商品类别管理 -->
						<div class="tab-pane active fade in" id="A">商品类别管理</div>
						<!-- 商品信息管理 -->
						<div class="tab-pane" id="B">商品信息管理</div>
						<div class="tab-pane" id="C">注册用户管理</div>
						<div class="tab-pane" id="D">系统用户管理</div>
						<!-- 显示个人资料 -->
						<div class="tab-pane" id="E">
							<div class="col-lg-2"></div>
							<div class="col-lg-8">
								<form action="" method="post">
									<div class="form-group">
										<label for="username">用户名</label> <input class="form-control"
											type="text" id="username" name="username" disabled="disabled"
											value="" onblur="checkuser(this.value)">
										<div id="updatetext" style="color: #A94442; font-size: 10px;"></div>
									</div>
									<div class="form-group">
										<label for="relname">真实姓名</label> <input class="form-control"
											type="text" id="relname" name="relname" value=""
											disabled="disabled">
									</div>
									<div class="form-group">
										<label for="sex">性别</label> <select class="form-control"
											id="sex" name="sex" disabled="disabled">
											<%-- <%
													if ("男".equals(userBean.getSex())) {
												%> --%>
											<option value="男" selected="selected">男</option>
											<option value="女">女</option>
											<%-- <%
													} else {
												%>
												<option value="男">男</option>
												<option value="女" selected="selected">女</option>
												<%
													}
												%> --%>
										</select>
									</div>
									<div class="form-group">
										<label for="birthday">生日</label> <input class="form-control"
											type="text" id="birthday" name="birthday" value=""
											disabled="disabled">
									</div>
									<div class="form-group">
										<label for="telephone">电话号码</label> <input
											class="form-control" type="text" id="telephone"
											name="telephone" value="" disabled="disabled">
									</div>
									<div class="form-group">
										<label for="email">电子邮箱</label> <input class="form-control"
											type="email" id="email" name="email" value=""
											disabled="disabled">
									</div>

									<div class="form-group">
										<label for="postcode">邮编</label> <input class="form-control"
											type="text" id="postcode" name="postcode" value=""
											disabled="disabled">
									</div>
									<div class="form-group" id="addressDiv">
										<label for="address">地址</label> <input class="form-control"
											type="text" id="address" name="address" value=""
											disabled="disabled">
									</div>
								</form>
							</div>
							<div class="col-lg-2"></div>
						</div>
						<!-- 个人资料修改*(无用代码) -->
						<div class="tab-pane" id="">个人资料修改</div>
						<!-- 密码修改 -->
						<div class="tab-pane" id="G">
							<div class="col-lg-2"></div>
								<div class="col-lg-8" style="height: 400px;">
									<br>
									<form action="" method="post">
										<div class="form-group">
											<label for="oldpassword">旧密码</label> 
											<input type="password" name="oldpassword" id="oldpassword" class="form-control" placeholder="请输入旧密码"
												style="height: 40px;"><br>
										</div>
										<div class="form-group">
											<label for="password">新密码</label> 
											<input type="password" name="password" id="password" class="form-control" placeholder="请输入密码"
												style="height: 40px;"><br>
										</div>
										<div class="form-group">
											<label for="repassword">新密码</label> 
											<input type="password" name="repassword" id="repassword" class="form-control" placeholder="请再次输入新密码"
												style="height: 40px;"><br>
										</div>
										<br>
										<div class='col-lg-5 col-lg-offset-1'><input type='submit' id='btnsubmit' class='btn btn-primary btn-block'></input></div>
										<div class='col-lg-5'><input type='reset' id='btnreset' class='btn btn-warning btn-block'></input></div>
									</form>
								</div>
						</div>
						<div class="tab-pane" id="H">订单管理</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>