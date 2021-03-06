<%@page import="java.util.List,com.dbop.vo.*,com.dbop.dao.factory.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库操作</title>
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
					<div class="panel-heading">&nbsp;</div>
					<div class="panel-body">
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>年龄</th>
									<th>成绩</th>
									<th>操作</th>
									<th>更新</th>
								</tr>
							</thead>
							<%
								List<Info> list = null;
								list = DaoFactory.getIDbopDaoInstance().doSelect();
								for (int i = 0; i < list.size(); i++) {
							%>
							<tr>
								<td><%=list.get(i).getId()%></td>
								<td><%=list.get(i).getName()%></td>
								<td><%=list.get(i).getAge()%></td>
								<td><%=list.get(i).getScore()%></td>
								<td><a href="delete?id=<%=list.get(i).getId()%>">刪除</a></td>
								<td><a
									href="update.jsp?id=<%=list.get(i).getId()%>&name=<%=list.get(i).getName()%>&age=<%=list.get(i).getAge()%>&score=<%=list.get(i).getScore()%>">更新</a></td>
							</tr>
							<%
								}
							%>
						</table>
					</div>
					<div class="panel-footer" align="center">Copyright ©2017
						qiqcheng</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>