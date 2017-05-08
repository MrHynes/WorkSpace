<%--
  Created by IntelliJ IDEA.
  User: Buer
  Date: 2017/5/8
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>FirstAjax</title>
    <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>

  </head>
  <body>
  国家
  <select id="nation" onchange="sendNation();">
    <option selected="selected">--------&nbsp;</option>
    <option value="1">中国</option>
    <option value="2">美国</option>
  </select>
  <br>
  城市
  <select id="city">
    <option selected="selected">--------&nbsp;</option>
  </select>

  <script type="text/javascript">
    var xhr;
    function createXHR() {

      if(window.XMLHttpRequest){
        xhr=new XMLHttpRequest();
      }else {
        try {
          xhr=new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e){
          xhr=new ActiveXObject("Microsoft.XMLHTTP");
        }
      }
    }

    function sendNation() {
      createXHR();
      var nation=document.getElementById("nation").value;
      var url="process?id="+nation;
      xhr.open("GET",url,true);
      xhr.onreadystatechange=function () {
        processReadyStateChange();
      };
      xhr.send(null);
    }
    function processReadyStateChange() {
      if(xhr.readyState==4){
        if(xhr.status==200){
          var resp=xhr.responseText;
          var cities=resp.split("&");
          var select=document.getElementById("city");
          select.innerHTML=null;
          for(var i=0;i<cities.length;i++){
            var option=document.createElement("option");
            option.innerHTML=cities[i];
            select.appendChild(option);
          }
        }
      }
    }
  </script>
  </body>
</html>
