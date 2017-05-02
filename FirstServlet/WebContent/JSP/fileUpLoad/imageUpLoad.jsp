<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片上传</title>
<script type="text/javascript" src="/FirstServlet/js/jquery-3.1.1.min.js"></script>
       
<script>
$(function () {
    $("#sub").click(function(){
        var test="/FirstServlet/upload?username="+$("#username").val();
        $("#upload").attr("action",test);
    });
});
</script>
 
</head>
<body>
	<h1>图片上传</h1>
	<img alt="" src="/FirstServlet/image/123.jpg">
	<form action="" id="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="username" id="username">
		<input type="file" value="上传图片" name="img"> 
		<input type="submit" value="上传" id="sub" >
	</form>
</body>
</html>