<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pers.qiqcheng.onlinevote.vo.*,java.util.*" errorPage="error.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OnlineVoting</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<!-- 登录之前验证 还可以使用Filter -->
<%
	String name = (String) session.getAttribute("users");
	if (name == null) {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Voters</div>
					<div class="panel-body">
						<table class="table table-bordered table-hover">
							<thead>
								<th>ID</th>
								<th>姓名</th>
								<th>票数</th>
								<th>操作</th>
							</thead>
							<%
								List<Votes> list = (List) request.getAttribute("voter");
								Votes votes = null;
								for (int i = 0; i < list.size(); i++) {
									votes = list.get(i);
							%>
							<tr>

								<td width="200px"><%=votes.getId()%></td>
								<td width="200px"><%=votes.getName()%></td>
								<td width="500px"><img src="img/pro.png"
									width="<%=votes.getNum() * 5%>" height="20px"> <%=votes.getNum()%>
								</td>
								<td width="150px"><a
									href="voteProcess.jsp?id=<%=votes.getId()%>&num=<%=votes.getNum()%>">投票</a></td>
							</tr>
							<%
								}
							%>
						</table>
					</div>
					<div class="panel-heading">
						<p class="text-center">Copyright ©2017, 程祺004 All rights
							reserved.</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>