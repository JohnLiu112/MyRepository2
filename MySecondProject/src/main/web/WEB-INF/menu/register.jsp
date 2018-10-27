<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/9/28
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>"/>
    <script src="<%=request.getContextPath()%>/Resources/jquery-3.2.1.js">
    </script>
    <style>
        #bd{
            background-color: ghostwhite;
        }
        #fd1{
            margin: 200px 0px 0px 500px;
            border: none;
            padding: 0px 0px 0px 100px;
            font-size: 20px;
            width: 700px;
        }
        .dc1{
            margin: 10px 0px 0px 0px;
        }
        #d4{
            margin: 0px 0px 0px 500px;
            padding: 0px 0px 0px 100px;
            font-size: 20px;
            width: 700px;
        }
        .txt{
            font-size: 15px;
        }
        .linkc1{
            text-decoration: Window;
            padding: 0px 0px 0px 0px;
        }
    </style>
    <script>
        $(document).ready(function () {
            $("input[name='username']").blur(function () {
                $.ajax({
                    type:"get",
                    url:"check1",
                    data:{username:$("input[name='username']").val()},
                    success:function (obj) {
                        alert(obj)
                    }
                })
            })
            $("")
        });
        function checkUserName() {
            var un=document.getElementById("uname").value;
            var reg1=/^[A-z]{1}([A-z]|[0-9]|[_]]){5,29}$/;
            var sp1=document.getElementById("sp1");
            sp1.innerText="";
            if (reg1.test(un)){
                document.getElementById("sp1").innerText="√6-30位字母、数字或“_”，字母开头";

            }else if(un==""){
                document.getElementById("sp1").innerText="6-30位字母、数字或“_”，字母开头";

            }else {
                document.getElementById("sp1").innerText="× 6-30位字母、数字或“_”，字母开头";

            }

        }
        function checkUserPass1() {
            var up = document.getElementById("upass1");
            var upValue = up.value;
            var reg2 = /^.{6,20}$/;


            if (reg2.test(upValue) && upValue.length < 12) {
                document.getElementById("sp3").innerText="√ 密码强度：弱";

            } else if (reg2.test(upValue) && upValue.length >= 12 && upValue.length <= 18) {
                document.getElementById("sp3").innerText="√ 密码强度：一般";

            } else if (reg2.test(upValue) && upValue.length > 18) {
                document.getElementById("sp3").innerText="√ 密码强度：强";

            } else if (upValue == "") {
                document.getElementById("sp3").innerText= "";
            } else {
                document.getElementById("sp3").innerText="× 密码长度不能少于6个字符";

            }
        }
        function recheckUpass() {
            var psw1 = document.getElementById("upass1").value;
            var psw2 = document.getElementById("upass2").value;

            if (psw1 == psw2) {
                document.getElementById("sp4").innerText="√";
            } else if (psw2 == "") {
                document.getElementById("sp4").innerText="";
            } else {
                document.getElementById("sp4").innerText="× 确认密码与密码不同";
            }
        }
    </script>
</head>
<body id="bd">
<form action="user/register" method="post">
    <h1 id="title1" style="text-align: center">欢迎来到注册页面</h1>
    <fieldset id="fd1">

        <div class="dc1">
            <span style="color: red">*</span>
            用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input placeholder="用户名设置成功后不能修改" type="text" id="uname" name="username" class="txt"
                                               onblur="checkUserName()">
            <span id="sp1" style="color: red">6-30位字母、数字或“_”，字母开头</span>
        </div>
        <div class="dc1">
            <span style="color: red">*</span>
            登录密码：<input placeholder="6-20位字母、数字或符号" type="password" id="upass1" name="userpass1" class="txt" onblur="checkUserPass1()">
            <span id="sp3"></span>
        </div>
        <div class="dc1">
            <span style="color: red">*</span>
            确认密码：<input placeholder="再次输入您的确认密码"  type="password" id="upass2" name="userpass2" class="txt" onblur="recheckUpass()">
            <span id="sp4"></span>
        </div>

        <div class="dc1">
            &nbsp;&nbsp;性别：男<input type="radio" name="sex" value="男">
            女<input type="radio" name="sex" value="女"></br>

        </div>
    </fieldset>
    <div id="d4">
        <input type="submit" name="注册" value="注册" style="font-size: 20px">
        <a href="/jump/userLogin" class="linkc1">返回登录界面</a>
        <a href="/jump/backToSuperMenu" class="linkc1">返回主界面</a>
    </div>


</form>
<h3 style="color: red">
    ${requestScope.msg}
</h3>

</body>
</html>