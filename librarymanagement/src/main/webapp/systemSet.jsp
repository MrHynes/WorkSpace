<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>
<link href="css/basic.css" rel="stylesheet" type="text/css"/>
<link href="css/custom.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrapValidator.min.js" type="text/javascript"></script>
<script src="js/bootbox.js" type="text/javascript"></script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<script src="js/jquery.metisMenu.js"></script>
<script src="js/custom.js"></script>
<script src="js/my2.js"></script>
<script src="js/backend.js"></script>
<script src="js/libraryInfo.js"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
  <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="tab-content">
                    <div class="col-md-12">
                        <h1 class="page-head-line">系统设置</h1>
                        <h1 class="page-subhead-line"><strong>当前位置：首页>>系统设置>>图书馆信息</strong></h1>
                    </div>
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8">
                        <form action="" method="post">
                        	
                             
                                <input class="form-control" type="hidden" id="id">
                         
                            <div class="form-group">
                                <label for="libraryName">图书馆名称</label>
                                <input class="form-control" type="text" id="libraryName" placeholder="请输入图书馆名称">
                            </div>
                            <div class="form-group">
                                <label for="libraryLeader">馆长</label>
                                <input class="form-control" type="text" id="libraryLeader" placeholder="请输入馆长姓名">
                            </div>
                            <div class="form-group">
                                <label for="libraryTel">联系电话</label>
                                <input class="form-control" type="text" id="libraryTel" placeholder="请输入联系电话">
                            </div>
                            <div class="form-group">
                                <label for="libraryAddress">联系地址</label>
                                <input class="form-control" type="text" id="libraryAddress" placeholder="请输入联系地址">
                            </div>
                            <div class="form-group">
                                <label for="libraryEmail">联系邮箱</label>
                                <input class="form-control" type="text" id="libraryEmail" placeholder="请输入联系邮箱">
                            </div>
                            <div class="form-group">
                                <label for="libraryUrl">图书馆网址</label>
                                <input class="form-control" type="text" id="libraryUrl" placeholder="请输入图书馆网址">
                            </div>
                            <div class="form-group">
                                <label for="libraryCreateTime">建馆时间</label>
                                <input type="date" class="form-control"  id="libraryCreateTime" >
                            </div>
                            <div class="form-group">
                                <label for="libraryIntroduct">图书馆简介</label>
                                <textarea class="form-control" rows="10" id="libraryIntroduct" placeholder="请输入图书馆简介"></textarea>
                            </div>
                            <div class="col-lg-12">
                                
                                <div class="col-lg-4">
                                    <button type="button" id="modify"  class="btn btn-success" style="width: 130px;">编辑</button>
                                </div>
                                <div class="col-lg-4">
                                    <button type="button" id="save"  class="btn btn-danger" style="width: 130px;">保存</button>
                                </div>
                                <div class="col-lg-4">
                                    <button type="reset" class="btn btn-warning" style="width: 130px;">重置</button>
                                </div>
                               
                            </div>

                        </form>
                    </div>
                    <div class="col-lg-2"></div>
                </div>
            </div>
        </div>
    </div>
	
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>