<%@page import="pers.qiqcheng.ec.bean.CartItemBean"%>
<%@page import="java.util.List"%>
<%@page import="pers.qiqcheng.ec.bean.CartBean"%>
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
<title>购物车</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/head.css" rel="stylesheet" type="text/css">
<script src="<%=basePath%>js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootbox.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>js/my.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(function() {
	$("#order").click(function () {
		var isLogin=$("#isLogin").val();
		//alert(isLogin);
		if(isLogin.length<=0){
			bootbox.confirm({
				size : "small",
				message : "您还未登录，请先登录！",
				callback : function(result) {
					return;
				}
			});
		}else{
			var id_array=new Array();  
			$('input[name="confirm"]:checked').each(function(){  
			    id_array.push($(this).val());//向数组中添加元素  
			}); 
			if(id_array&&id_array.length<=0){
				bootbox.confirm({
					size : "small",
					message : "您未选择商品，请选择！",
					callback : function(result) {
						if(result){
							location.href="/ECProject/index.jsp";	
						}else{
							return;
						}
					}
				}); 
			}else{
				var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串  
				//alert(idstr);
				bootbox.confirm({
					size : "small",
					message : "您确定要下单吗?",
					callback : function(result) {
						if (result) {
							location.href = "/ECProject/frontend/createOrder?check="+idstr+"&task=getID";
						} else {
							return;
						}
					}
				});
			}
		}
		
	});
});
</script>
<body>
<%
CartBean cartBean=CartBean.getCartBean(session);
List<CartItemBean> list=cartBean.getItems();
%>
<!-- 导航 -->
<jsp:include page="common/head.jsp"></jsp:include>
<%
	String username=(String)session.getAttribute("username");
	if(username!=null){
%>
<input type="hidden" id="isLogin" value="<%=username%>">
<%} else{%>
<input type="hidden" id="isLogin" value="">
<%} %>
<div class="container">
	<div class="col-lg-12">
		<div class="col-lg-3">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-user"></span>&nbsp;<strong>购物车</strong>
				</div>
				<div class="panel-body">
					<%
					if(list!=null){
					%>
						<p align="left"><label>选购商品共 <%=list.size() %> 种，<%=cartBean.getCount() %> 件。</label></p>
						<p align="left"><label>共计： ￥<%=cartBean.getTotalPrice() %> 元</label></p>
					<%
					}else{
					%>
						<p align="left"><label>选购商品共0种，0 件。</label></p>
						<p align="left"><label>共计： ￥ 0元</label></p>
					<%
					}
					%>
					<p align="right"><span class="glyphicon glyphicon-shopping-cart"></span><a href="index.jsp">继续购物</a><p>
				</div>
			</div>
		</div>
		<div class="col-lg-9">
			<form action="createOrder" method="post">
				<div class="panel panel-success">
					<div class="panel-body pre-scrollable" style="max-height: 470px;height: 470px;">
						<table class="table table-hover">
							<thead>
								<td>状态</td>
								<td>图片</td>
								<td>名称</td>
								<td>单价</td>
								<td>数量</td>
								<td>总价</td>
								<td>操作</td>
							</thead>
							<%
								
								for(int i=0;i<list.size();i++){
									CartItemBean cartItemBean=list.get(i);
							%>
							<tr>
								<td><input type="checkbox" name="confirm" value="<%=cartItemBean.getGoodID()%>"></td>
								<td><img src="simg/<%=cartItemBean.getGoodID() %>.jpg" style="width: 70px;height: 70px;"></td>
								<td><%=cartItemBean.getGoodName() %></td>
								<td><%=cartItemBean.getGoodPrice() %></td>
								<td><%=cartItemBean.getCount() %></td>
								<td><%=cartItemBean.getTotalPrice() %></td>
								<td>
									<a href="<%=basePath%>cartServlet?task=deletecart&goodid=<%=cartItemBean.getGoodID() %>" style="color: white;"><div class="btn btn-success">刪除</div></a>
								</td>
							</tr>
							<%
							}
							%>
						</table>
					</div>
					<div class="panel-footer">
						<input type="button" value="下单" id="order" class="btn btn-success">
						<a href="<%=basePath%>cartServlet?task=delall" style="color: white;"><div class="btn btn-warning">清空购物车</div></a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>