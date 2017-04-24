<%@page import="pers.qiqcheng.bookstore.bean.BookCartBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pers.qiqcheng.bookstore.bean.BookBean"%>
<%@page import="java.awt.print.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body  style="background-color: #f4f4f4">
<%
String name=(String)session.getAttribute("username");
if(name==null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
}

%>
<!--导航栏 2-->
<jsp:include page="head.jsp"></jsp:include>
<div style="height: 20px;"></div>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading"><span class="glyphicon glyphicon-shopping-cart"></span> &nbsp;购物车<br></div>
                   	<form action="payall" method="post">
                    <div class="panel-body pre-scrollable" style="height: 560px;">
                        <table class="table table-hover">
                        <thead>
                       		<td>&nbsp;</td>
                        	<td>&nbsp;</td>
                            <td>名称</td>
                            <td>单价</td>
                            <td>数量</td>
                            <td>总价</td>
                            <td>操作</td>
                        </thead>
                        <%
                        	BookCartBean book=null;
                        	List<BookCartBean> cartbooks=(ArrayList)session.getAttribute("cartBooks");
                        	if(cartbooks!=null){
                        	for(int i=0;i<cartbooks.size();i++){
                        		book=cartbooks.get(i);
                        %>
                    		<tr>
                    			<td><input type="checkbox" name="confirm" value="<%=book.getIsbn() %>"></td>
                        		<td><img src="simg/<%=book.getIsbn()%>.jpg"></td>
                        		<td><%=book.getBookName() %></td>
                       			<td>￥<%=book.getPrice() %></td>
                        		<td><%=book.getNum() %></td>
                        		<td>￥<%=book.getPrice()*book.getNum() %></td>
                       			<td>
                       				 <div class="btn btn-success"><a href="delBook?isbn=<%=book.getIsbn()%>" style="color: white;">刪除</a></div>
                       			</td>
                    		</tr>
                    	<%
                        	}
                        	}
                    	%>
                    	</table>
                    </div>
                    <div class="panel-footer">
                    	<input type="submit" value="购买" class="btn btn-success">
                    	<div class="btn btn-warning"><a href="emptycart" style="color: white;">清空购物车</a></div>
                    </div>
                    </form>
                </div>
            </div>

    </div>
</div>
<!--foot-->

<div class="foot col-lg-12" style="position: fixed; bottom: 0px;">
    Copyright ©2017, 程祺004 All rights reserved.
</div>
</body>
</html>