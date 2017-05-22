<%@page import="pers.qiqcheng.ec.bean.UserBean"%>
<%@page import="pers.qiqcheng.ec.bean.CartItemBean"%>
<%@page import="java.util.List"%>
<%@page import="pers.qiqcheng.ec.bean.CartBean"%>
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
<title>会员中心</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
	var i=0;
	$(function() {
		$("#showInfo").click(function() {
				$("#username").attr("disable",true);
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

	var xhr;
	var flag;
	function createXHR() {
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else {
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
	}

	function checkuser(username) {
		createXHR();
		xhr.open("GET", "/ECProject/isExist?username=" + username);
		xhr.onreadystatechange = checkuserCalBack;
		xhr.send(null);
	};
	function checkuserCalBack() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var text = xhr.responseText;
				if (text == "true") {
					flag = true;
					//document.getElementById("text").innerHTML = "可以注册";
					document.getElementById("updatetext").innerHTML = "可以修改成此帐号";
				} else {
					flag = false;
					//document.getElementById("text").innerHTML = "不可以注册";
					document.getElementById("updatetext").innerHTML = "已经有其他用户使用此帐号，请换一个";
				}
			}
		}
	};
	function checkForm() {
		return flag;
	};
</script>
<body>
	<!-- 导航 -->
	<jsp:include page="/common/head.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-user"></span>&nbsp;<strong>会员中心</strong>
					</div>
					<div class="panel-body">
						<ul id="tabNav" class="nav nav-pills nav-stacked">
							<li class="active"><a href="#A" data-toggle="pill"
								id="showInfo">资料显示</a></li>
							<li><a href="#A" data-toggle="tab" id="alterInfo">资料修改</a></li>
							<li><a href="#C" data-toggle="tab">密码修改</a></li>
							<li><a href="#D" data-toggle="tab">我的订单</a></li>
					</ul>
					</div>
				</div>
				<%
					CartBean cartBean=CartBean.getCartBean(session);
					List<CartItemBean> list=cartBean.getItems();
				%>
				<div class="panel panel-danger">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-user"></span>&nbsp;<strong>购物车</strong>
					</div>
					<div class="panel-body">
						<%
						if(list!=null){
						%>
							<p align="left"><label>选购商品共 <%=list.size() %> 种，<%=cartBean.getCount() %> 件。</label></p>
							<p align="left"><label>共计： ￥<%=cartBean.getTotalPrice() %> 元</label></p>
						<%
						}else{
						%>
							<p align="left"><label>选购商品共0种，0 件。</label></p>
							<p align="left"><label>共计： ￥ 0元</label></p>
						<%
						}
						%>
						<p align="right"><span class="glyphicon glyphicon-shopping-cart"></span><a href="<%=basePath%>shopcart.jsp">进入购物车</a><p>
					</div>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="panel">
					<div class="panel-body">
						<div class="tab-content">
							<div class="tab-pane active fade in" id="A">
								<legend>
									<label><span class="glyphicon glyphicon-user"></span>&nbsp;会员基本资料</label>
								</legend>
								<%
									UserBean userBean = (UserBean) session.getAttribute("userbean");
									if (userBean != null) {
								%>
								<div class="col-lg-2"></div>
								<div class="col-lg-8">
									<form action="updateInfo" method="post">
										<div class="form-group">
											<label for="username">用户名</label> <input class="form-control"
												type="text" id="username" name="username" disabled="disabled"
												value="<%=userBean.getUserName()%>" onblur="checkuser(this.value)">
											<div id="updatetext" style="color: #A94442; font-size: 10px;"></div>
										</div>
										<div class="form-group">
											<label for="relname">真实姓名</label> <input class="form-control"
												type="text" id="relname" name="relname"
												value="<%=userBean.getRelName()%>" disabled="disabled">
										</div>
										<div class="form-group">
											<label for="sex">性别</label> <select class="form-control"
												id="sex" name="sex" disabled="disabled">
												<%
													if ("男".equals(userBean.getSex())) {
												%>
												<option value="男" selected="selected">男</option>
												<option value="女">女</option>
												<%
													} else {
												%>
												<option value="男">男</option>
												<option value="女" selected="selected">女</option>
												<%
													}
												%>
											</select>
										</div>
										<div class="form-group">
											<label for="birthday">生日</label> <input class="form-control"
												type="text" id="birthday" name="birthday"
												value="<%=userBean.getBirthDay()%>" disabled="disabled">
										</div>
										<div class="form-group">
											<label for="telephone">电话号码</label> <input
												class="form-control" type="text" id="telephone"
												name="telephone" value="<%=userBean.getTelePhone()%>"
												disabled="disabled">
										</div>
										<div class="form-group">
											<label for="email">电子邮箱</label> <input class="form-control"
												type="email" id="email" name="email"
												value="<%=userBean.getEmail()%>" disabled="disabled">
										</div>

										<div class="form-group">
											<label for="postcode">邮编</label> <input class="form-control"
												type="text" id="postcode" name="postcode"
												value="<%=userBean.getPostCode()%>" disabled="disabled">
										</div>
										<div class="form-group" id="addressDiv">
											<label for="address">地址</label> <input class="form-control"
												type="text" id="address" name="address"
												value="<%=userBean.getAddress()%>" disabled="disabled">
										</div>
									</form>
								</div>
								<%
									} else {
								%>
								<jsp:forward page="/common/error.jsp"></jsp:forward>
								<%
									}
								%>
							</div>
							<div class="tab-pane" id="B">
								<legend>
									<label><span class="glyphicon glyphicon-file"></span>&nbsp;基本资料修改</label>
								</legend>
							</div>
							<div class="tab-pane" id="C">
								<legend>
									<label><span class="glyphicon glyphicon-asterisk"></span>&nbsp;密码修改</label>
								</legend>
								<div class="col-lg-2"></div>
								<div class="col-lg-8" style="height: 400px;">
									<br>
									<form action="changePwd" method="post">
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
							<div class="tab-pane" id="D">
								<legend>
									<label><span class="glyphicon glyphicon-plus"></span>&nbsp;我的订单</label>
								</legend>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>