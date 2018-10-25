<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/24
  Time: 16:15
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
</head>
<body>
<form action="" method="post">
    <table>
        <tr>
            <td>
                职位名称：<c:out value="${sessionScope.recru.recru_job_name}"></c:out>
            </td>
            <td>
                薪资：<span style="color: red"><c:out value="${sessionScope.recru.recru_salary}"></c:out></span>
            </td>
        </tr>
        <tr>
            <td>福利：<c:out value="${sessionScope.recru.recru_firm_bonus}"></c:out></td>
            <td>具体工作地点：<c:out value="${sessionScope.recru.recru_spec_wp}"></c:out></td>
        </tr>
        <tr>

        </tr>
        <tr>

        </tr>
        <tr>
            <td colspan="2">
                <p>
                    <span>工作要求：<c:out value="${sessionScope.recru.recru_job_requirement}"></c:out></span></br>
                    <span>工作任务：<c:out value="${sessionScope.recru.recru_job_duties}"></c:out></span>
                </p>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <p>
                    <span>部门信息：<c:out value="${sessionScope.recru.recru_dep_info}"></c:out></span></br>
                    <span>公司简介：<c:out value="${sessionScope.recru.recru_firm_intro}"></c:out></span>
                </p>
            </td>
        </tr>
    </table>

</form>
<form action="user/adminMenu" method="post">
    <input type="submit" value="返回">
</form>
<h3 style="color: red">${requestScope.msg}</h3>
</body>
</html>
