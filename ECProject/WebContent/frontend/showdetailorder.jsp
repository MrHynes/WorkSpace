<%@page import="pers.qiqcheng.ec.bean.OrderInfoBean"%>
<%@page import="pers.qiqcheng.ec.bean.CartItemBean"%>
<%@page import="java.util.List"%>
<%@page import="pers.qiqcheng.ec.bean.CartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>订单详细</title>
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
				<div class="panel">
					<div class="panel-body">
						<!-- 发货信息 -->
						<br>
						<%
							OrderInfoBean orderInfoBean = (OrderInfoBean) session.getAttribute("orderInfoBean");
							if (orderInfoBean == null)
								orderInfoBean = new OrderInfoBean();
						%>
						<table class="table table-hover table-bordered">
							<thead>
								<th>订单编号</th>
								<th>下单时间</th>
								<th>付款方式</th>
							</thead>
							<tr>
								<td><%=orderInfoBean.getOrderID()%></td>
								<td><%=orderInfoBean.getOrderTime()%></td>
								<td><%=orderInfoBean.getPayMent()%></td>
							</tr>
							<thead>
								<th>发货方式</th>
								<th>收货人姓名</th>
								<th>收货地址</th>
							</thead>
							<tr>
								<td><%=orderInfoBean.getSendWay()%></td>
								<td><%=orderInfoBean.getReceiver()%></td>
								<td><%=orderInfoBean.getAddress()%></td>
							</tr>
							<thead>
								<th>邮编</th>
								<th>联系电话</th>
								<th>Email</th>
							</thead>
							<tr>
								<td>1<%=orderInfoBean.getPostCode()%></td>
								<td><%=orderInfoBean.getTelePhone()%></td>
								<td><%=orderInfoBean.getEmail()%></td>
							</tr>
						</table>
						<legend></legend>
						<table class="table table-hover table-bordered">
							<thead>
								<th>商品图片</th>
								<th>商品名称</th>
								<th>商品数量</th>
								<th>商品单价</th>
								<th>小计</th>
							</thead>
							<%
								CartBean cartBean = CartBean.getCartOrderBean(session);
								List<CartItemBean> goods = cartBean.getItems();
								CartItemBean cartItemBean = null;
								if (goods != null) {
									for (int i = 0; i < goods.size(); i++) {
										cartItemBean = goods.get(i);
							%>
							<fmt:formatNumber var="price"
								value="<%=cartItemBean.getGoodPrice()%>" maxFractionDigits="2"
								type="currency" currencyCode="CNY"></fmt:formatNumber>
							<fmt:formatNumber var="totalprice"
								value="<%=cartItemBean.getTotalPrice()%>" maxFractionDigits="2"
								type="currency" currencyCode="CNY"></fmt:formatNumber>
							<fmt:formatNumber var="alltotalprice"
								value="<%=cartBean.getTotalPrice()%>" maxFractionDigits="2"
								type="currency" currencyCode="CNY"></fmt:formatNumber>
							<tr>
								<td><img src="../simg/<%=cartItemBean.getGoodID()%>.jpg"
									width="50px;" height="50px;"></td>
								<td><%=cartItemBean.getGoodName()%></td>
								<td><%=cartItemBean.getCount()%></td>
								<td>${price}</td>
								<td>${totalprice}</td>
							</tr>
							<%
								}
								}
							%>
						</table>
						<div class="col-lg-8"></div>
						<div class="col-lg-4">
							商品总件数：<%=cartBean.getCount()%>
							&nbsp;&nbsp;&nbsp; 商品总价格：${alltotalprice}
						</div>
						<legend></legend>
						<!-- 审核信息 -->
						<table class="table table-hover table-bordered">
							<thead>
								<th>审核状态</th>
								<th>审核人</th>
								<th>审核时间</th>
							</thead>
							<tr>
								<td>${orderInfoBean.getOrderStatus()}</td>
								<%
									if (orderInfoBean.getChecker() == null || orderInfoBean.getCheckTime() == null) {
								%>
								<td></td>
								<td></td>
								<%
									} else {
								%>
								<td><%=orderInfoBean.getChecker()%></td>
								<td><%=orderInfoBean.getCheckTime()%></td>
								<%
									}
								%>

							</tr>
						</table>
						<a href="<%=basePath%>frontend/revieworder.jsp">
							<div class="btn btn-danger col-lg-offset-11" style="width: 90px;">确认订单</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>