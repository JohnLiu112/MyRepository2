<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/25
  Time: 14:12
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
    <style>
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
<body>
<h1 id="title1" style="text-align: center">人事管理菜单</h1>
<ul id="u1">
    <li class="lc1"><a href="jump/toAddNewDep" class="ac1">部门管理</a></li>
    <li class="lc1"><a href="/jump/toAddJobDep" class="ac1">职位管理</a></li>
    <li class="lc1"><a href="admin/toCheckJob" class="ac1">查看职位</a></li>
    <li class="lc1"><a href="admin/tocheckEmp" class="ac1">查看员工</a></li>
    <li class="lc1"><a href="jump/adminMenu" class="ac1">返回</a></li>
</ul>
</body>
</html>
