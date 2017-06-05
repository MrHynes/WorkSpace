$(function() {
		$("#exit").click(function() {
			//http://www.weixuehao.com/archives/415 中文
			bootbox.confirm({
				size : "small",
				message : "确认退出系统吗?",
				callback : function(result) {
					if (result) {
						location.href = "/ECProject/backend/login.jsp";
					} else {
						return;
					}
				}
			});
		});
		$("#exit2").click(function() {
			bootbox.confirm({
				size : "small",
				message : "确认退出系统吗?",
				callback : function(result) {
					if (result) {
						location.href = "/ECProject/backend/login.jsp";
					} else {
						return;
					}
				}
			});
		});
	var i=0;
		
		$("#SystemSetting").click(function () {
			//removeClass
			$("#SystemSetting").addClass("active-menu");
			$("#ReaderAdmin").removeClass("active-menu");
			$("#BookManager").removeClass("active-menu");
			$("#BorrowAndReturn").removeClass("active-menu");
			$("#Searching").removeClass("active-menu");
			$("#Setting").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#ReaderAdmin").click(function () {
			//removeClass
			$("#ReaderAdmin").addClass("active-menu");
			$("#SystemSetting").removeClass("active-menu");
			$("#BookManager").removeClass("active-menu");
			$("#BorrowAndReturn").removeClass("active-menu");
			$("#Searching").removeClass("active-menu");
			$("#Setting").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#BookManager").click(function () {
			//removeClass
			$("#BookManager").addClass("active-menu");
			$("#ReaderAdmin").removeClass("active-menu");
			$("#SystemSetting").removeClass("active-menu");
			$("#BorrowAndReturn").removeClass("active-menu");
			$("#Searching").removeClass("active-menu");
			$("#Setting").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#BorrowAndReturn").click(function () {
			//removeClass
			$("#BorrowAndReturn").addClass("active-menu");
			$("#ReaderAdmin").removeClass("active-menu");
			$("#BookManager").removeClass("active-menu");
			$("#SystemSetting").removeClass("active-menu");
			$("#Searching").removeClass("active-menu");
			$("#SystemSetting").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#Searching").click(function () {
			//removeClass
			$("#Searching").addClass("active-menu");
			$("#ReaderAdmin").removeClass("active-menu");
			$("#BookManager").removeClass("active-menu");
			$("#BorrowAndReturn").removeClass("active-menu");
			$("#SystemSetting").removeClass("active-menu");
			$("#Setting").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#Setting").click(function () {
			//removeClass
			$("#Setting").addClass("active-menu");
			$("#ReaderAdmin").removeClass("active-menu");
			$("#BookManager").removeClass("active-menu");
			$("#BorrowAndReturn").removeClass("active-menu");
			$("#Searching").removeClass("active-menu");
			$("#SystemSetting").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#exit2").click(function () {
			//removeClass
			$("#exit2").addClass("active-menu");
			$("#ReaderAdmin").removeClass("active-menu");
			$("#BookManager").removeClass("active-menu");
			$("#BorrowAndReturn").removeClass("active-menu");
			$("#Searching").removeClass("active-menu");
			$("#Setting").removeClass("active-menu");
			$("#SystemSetting").removeClass("active-menu");
		});
	});