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
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
 <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="tab-content">
                    <div class="col-md-12">
                        <h1 class="page-head-line">系统设置</h1>
                        <h1 class="page-subhead-line"><strong>当前位置：首页>>图书借还>>管理员设置</strong></h1>
                    </div>
                    <div class="col-lg-12">
                        <a data-toggle="modal" data-target="#addAdmin"><div class="btn btn-primary col-lg-offset-11" style="width: 90px;">添加管理员</div></a><br>
                    </div>
                    <div class="col-lg-12" style="height: 10px;"></div>
                    <div class="col-lg-12">
                        <table class="table table-bordered">
                            <thead>
                            <th>管理员名称</th>
                            <th>系统设置</th>
                            <th>读者管理</th>
                            <th>图书管理</th>
                            <th>图书借还</th>
                            <th>系统查询</th>
                            <th>权限设置</th>
                            <th>操作</th>
                            </thead>
                            <tr>
                                <td>SuperAdmin</td>
                                <td><input type="checkbox"></td>
                                <td><input type="checkbox"></td>
                                <td><input type="checkbox"></td>
                                <td><input type="checkbox"></td>
                                <td><input type="checkbox"></td>
                                <td><a><button class="btn btn-danger" data-toggle="modal" data-target="#powerset">权限设置</button></a></td>
                                <td><a><button class="btn btn-warning">删除</button></a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--添加管理员对话框-->
<div class="modal fade" id="addAdmin" tabindex="-1" role="dialog"
     aria-hidden="true">
    <div class="modal-dialog" style="width: 370px;">
        <div class="modal-content">
            <div class="modal-header">
                <a type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span> <span class="sr-only"></span>
                </a>
                <h5 class="modal-title" id="myModalLabel">添加管理员</h5>
            </div>
            <div class="modal-body">
                <form action="#" method="post">
                    <div class="form-group">
                        <input type="text" name="username" id="username"
                               class="form-control" placeholder="请输入管理员名称" style="height: 40px;">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="password"
                               class="form-control" placeholder="请输入密码" style="height: 40px;">
                    </div>
                    <div class="form-group">
                        <input type="password" name="repassword" id="repassword"
                               class="form-control" placeholder="再次请输入密码" style="height: 40px;">
                    </div>
                    <input type="submit" value="确定" class="btn btn-success" style="width: 165px;">
                    <input type="reset" value="重置" class="btn btn-warning" style="width: 165px;">
                </form>
            </div>
        </div>
    </div>
</div>
<!--管理员权限设置对话框-->
<div class="modal fade" id="powerset" tabindex="-1" role="dialog"
     aria-hidden="true">
    <div class="modal-dialog" style="width: 370px;">
        <div class="modal-content">
            <div class="modal-header">
                <a type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span> <span class="sr-only"></span>
                </a>
                <h5 class="modal-title" >权限设置</h5>
            </div>
            <div class="modal-body">
                <form action="#" method="post">
                    <div class="form-group">
                        <label for="adminid">管理员名称</label>
                        <input type="text" name="username" id="adminid" class="form-control" style="height: 40px;">
                    </div>
                    <div class="form-group">
                        <label>拥有的权限</label><br>
                        <table class="table">
                            <tr>
                                <td><input type="checkbox">系统设置</td>
                                <td><input type="checkbox">读者管理</td>
                                <td><input type="checkbox">图书管理</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox">图书借还</td>
                                <td><input type="checkbox">系统查询</td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                    <input type="submit" value="确定" class="btn btn-success" style="width: 165px;">
                    <input type="reset" value="重置" class="btn btn-warning" style="width: 165px;">
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>