<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,pers.qiqcheng.onlinechat.bean.Message" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>msg</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<%
		//10秒刷新一次
		response.setHeader("Refresh", "10");
		List<Message> msgList = (List<Message>) application.getAttribute("msgList");
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
</body>
</html>