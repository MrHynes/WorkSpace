<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码修改</title>
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
<script src="<%=basePath%>js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
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
					<div class="col-lg-12">
						<div class="col-lg-3"></div>
						<div class="col-lg-6">
							<form action="admInfo?task=modifyPwd" method="post">
								<div class="form-group">
										<label for="relname">旧密码</label> 
										<input class="form-control" type="password" placeholder="请输入旧密码"  name="oldpassword">
								</div>
								<div class="form-group">
										<label for="relname">新密码</label> 
										<input class="form-control" type="password" placeholder="请输入新密码" name="password">
								</div>
								<div class="form-group">
										<label for="relname">新密码</label> 
										<input class="form-control" type="password" placeholder="再次请输入密码"  name="repassword">
								</div>
								<br>
								<input type="submit" value="确定" class="btn btn-warning" style="width: 228px;">
								&nbsp;&nbsp;&nbsp; 
								<input type="reset" value="重置" class="btn btn-success"  style="width: 228px;">
							</form>
						</div>
						<div class="col-lg-3"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>