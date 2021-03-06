<%@page import="java.util.Date"%>
<%@page import="pers.qiqcheng.ec.bean.OrderBean"%>
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
<title>我的订单</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function () {
		$("#session2").click(function () {
			document.getElementById('session2').scrollIntoView();
		});
		$("#session3").click(function () {
			document.getElementById('session3').scrollIntoView();
		});
		$("#session4").click(function () {
			document.getElementById('session4').scrollIntoView();
		});
		$("#order").click(function () {
			var orderID=$("#orderid").val();
			var orderTime=$("#orderdate").val();
			bootbox.confirm({
				message : "您的订单已经提交成功，订单编号为"+orderID+"，下当日期为"+orderTime,
				callback : function(result) {
					if (result) {
						return true;
					} else {
						return false;
					}
				}
			});
		});
		$("form").submit(function(e){
			var orderID=$("#orderid").val();
			var orderTime=$("#orderdate").val();
			alert("您的订单已经提交成功，订单编号为"+orderID+"，下当日期为"+orderTime");
		});
	});
</script>
</head>
<body>
<!-- 导航 -->
<jsp:include page="/common/head.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="col-lg-3">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-user"></span>&nbsp;<strong>结算中心</strong>
					</div>
					<div class="panel-body">
						<ul id="tabNav" class="nav nav-pills nav-stacked">
							<li class="active"><a href="#session" data-toggle="pill"
								id="showInfo" >收货信息</a></li>
							<li id="session2"><a data-toggle="tab">商品信息</a></li>
							<li id="session3"><a data-toggle="tab">确认订单</a></li>
							<li id="session4"><a data-toggle="tab">确认下单</a></li>
					</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-user"></span>&nbsp;<strong>下订单</strong>
					</div>
					<div class="panel-body">
						<form action="createOrder?task=insertTable" method="post">
							<div class="col-lg-2"></div>
							<div class="col-lg-8" id="session">
								<!-- 收货人信息 -->
								<div class="form-group">
									<label for="relname">收货人姓名</label>
									<input class="form-control" type="text" name="relname" value="">
								</div>
								<div class="form-group">
									<label for="address">收货地址</label>
									<input class="form-control" type="text" name="address" value="">
								</div>
								<div class="form-group">
									<label for="postcode">邮编</label>
									<input class="form-control" type="text" name="postcode" value="">
								</div>
								<div class="form-group">
									<label for="telephone">联系电话</label>
									<input class="form-control" type="text" name="telephone" value="">
								</div>
								<div class="form-group">
									<label for="email">邮箱</label>
									<input class="form-control" type="text" name="email" value="">
								</div>
							</div>
								<legend></legend>
							<div class="col-lg-2"></div>
							<div class="col-lg-8" id="session2">
								<!-- 商品信息 -->
								<%
									OrderBean orderBean=(OrderBean)session.getAttribute("orderBean");
									if(orderBean==null){
										orderBean=new OrderBean();
									}
								%>
								<input type="hidden" value="<%=orderBean.getOrderID()%>" name="orderid" id="orderid">
								<div class="form-group">
									<label for="typecount">商品种类数</label>
									<input class="form-control" type="text" name="typecount" value="<%=orderBean.getTypeCount()%>">
								</div>
								<div class="form-group">
									<label for="count">商品总件数</label>
									<input class="form-control" type="text" name="count" value="<%=orderBean.getCount()%>">
								</div>
								<div class="form-group">
									<label for="totalPrice">价格总计</label>
									<input class="form-control" type="text" name="totalPrice" value="<%=orderBean.getTotalPrice() %>">
								</div>
								<div class="form-group">
									<label for="orderdate">订单日期</label>
									<input class="form-control" type="text" id="orderdate" name="orderdate" value="<%=orderBean.getOrderDateTime() %>">
								</div>
								
								<div class="form-group">
									<label for="sendway">收货方式</label>
									<select name="sendway" class="form-control">
										<option value="送货上门">送货上门</option>
										<option value="自提点自提">自提点自提</option>
									</select>
								</div>
							</div>
								<legend></legend>
							<div class="col-lg-2"></div>
							<div class="col-lg-8" id="session3">
								<!-- 支付方式 -->
								<div class="form-group">
									<label for="parment">付款方式</label>
									<select name="parment" class="form-control">
										<option value="货到付款">货到付款</option>
										<option value="支付宝">支付宝</option>
										<option value="微信支付">微信支付</option>
									</select>
								</div>
							</div>
								<!-- 确认下单 id="order"-->
								<legend></legend>
								<input type="submit" value="确认下单"  class="btn btn-success col-lg-offset-10" style="width: 100px;">
							</div>
							<div class="col-lg-2" id="session4"></div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>