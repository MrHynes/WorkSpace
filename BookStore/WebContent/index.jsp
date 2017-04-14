<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,pers.qiqcheng.bookstore.bean.BookBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookStore</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body style="background-color: #f4f4f4">
	<!--导航栏 -->
	<jsp:include page="head.jsp"></jsp:include>
	<!-- 搜索框 -->
	<div class="col-lg-3"></div>
	<div class="col-lg-5">
		<form action="searchBook">
			<div class="input-group">
				<div class="input-group-btn">
					<button class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" type="button" style="height: 45px;">
						请选择<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">宝贝</a></li>
						<li><a href="#">店铺</a></li>
					</ul>
				</div>
				<input type="text" class="form-control" placeholder="输入关键字|书名或者作者名"
					style="height: 45px; width: 450px;" name="key" /> <span
					class="input-group-btn"> <input type="submit" value="查询"
					class="btn btn-primary" style="height: 45px; width: 70px;">
				</span>
			</div>
		</form>
	</div>
	<div class="col-lg-3"></div>
	<div class="col-lg-12">&nbsp;</div>
	<!--轮播图-->
	<div class="col-lg-12" align="center">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<div class="carousel" id="carouselcontainer" data-ride="carousel"
					style="width: 100%; height: 390px;">
					<ol class="carousel-indicators">
						<li class="active" data-target="#carouselcontainer"
							data-slide-to="0">0</li>
						<li data-target="#carouselcontainer" data-slide-to="1">1</li>
						<li data-target="#carouselcontainer" data-slide-to="2">2</li>
						<li data-target="#carouselcontainer" data-slide-to="3">3</li>
					</ol>
					<div class="carousel-inner" style="width: 100%; height: 380px;">
						<div class="item active">
							<a href="#"><img src="img/headImg.jpg" alt=""></a>
							<div class="carousel-caption fontcolor">
								<h3>BookStore</h3>
							</div>
						</div>
						<div class="item">
							<a href="#"><img src="img/headImg2.jpg" alt=""></a>
						</div>
						<div class="item">
							<a href="#"><img src="img/headImg.jpg" alt=""></a>
						</div>
						<div class="item">
							<a href="#"><img src="img/headImg2.jpg" alt=""></a>
						</div>
					</div>
					<a class="left carousel-control" href="#carouselcontainer"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carouselcontainer"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>

	<!--商品显示-->
	<div class="col-lg-12">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">&nbsp;</div>
				<!--商品-->
				<div class="col-lg-12">
					<!--  style="color: white" -->
					<%
						String flag = request.getParameter("flag");
						if (flag == null) {
							if (session.getAttribute("books") == null) {
					%>
					<h3>
						没有商品，敬请期待
						<h3>
							<%
								} else {
										List<BookBean> books = (List<BookBean>) session.getAttribute("books");
										BookBean book = null;
										for (int i = 0; i < books.size(); i++) {
											book = books.get(i);
							%>
							<div class="col-lg-3">
								<a href="#" class="thumbnail"> <img
									src="img/<%=book.getIsbn()%>.jpg" alt="">
								</a>
								<div class="fontcolor">
									<h3><%=book.getBookName()%></h3>
									<p>
										定价: ￥<%=book.getPrice()%>元 | 库存：<%=book.getInventory()%></p>
									<p>
										出版社名称:
										<%=book.getPress()%>
										| 作者:
										<%=book.getAuthor()%></p>
									<p>
										<!-- 
										<button type="button" class="btn btn-xs btn-primary">购买</button>
										<button type="button" class="btn btn-xs btn-primary">加入购物车</button>
										-->
										<input type="submit" class="btn btn-xs btn-primary" value="购买">
										<form action="addCart?isbn=<%=book.getIsbn() %>" method="post">
											<input type="submit" class="btn btn-xs btn-primary" value="加入购物车">
										</form>
									</p>
								</div>
							</div>
							<%
								}
									}
								} else {
									List<BookBean> searchBooks = (List<BookBean>) session.getAttribute("searchBooks");
									BookBean searchBook = null;
									for (int i = 0; i < searchBooks.size(); i++) {
										searchBook = searchBooks.get(i);
							%>
							<div class="col-lg-3">
								<a href="#" class="thumbnail"> <img
									src="img/<%=searchBook.getIsbn()%>.jpg" alt="">
								</a>
								<div class="fontcolor">
									<h3><%=searchBook.getBookName()%></h3>
									<p>
										定价: ￥<%=searchBook.getPrice()%>元 | 库存：<%=searchBook.getInventory()%></p>
									<p>
										出版社名称:
										<%=searchBook.getPress()%>
										| 作者:
										<%=searchBook.getAuthor()%></p>
									<p>
										<!-- 
										<button type="button" class="btn btn-xs btn-primary">购买</button>
										<button type="button" class="btn btn-xs btn-primary">加入购物车</button>
										-->
										<input type="submit" class="btn btn-xs btn-primary" value="购买">
										<form action="addCart?isbn=<%=searchBook.getIsbn() %>" method="post">
											<input type="submit" class="btn btn-xs btn-primary" value="加入购物车">
										</form>
									</p>
								</div>
							</div>

							<%
								}
								}
							%>
						
				</div>
			</div>
		</div>
		<div>&nbsp;</div>
	</div>
<!-- 
<div class="col-lg-12" style=" background-color:#3b414f; height: 60px;text-align: center;color: white; line-height: 60px;  ">
    Copyright ©2017, 程祺004 All rights reserved.
</div>
 -->
 <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>