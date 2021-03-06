<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插入数据</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="navbar navbar-inverse">
					<div class="collapse navbar-collapse">
						<div class="nav navbar-nav">
							<li><a href="index.jsp">查询</a></li>
							<li><a>删除</a></li>
							<li><a href="insert.jsp">插入</a></li>
							<li><a>修改</a></li>
						</div>
						<div class="nav navbar-nav navbar-right">
							<li><a href="exit.jsp">注销</a></li>
							<li><a href="#">帮助</a></li>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-12">
				<div class="panel panel-success">
					<div class="panel panel-heading">&nbsp;</div>
					<div class="panel panel-body">
						<div class="col-lg-4"></div>
						<div class="col-lg-4">
							<form action="insert" method="post">
								<div class="form-group">
									<label for="id">学号</label> <input class="form-control"
										type="text" id="id" placeholder="请输入学号" name="id">
								</div>
								<div class="form-group">
									<label for="name">姓名</label> <input class="form-control"
										type="text" id="name" placeholder="请输入姓名" name="name">
								</div>
								<div class="form-group">
									<label for="age">年龄</label> <input class="form-control"
										type="text" id="age" placeholder="请输入年龄" name="age">
								</div>
								<div class="form-group">
									<label for="score">分数</label> <input class="form-control"
										type="text" id="score" placeholder="请输入分数" name="score">
								</div>
								<input type="submit" value="提交" class="btn btn-primary">
								<input type="reset" value="重置" class="btn btn-primary">
							</form>
						</div>
						<div class="col-lg-4"></div>
					</div>
					<div class="panel panel-footer">Copyright ©2017 qiqcheng</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>