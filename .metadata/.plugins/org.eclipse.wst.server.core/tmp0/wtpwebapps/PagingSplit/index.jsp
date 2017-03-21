<%@page import="java.util.List,pers.qiqcheng.pagesplit.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<table class="table tab-condensed table-hover">
					<thead>
						<th>id</th>
						<th>姓名</th>
						<th>年龄</th>
						<th>分数</th>
					</thead>

					<%
						List<Student> list = (List) request.getAttribute("students");
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getId()%></td>
						<td><%=list.get(i).getName()%></td>
						<td><%=list.get(i).getAge()%></td>
						<td><%=list.get(i).getScore()%></td>
					</tr>
					<%
						}
					%>
				</table>
				<ul class="pagination pagination-sm">
					<li><a href="getAll?low=0&high=3">首页</a></li>
					<li><a href="getAll?low=0&high=3">上一页</a></li>
					<li><a href="getAll?low=3&high=3">2</a></li>
					<li><a href="getAll?low=6&high=3">3</a></li>
					<li><a href="getAll?low=6&high=3">....</a></li>
					<li><a href="getAll?low=0&high=3">下一页</a></li>
					<li><a href="getAll?low=9&high=3">尾页</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>