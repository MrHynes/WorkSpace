<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="pers.qiqcheng.ec.bean.admin.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/font-awesome.css" rel="stylesheet" />
<link href="<%=basePath%>css/basic.css" rel="stylesheet" />
<link href="<%=basePath%>css/custom.css" rel="stylesheet" />
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrapValidator.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/my.js"></script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<script src="<%=basePath%>js/jquery.metisMenu.js"></script>
<script src="<%=basePath%>js/custom.js"></script>
<script src="<%=basePath%>js/backend.js"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="menue.jsp"></jsp:include>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="tab-content">
						<div class="col-md-12">
							<h1 class="page-head-line">用户管理</h1>
							<h1 class="page-subhead-line"></h1>
						</div>
						<div class="col-lg-2"></div>
						<div class="col-lg-8">
							<%
								ArrayList<AdminBean> items = (ArrayList) session.getAttribute("admininfo");
								AdminBean adminBean = null;
								if (items == null)
									items = new ArrayList();
								for (int i = 0; i < items.size(); i++) {
									adminBean = items.get(i);
									String userName = (String) session.getAttribute("adminName");
									if (userName != null && userName.equals(adminBean.getUserName())) {
							%>
							<form action="admInfo?task=updateInfo" method="post">
								<div class="form-group">
									<label for="username">用户名</label> <input class="form-control"
										type="text" id="username" name="username" disabled="disabled"
										value="<%=adminBean.getUserName()%>">
								</div>
								<div class="form-group">
									<label for="relname">真实姓名</label> <input class="form-control"
										type="text" id="relname" name="relname"
										value="<%=adminBean.getRelName()%>" disabled="disabled">
								</div>
								<div class="form-group">
									<label for="sex">性别</label> <select class="form-control"
										id="sex" name="sex" disabled="disabled">
										<%
											if ("男".equals(adminBean.getSex())) {
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
										value="<%=adminBean.getBirthDay()%>" disabled="disabled">
								</div>
								<div class="form-group">
									<label for="telephone">电话号码</label> <input class="form-control"
										type="text" id="telephone" name="telephone"
										value="<%=adminBean.getTelePhone()%>" disabled="disabled">
								</div>
								<div class="form-group">
									<label for="email">电子邮箱</label> <input class="form-control"
										type="email" id="email" name="email"
										value="<%=adminBean.getEmail()%>" disabled="disabled">
								</div>

								<div class="form-group">
									<label for="postcode">邮编</label> <input class="form-control"
										type="text" id="postcode" name="postcode"
										value="<%=adminBean.getPostCode()%>" disabled="disabled">
								</div>
								<div class="form-group" id="addressDiv">
									<label for="address">地址</label> <input class="form-control"
										type="text" id="address" name="address"
										value="<%=adminBean.getAddress()%>" disabled="disabled">
								</div>
							</form>
							<%
								}
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-12"
		style="background-color: black; height: 60px; text-align: center; color: white; line-height: 60px;">
		Copyright ©2017, 程祺004 All rights reserved.</div>
</body>
</html>