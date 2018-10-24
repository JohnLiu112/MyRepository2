<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/24
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/Resources/jquery-3.2.1.js">
    </script>
    <script>
        var i=false;
        $(function () {
            $("input[name='itv_time']").change(function () {
                $.ajax({
                    type:"post",
                    url:"recru/checkItvTime",
                    data:{"itv_time":$("input[name='itv_time']").val()},
                    success:function (obj) {
                        if (obj=="0"){
                            alert("面试时间必须要在1天后")
                        }else {
                            i=true;
                        }
                    }
                })
            });
            $("form").submit(function (e) {
                if (i==true){
                    return true;
                }else {
                    e.preventDefault();
                }
            })
        })
    </script>
</head>
<body>
<form action="" method="post">
    面试信息：<input type="text" name="itv_Info" required onkeydown='if(event.keyCode==13) return false;'>
    面试时间：<input type="datetime-local" name="itv_time"  required onkeydown='if(event.keyCode==13) return false;'>
    <input type="submit" name="OfferHandle" value="发送面试" onclick="this.form.action='recru/sendOffer'">
</form>
</body>
</html>
