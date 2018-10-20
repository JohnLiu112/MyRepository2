<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/9/28
  Time: 19:35
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
        #bd {
            background-color: ghostwhite;
        }
        ul li{
            list-style-type: none;
        }
    </style>
</head>
<body id="bd">
<h1 id="title1" style="text-align: center">欢迎来到用户菜单</h1>
<h3 id="title2" style="text-align: left">
    用户：${sessionScope.u.u_name}
    用户id：${sessionScope.u.u_id}
</h3>
<form action="" method="post">
    <ul id="u1">
        <li><input type="submit" value="编辑个人简历" onclick="this.form.action='resume/toAddResume'"></li>
        <li><input type="submit" value="更新个人简历" onclick="this.form.action='resume/toUpdateResume'"></li>
    </ul>
</form>

<h3 style="color: red">${requestScope.error}</h3>
</body>
</html>
