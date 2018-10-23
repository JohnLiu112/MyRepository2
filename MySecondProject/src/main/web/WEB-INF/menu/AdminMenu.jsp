<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/9/17
  Time: 10:18
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
<h1 id="title1" style="text-align: center">欢迎来到管理员菜单</h1>
<h3 id="title2" style="text-align: left">
    管理员：${adminName}
</h3>
<ul id="u1">
    <li class="lc1"><a href="recru/toAddRecru" class="ac1">添加招聘信息</a></li>
    <li class="lc1"><a href="recru/toCheckRecrus" class="ac1">查看已收求职信息</a></li>
</ul>
<h3 style="color: red">${requestScope.error}</h3>
</body>
</html>
