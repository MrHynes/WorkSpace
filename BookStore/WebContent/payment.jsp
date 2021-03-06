<%@page import="pers.qiqcheng.bookstore.bean.BookCartBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pers.qiqcheng.bookstore.bean.BookBean"%>
<%@page import="java.awt.print.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<body style="background-color: #f4f4f4">
	<%
String name=(String)session.getAttribute("username");
if(name==null){
	request.getRequestDispatcher("warning.jsp").forward(request, response);
}

%>
	<!--导航栏 2-->
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<div style="height: 110px;">&nbsp;</div>
					<div class="panel panel-success">
						<!-- 支付的时候库存要减一 -->
						<div class="panel-heading">
							<span class="glyphicon glyphicon-jpy"></span> &nbsp;确认订单信息<br>
						</div>
						<form action="error.jsp" method="post">
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<td>&nbsp;</td>
										<td>名称</td>
										<td>单价</td>
										<td>数量</td>
										<td>总价</td>
									</thead>
									<% 
                        	BookBean paybook=(BookBean)request.getAttribute("paybook");
                        	if(paybook!=null){
                        		%>
									<fmt:formatNumber var="price" value="<%=paybook.getPrice()%>"
										maxFractionDigits="2" type="currency" currencyCode="CNY"></fmt:formatNumber>

									<td><img src="simg/<%=paybook.getIsbn()%>.jpg"></td>
									<td><%=paybook.getBookName() %></td>
									<td>${price}</td>
									<td><%=1%></td>
									<td>${price}</td>
									<%
                        	}
                        %>
								</table>
							</div>
							<div class="panel-footer">
								<!-- 
                    	<form action="inventory?isbn=<%=paybook.getIsbn()%>" method="post">
                    		<input type="submit" value="支付" class="btn btn-success">                    	
                    	</form>
                    	 -->
								<div class="btn btn-success">
									<a href="inventory?isbn=<%=paybook.getIsbn()%>"
										style="color: white;">支付</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--foot-->

	<div class="foot col-lg-12" style="position: fixed; bottom: 0px;">
		Copyright ©2017, 程祺004 All rights reserved.</div>
</body>
</html>