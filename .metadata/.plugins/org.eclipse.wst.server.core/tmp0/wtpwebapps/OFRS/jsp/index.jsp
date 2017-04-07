<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../js/fileUpload.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/fileUpload.css">
<title>File upload</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<div class="largeImg row">
		<!-- 大图 -->
		<div class="col-md-8 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="largeImg-body panel-body">
					<img class="largeImg-body-img" alt="" src="../picture/upload/<%=request.getSession().getAttribute("fileName") %>">
				</div><!-- panel-body -->	
			</div><!-- panel -->
		</div><!-- md -->
		
		<!-- 文件选择 -->
		<div class="fileChoose col-md-3">
			<div class="panel panel-success">
				<div class="panel-heading">
				</div>
				<div class="panel-body">
					<form action="<%=request.getContextPath() %>/servlet/FileUploadTestServlet" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label>File input</label>
						    <input type="file" id="myFile" name="myFile" />
						    <p class="help-block">选择要上传的文件</p>
						    <div id="submit-btm">
						    	<button type="submit" name="submit" class="btn btn-primary">上传</button>
						    </div>
						</div>
					</form>
				</div><!-- panel-body -->	
			</div><!-- panel -->
		</div><!-- col -->
		
		<!-- 文件操作 -->
		<div class="col-md-3">
			<div class="panel panel-success">
				<div class="panel-heading"></div>
				<div class="panel-body">
				<form action="<%=request.getContextPath() %>/servlet/FileUploadTestServlet" method="get">
					<div class="form-group">
						<button type="submit" name="detect" class="btn btn-primary">图片检测</button>
					</div>
					<div class="input-group">
						<div class="input-group-addon">人脸数量</div>
						<input type="text" class="form-control" name="numOfFaces" placeholder="0" value="1" readonly/>
					</div>
				</form>
				</div><!-- panel-body -->	
			</div><!-- panel -->
		</div><!-- col -->
	</div><!-- row -->
	
	<!-- 图片列表 -->
	<div class="imgList row">
		<div class="col-md-8 col-md-offset-1">
			<div class="panel panel-warning">
				<div class="imgList-body panel-body">
					<div class="row">
						<div class="col-md-3">
							<a href="#"><img class="imgList-body-img" alt="" src="../picture/test/1.jpg"></a>
						</div>
						<div class="col-md-3">
							<a href="#"><img class="imgList-body-img" alt="" src="../picture/test/2.jpg"></a>
						</div>
						<div class="col-md-3">
							<a href="#"><img class="imgList-body-img" alt="" src="../picture/test/3.jpg"></a>
						</div>
						<div class="col-md-3">
							<a href="#"><img class="imgList-body-img" alt="" src="../picture/test/4.jpg"></a>
						</div>
					</div><!-- row -->
				</div><!-- imgList-body panel-body -->
			</div><!-- panel -->
		</div><!-- col -->
	</div><!-- imgLiss row -->
</body>
</html>