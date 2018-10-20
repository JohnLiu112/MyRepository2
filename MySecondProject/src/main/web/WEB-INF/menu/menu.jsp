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
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <style>
        #bd{
            background-color: ghostwhite;
        }
        .lc1{
            position: relative;
            list-style-type: none;
        }
        .ac1{
            text-decoration: Window;
            text-underline: none;
            font-size: 15px;
            color: black;
        }
    </style>
</head>
<body id="bd">
<h1 id="title1" style="text-align: center">欢迎来到主菜单</h1>
<ul id="u1">
    <li class="lc1"><a href="user/userLogin" class="ac1">用户登录</a></li>
    <li class="lc1"><a href="user/userRegister" class="ac1">用户注册</a></li>
</ul>

</body>
</html>
