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
    <base href="<%=basePath%>">
    <title>$Title$</title>

    <style>
        #bd{
            background-color: ghostwhite;
        }
        #d1{
            background-color: blanchedalmond;
            width: 500px;
            height: 500px;
            margin: 100px 0px 0px 650px ;
            border: solid 1px;
            border-radius: 15px;
        }
        .dc2{
            margin: 50px 0px 0px 0px ;
            font-size: 20px;
        }
        .linkc1{
            text-decoration: Window;
            padding: 0px 0px 0px 0px;
        }
    </style>
</head>
<body id="bd">

<form action="" method="post">
    <h1 id="title1" style="text-align: center">欢迎来到登录页面</h1>
    <div id="d1" class="dc1">
        <div class="dc2">
            用户：<input type="text" name="uname"></br>
        </div>
        <div class="dc2">
            密码：<input type="password" name="upass"></br>
        </div>
        <div class="dc2">
            <input type="checkbox" name="autoLogin">下次自动登录</br>
        </div>
        <div class="dc2">
            <input type="submit" name="登录" value="登录" onclick="this.form.action='user/loginServlet'">
            <a href="../../SuperMenu.jsp" class="linkc1">返回主界面</a>
            <a href="user/check" class="linkc1">自动登陆</a>
        </div>
    </div>


</form>
<h3 style="color: red">
    ${requestScope.msg}
</h3>
</body>
</html>
