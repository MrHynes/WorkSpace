<%@page import="pers.qiqcheng.ec.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<body style="background-color: #f4f4f4">
	<%
		String user=(String)session.getAttribute("user");
		if(user==null){
			response.sendRedirect("login.jsp");
		}
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		//System.out.print(userBean);
		if (userBean != null) {
	%>
	<div class="container">
		<div style="height: 20px;"></div>
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					用户信息<br>
				</div>
				<form action="update" method="post">
					<div class="panel-body">
						<table class="table table-hover">
							<tr>
								<td>用户名</td>
								<td>
									<div class="form-group">
										<input type="text" name="user"
											value="<%=userBean.getUser()%>" class="form-control">
									</div>
								</td>
							</tr>
							<tr>
								<td>密码</td>
								<td><div class="form-group">
										<input type="password" name="pwd"
											value="<%=userBean.getPwd()%>" class="form-control">
									</div></td>
							</tr>
							<tr>
								<td>密码</td>
								<td><div class="form-group">
										<input type="password" name="pwd2"
											value="<%=userBean.getPwd()%>" class="form-control">
									</div></td>
							</tr>
							<tr>
								<td>真实姓名</td>
								<td><div class="form-group">
										<input type="text" name="name" value="<%=userBean.getName()%>"
											class="form-control">
									</div></td>
							</tr>
							<tr>
								<td>性别</td>
								<td>
									<% 
										if("男".equals(userBean.getSex())){
									%>
										<input type="text" class="form-control" value="男">
									<%
										}else{
									%>
										<input type="text" class="form-control" value="女">
									<%
										} 
									%>
								</td>
							</tr>
							<tr>
								<td>生日</td>
								<td><input type="text" name="birth"
									value="<%=userBean.getBirth()%>" class="form-control">
								</div></td>
							</tr>
							<tr>
								<td>电子邮箱</td>
								<td><div class="form-group">
										<input type="text" name="email"
											value="<%=userBean.getEmail()%>" class="form-control"></td>
							</tr>
							<tr>
								<td>手机</td>
								<td><div class="form-group">
										<input type="text" name="phone"
											value="<%=userBean.getPhone()%>" class="form-control"></td>
							</tr>
							<tr>
								<td>地址</td>
								<td><div class="form-group">
										<input type="text" name="address"
											value="<%=userBean.getAddress()%>" class="form-control"></td>
							</tr>
							<tr>
								<td>邮编</td>
								<td><div class="form-group">
										<input type="text" name="code"
											value="<%=userBean.getCode()%>" class="form-control"></td>
							</tr>
							<tr>
								<td><input type="submit" value="更新" class="btn btn-success"></td>
								<td><input type="reset" name="重置" class="btn btn-warning"></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
		<div class="col-lg-2"></div>
	</div>
	<%
		}
	%>
</body>
</html>