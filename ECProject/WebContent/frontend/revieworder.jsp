<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pers.qiqcheng.ec.bean.ShowOrderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看订单</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript"
	src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/common/head.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<legend>
					<label><span class="glyphicon glyphicon-plus"></span>&nbsp;我的订单</label>
				</legend>
				<div class="col-lg-12">
				<div class="panel" style="height: 430px;">
					<div class="panel-body pre-scrollable" style="max-height: 450px;height: 450px;">
						<table class="table table-hover">
							<%
								List<ShowOrderBean> order = (ArrayList) session.getAttribute("order");
								ShowOrderBean showOrderBean = null;
								if (order == null) {
							%>
							您还没有订单，快到<a href="../index.jsp">主页</a>购买您需要的商品吧！
							<%
								} else {
							%>
							<thead>
								<td>订单编号</td>
								<td>下单时间</td>
								<td>商品总数</td>
								<td>总额</td>
								<td>订单状态</td>
								<td>操作</td>
							</thead>
							<%
								for (int i = 0; i < order.size(); i++) {
										showOrderBean = order.get(i);
							%>
							<fmt:formatNumber var="price" value="<%=showOrderBean.getTotalPrice()%>"
						maxFractionDigits="2" type="currency" currencyCode="CNY"></fmt:formatNumber>
							<tr>
								<td><%=showOrderBean.getOrderId()%></td>
								<td><%=showOrderBean.getOrderTime()%></td>
								<td><%=showOrderBean.getSum()%></td>
								<td>${price}</td>
								<td><%=showOrderBean.getOrderStatus()%></td>
								<td><a href="<%=basePath %>frontend/createOrder?task=showDetailOrder&orderid=<%=showOrderBean.getOrderId()%>"><input type="button" class="btn btn-success" style="height: 30px;" value="查看订单"></a></td>
							</tr>
							<%
								}
								}
							%>
						</table>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>