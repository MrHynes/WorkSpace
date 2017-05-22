<%@page import="pers.qiqcheng.ec.bean.GoodsBean"%>
<%@page import="pers.qiqcheng.ec.bean.PageBean"%>
<%@page import="java.util.List"%>
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
<title>Insert title here</title>
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
<%
	String goodsID=request.getParameter("goodId");
	PageBean pageBean = (PageBean) session.getAttribute("pageBean");
	if(pageBean==null){
		request.getRequestDispatcher("/ECProject/index.jsp").forward(request, response);
	}
	List<GoodsBean> goodList = pageBean.getList();
	GoodsBean goodsBean = null;
	GoodsBean goodsBeanNext = null;
	if (goodList != null&&goodsID!=null) {
		for (int i = 0; i < goodList.size(); i++) {
			if(goodList.get(i).getGoodId().equals(goodsID)){
				goodsBean=goodList.get(i);
				if(i==goodList.size()-1){
					goodsBeanNext=goodList.get(0);
				}else{
					goodsBeanNext=goodList.get(i+1);
				}
				break;
			}
		}
	}
%>
<!--导航栏 -->
	<jsp:include page="../common/head.jsp"></jsp:include>
	<br>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="col-lg-4">
                <img src="../img/<%=goodsBean.getGoodImage() %>.jpg" width="350px;" height="350px;" class="thumbnail">
            </div>
            <form action="<%=basePath%>cartServlet?task=addcart" method="post">
	            <div class="col-lg-5"> 
	                <div class="panel">
	                	<fmt:formatNumber var="price" value="<%=goodsBean.getGoodPrice()%>"
							maxFractionDigits="2" type="currency" currencyCode="CNY"></fmt:formatNumber>
	                    <div class="panel-body" style="height: 350px;">
	                    	<legend>
								<label><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;商品详情</label>
							</legend>
							<input type="hidden" name="goodID" value="<%= goodsBean.getGoodId()%>">
	                        <p><h3 style="color: red;">[商品名称]:<%=goodsBean.getGoodName() %></h3></p>
	                        <br>
	                        <p>[商品价格]:${price}</p>
	                        <br>
	                        <p>[商品库存]:<%=goodsBean.getInventory() %></p><br>
	                        <p>[购买数量]:<input type="text" name="count" value="1"></p>
	                    </div>
	                </div>
	                <a href="#"><button class="btn btn-success" style="width: 70px;height: 35px;">购买</button></a>&nbsp;&nbsp;
	                <input type="submit" class="btn btn-warning" style="width: 100px;height: 35px;" value="加入购物车">
	                <br>
	            </div>
            </form>
            <div class="col-lg-3">
            	<div class="panel">
            		<fmt:formatNumber var="nextprice" value="<%=goodsBeanNext.getGoodPrice()%>"
						maxFractionDigits="2" type="currency" currencyCode="CNY"></fmt:formatNumber>
            		<div class="panel-body" style="height: 350px;" >
            			<legend>
							<label><span class="glyphicon glyphicon-heart"></span>&nbsp;店长推荐</label>
						</legend>
						<a href="<%=basePath %>common/detailed.jsp?goodId=<%=goodsBeanNext.getGoodId()%>"><img  src="../img/<%=goodsBeanNext.getGoodImage() %>.jpg" width="220px;" height="220px;"></a>
						<br>
						<p>[商品名称]：<%=goodsBeanNext.getGoodName() %></p>
						<p>[商品价格]：${nextprice}</p>
            		</div>
            	</div>
            </div>
            <div class="col-lg-12">
            <br>
            	<div class="panel">
            		<div class="panel-body" style="height: 100px;">
            			<p><h3>[商品描述]:<%=goodsBean.getGoodDescription() %></h3></p>
            		</div>
            	</div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>