<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,pers.qiqcheng.onlinechat.bean.Message"
	errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EnjoyChat</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<body onload="inputFocus()">
	<%
		String name = (String) session.getAttribute("users");
		if (name == null) {
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%
		}
	%>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row" style="margin-top: 15px;">
			<!-- 聊天区 -->
			<div class="col-lg-8">
				<!-- 聊天内容 -->
				<div class="panel panel-primary chatWindowH">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-earphone"></span> &nbsp;聊天内容
					</div>
					<div class="panel-body  ">
						<!--显示聊天内容-->
						<iframe src="msg.jsp" frameborder="0" width="100%" height="390px"></iframe>
						<!-- 
						<%List<Message> msgList = (List<Message>) application.getAttribute("msgList");
							if (msgList != null) {
								for (int i = 0; i < msgList.size(); i++) {
									Message message = msgList.get(i);
						%>
						<div class="msg-list-body">
							<div class="clearfix msg-wrap">
								<div class="msg-head">
									<span class="msg-name label label-success pull-left"> <span
										class="glyphicon glyphicon-user"></span> &nbsp;<%=message.getSenderName()%>
									</span> <span class="msg-time label label-danger pull-left"> <span
										class="glyphicon glyphicon-time"></span> &nbsp;<%=message.getTime()%>
									</span>
								</div>
								<br>
								<div class="msg-content"><%=message.getSendMsg()%></div>
							</div>
						</div>
						<%
							}
						}
						%>
						 -->
					</div>
				</div>
				<!-- 输入框 -->
				<form action="getMsg" method="post">
					<div class="input-group input-group-lg">
						<span class="input-group-btn">
							<button class="btn btn-default" id="emotion-btn" type="button">
								<!--添加表情图-->
								<img src="img/emotion_smile.png"
									style="width: 24px; height: 24px;">
							</button>
						</span> <input type="text" class="form-control" placeholder="请输入聊天内容"
							name="msg" id="sendbtn"> <span class="input-group-btn">
						</span> <input type="submit" id="sendMsg" class="form-control btn btn-warning"
							value="发送">
					</div>
				</form>
			</div>

			<!-- 个人信息 -->
			<div class="col-lg-4">
				<div class="panel panel-primary userInfoH">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-user"></span> &nbsp;个人信息
					</div>
					<div class="panel-body">
						<div class="col-sm-9">
							<h5>
								昵称：<%=name%></h5>
						</div>
						<div class="col-sm-3">
							<button class="btn btn-default" data-toggle="modal"
								data-target="#changeName">修改</button>
						</div>
					</div>
				</div>
			</div>

			<!-- 在线列表 -->
			<div class="col-lg-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-list"></span> &nbsp;在线名单
					</div>
					<div class="panel-body  chatUserListH pre-scrollable">
						<table
							class="table table-hover table-responsive table-bordered list-table">
							<%
								Set<String> onlineUserList = (HashSet) application.getAttribute("onlineUserList");
								Iterator it = onlineUserList.iterator();
								while (it.hasNext()) {
							%>
							<tr>
								<td><span class="glyphicon glyphicon-user"></span>&nbsp;<%=it.next()%>
								</td>
							</tr>
							<%
								}
							%>
						</table>
					</div>
					<div class="panel-footer" id="list-count">
						当前在线：<%=onlineUserList.size()%>人
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 修改名称对话框 -->
	<div class="modal fade" id="changeName" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="rename?name=<%=name%>" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only"></span>
						</button>
						<h4 class="modal-title" id="myModalLabel">请设置聊天昵称</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-sm-8 col-sm-push-2">
								<div class="alert alert-danger" role="alert" id="nickname-error"
									style="display: none">
									<span class="glyphicon glyphicon-remove"></span> 请填写昵称
								</div>
								<div class="input-group">
									<span class="input-group-addon">昵称</span> <input type="text"
										name="rename" class="form-control" placeholder="请输入昵称">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="应用昵称" class="btn btn-primary">
						<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>