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
<title>head</title>
</head>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/menue.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrapValidator.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#exit").click(function() {
			//http://www.weixuehao.com/archives/415 中文
			bootbox.confirm({
				size : "small",
				message : "确认退出系统吗?",
				callback : function(result) {
					if (result) {
						location.href = "/ECProject/common/exit.jsp";
					} else {
						return;
					}
				}
			});
		});
		
		var xhr;
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
		function sendMsg() {
			var url = "getTypes" ;
			var payload ="action=getAll";
			xhr.open("POST", url,"true") ;
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8") ;
			xhr.onreadystatechange = function() {//回调函数
				processResponse(xhr) ;
			};
			xhr.send(payload) ;
		}

		 function processResponse(xhr) {
			 if (xhr.readyState==4 && xhr.status==200) {
				 var msgList=JSON.parse(xhr.responseText);
				 
				 for(var i=0;i<msgList.length;i++){
					 var cities=msgList[i].split("&");
					 sendtime=cities[0];
					 sender=cities[1];
					 message=cities[2];
					 var showmsg=$(
								"<div class='msg-list-body' id='msglist'>"
									+"<div class='clearfix msg-wrap'>"
										+"<div class='msg-head'>"
											+"<span class='msg-time label label-danger pull-left'>" 
												+"<span class='glyphicon glyphicon-time'></span> &nbsp;<span id='sendtime'>"+sendtime+"</span>"
											+"</span>"
											+"<span class='msg-name label label-success pull-left'> "
												+"<span class='glyphicon glyphicon-user'></span> &nbsp;<span id='sender'>"+sender+"</span>"
											+"</span> "
										+"</div>"
										+"<br>"
										+"<div class='msg-content' id='messasge'>"+message+"</div>"
									+"</div>"
								+"</div>");
					$("#showMessage").append(showmsg);
				 }
			 }			
		} 
		/* var xhr;
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
		$("#getclass").mouseover(function() {
			getType();
		});

		function getType() {
			createXHR();
			var url = "getType";
			xhr.open("GET", url, true);
			xhr.onreadystatechange = function() {
				processReadyStateChange();
			};
			xhr.send(null);
		}

		function processReadyStateChange() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var resp = xhr.responseText;
					var cities = resp.split("&");
					/* var select = document.getElementById("city");
					select.innerHTML = null;
					for (var i = 0; i < cities.length; i++) {
						var option = document.createElement("option");
						option.innerHTML = cities[i];
						select.appendChild(option);
					} */
			//	}
		//	}//
		//} */
	});
</script>

<%
	String name = (String) session.getAttribute("username");
%>
<body style="background-color: #f4f4f4">
	<div class="navbar navbar-inverse">
		<!--#2ea3fd-->
		<ul class="nav navbar-nav">
			<li><a href="<%=path%>/index.jsp">主页<span
					class="label label-danger">New</span></a></li>
			<li><a href="<%=path%>/index.jsp">商城<span
					class="label label-default">New</span></a></li>

			<!-- <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">分类
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="index.jsp">教材</a></li>
					<li><a href="index.jsp">文学</a></li>
					<li><a href="index.jsp">名著</a></li>
					<li><a href="index.jsp">生活</a></li>
				</ul>
			</li>  -->
			<!-- 分类 
			<li class="dropdown" id="classmenue"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">分类 <span class="caret"></span>
			</a>
				<ul class="dropdown-menu multi-level">
					<li class="dropdown-submenu"><a href="#">英语考级</a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="" id="英语四级">英语四级</a></li>
							<li><a tabindex="-1" href="">英语六级</a></li>
							<li><a tabindex="-1" href="">专业八级</a></li>
						</ul>
					</li>
					<li class="dropdown-submenu"><a href="#" id="classmenue">文学名著</a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="">国内名著</a></li>
							<li><a tabindex="-1" href="">国外名著</a></li>
						</ul>
					</li>
					<li class="dropdown-submenu"><a href="#">儿童读物</a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="">0-4岁</a></li>
							<li><a tabindex="-1" href="">4-7岁</a></li>
							<li><a tabindex="-1" href="">7-10岁</a></li>
							<li><a tabindex="-1" href="">10岁以上</a></li>
						</ul>
					</li>
					<li class="dropdown-submenu"><a tabindex="-1" href="">学习文具</a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="">笔记本</a></li>
						</ul>
					</li>
				</ul>
			</li>
			end -->
			<li class="dropdown" id="classmenue"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown" id="getclass">分类
					<span class="caret"></span>
			</a>
				<ul class="dropdown-menu multi-level" id="menuelist">
					<!-- 鼠标移动到 “分类”上方，Ajax获得大类和小类然后构造结点显示出来 -->
					<li class="dropdown-submenu"><a href="#"></a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="" id=""></a></li>
						</ul></li>
				</ul></li>

			<li><a href="index.jsp">店铺<span class="label"></span></a></li>
			<li><a href="index.jsp">活动<span class="label"></span></a></li>
			<li><a href="index.jsp">折扣<span class="label"></span></a></li>
		</ul>
		<div class="collapse navbar-collapse">
			<div class="nav navbar-nav navbar-right">
				<%
					if (name != null) {
				%>
				<li><a>欢迎您：<%=name%></a></li>
				<li><a href="<%=basePath%>frontend/shopcart.jsp">购物车</a></li>
				<li><a href="<%=basePath%>getUserInfon">会员中心</a></li>
				<li><a href="<%=basePath%>frontend/order.jsp">查看订单</a></li>
				<li><a id="exit">退出</a></li>
				<li><a href="<%=path%>/common/error.jsp">帮助</a></li>
				<%
					} else {
				%>
				<li><a data-toggle="modal" data-target="#login">登录</a></li>
				<li><a href="#">后台管理</a></li>
				<li><a href="<%=path%>/common/error.jsp">帮助</a></li>
				<%
					}
				%>
			</div>
		</div>
	</div>

	<div class="modal fade" id="login" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog" style="width: 370px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only"></span>
					</button>
					<h5 class="modal-title" id="myModalLabel">用户登录</h5>
				</div>
				<div class="modal-body">
					<form action="<%=basePath%>userlogin" method="post">
						<div class="form-group">
							<input type="text" name="username" id="username"
								class="form-control" placeholder="请输入用户名" style="height: 40px;"><br>
						</div>
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control" placeholder="请输入密码" style="height: 40px;"><br>
						</div>
						<input type="submit" value="登录" class="btn btn-success btn-block"><br>
						<input type="reset" value="重置" class="btn btn-warning btn-block">
						<br> <input type="checkbox" name="free" value="1">下次自动登录<br>
						<br> <a href="<%=basePath%>public/error.jsp"
							class="col-lg-offset-0">登录遇到问题</a> <a
							href="<%=basePath%>register.jsp" class="col-lg-offset-6">立即注册</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>