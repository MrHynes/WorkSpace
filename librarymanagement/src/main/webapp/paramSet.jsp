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
                        <h1 class="page-subhead-line"><strong>当前位置：首页>>系统设置>>参数设置</strong></h1>
                    </div>
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <form action="" method="post">
                            <div class="form-group">
                                <label for="cost">办证费</label>
                                <input class="form-control" type="text" id="cost" placeholder="请输入办证费用">
                            </div>
                            <div class="form-group">
                                <label for="usefulLife">有效期限</label>
                                <input class="form-control" type="text" id="usefulLife" placeholder="请输入有效期限">
                            </div>
                            <div class="col-lg-12">
                                <div class="col-lg-2"></div>
                                <div class="col-lg-4">
                                    <input type="submit" value="保存" class="btn btn-danger" style="width: 130px;">
                                </div>
                                <div class="col-lg-4">
                                    <input type="reset" value="重置" class="btn btn-warning" style="width: 130px;">
                                </div>
                                <div class="col-lg-2"></div>
                            </div>

                        </form>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>