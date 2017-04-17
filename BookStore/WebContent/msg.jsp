<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addSuccess</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/my.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="col-lg-12" align="center">
        <div class="col-lg-12 login_y"></div>
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <div class="panel panel-success">
                <div class="panel-heading">&nbsp;</div>
                <div class="panel-body">
                    <label style="font-size: 50px;color:#4cae4c"><span class="glyphicon glyphicon-ok-circle"></span></label>
                    <%
                    String msg=(String)request.getAttribute("message");
                    if(msg.equals("恭喜您！注册成功！")){
                    %>
                    <p><%=msg %></p>
                    <p>您的帐号是:<%=request.getAttribute("name") %></p>
                </div>
                <a href="login.jsp" class="btn btn-success">立即登录</a>
                <%
                }else if(msg.equals("您还未登录，请先登录")){
                    %>
                    	<p><%=msg %></p>
                    	</div>
                    	<a href="login.jsp" class="btn btn-warning">登  录</a>
                    <%
                }else if(msg.equals("未选择商品或者购物车为空！请将您所需要购买的商品加入购物车，再选择支付")){
                	%>
                		<p><%=msg %></p>
                    	</div>
                    	<a href="index.jsp" class="btn btn-warning">继续浏览</a>
                	<%
                }else if(msg.equals("添加购物车成功！")){
                	%>
                		<p><%=msg %></p>
                    	<p>3秒后，将自动跳转回主页面。如果不能跳转，请</p>
                     	<%
                    	response.setHeader("refresh", "3;url=index.jsp");
                    	%>
               			 </div>
                		<a href="index.jsp" class="btn btn-success">点击这里</a>
                		<a href="shoppingCart.jsp" class="btn btn-success">购物车</a>
                	<%
                }else if(msg.equals("购物车已经是空！")||msg.equals("已经清空购物车！")){
                	%>
                		<p><%=msg %></p>
                    	</div>
                    	<a href="index.jsp" class="btn btn-warning">继续购物</a>
                	<%
                }else if(msg==null){
                	%>
                		<p><%=msg %></p>
                    	<p>3秒后，将自动跳转回主页面。如果不能跳转，请</p>
                     	<%
                    	response.setHeader("refresh", "3;url=index.jsp");
                    	%>
               			 </div>
                		<a href="index.jsp" class="btn btn-success">点击这里</a>
                		<a href="shoppingCart.jsp" class="btn btn-success">购物车</a>
                	<%
                }else if(msg.equals("购买成功！")){
                	%>
                		<p><%=msg %></p>
                    	</div>
                    	<a href="index.jsp" class="btn btn-warning">继续购物</a>
                	<%
                }
                 %>
                <br><br><br>
            </div>
        </div>
    </div>
</div>
</body>
</html>