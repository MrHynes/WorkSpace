$(function (){
	//切换图片
	$("a").click(function (){
		var src = $(this).find("img").attr("src");
		$(".largeImg-body-img").attr("src", src);
		return false;
	})
	//上传图片后切换
	var fileName = "";
	$("input").change(function (){
		//截取文件的名字
		fileName = this.value.substr(12);
	})
	//上传图片
//	$("button[name='submit']").click(function (){
//		var url = "FileUploadTestServlet";
//		var data = new FormData(document.getElementById("myFile"));
//		$.post(url, data, function(data){
//			
//		})
//		$("img[class='largeImg-body-img']").attr("src", "picture/upload/" + fileName);
//		return false;
//	})
})