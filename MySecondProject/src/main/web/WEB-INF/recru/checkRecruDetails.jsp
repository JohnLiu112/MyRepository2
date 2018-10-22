<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/20
  Time: 15:42
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
        table{
            border-width: thin;
        }
        tr{
            border-width: thin;
        }
        td{
            border-width: thin;
        }
    </style>
</head>
<body>
<form action="" method="post">
    <table>
        <tr>
            <td><c:out value="${sessionScope.recru.recru_job_name}"></c:out></td>
            <td><span style="color: red"><c:out value="${sessionScope.recru.recru_salary}"></c:out></span></td>
        </tr>
        <tr>
            <td><c:out value="${sessionScope.recru.recru_firm_bonus}"></c:out></td>
            <td><c:out value="${sessionScope.recru.recru_spec_wp}"></c:out></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="申请职位" onclick="this.form.action='recru/job_apply'">
                <input type="hidden" name="recru_id" value="${sessionScope.recru.recru_id}">
            </td>
        </tr>
        <tr>

        </tr>
        <tr>
            <td colspan="2">
                <p>
                    <span><c:out value="${sessionScope.recru.recru_job_requirement}"></c:out></span></br>
                    <span><c:out value="${sessionScope.recru.recru_job_duties}"></c:out></span>
                </p>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <p>
                    <span><c:out value="${sessionScope.recru.recru_dep_info}"></c:out></span></br>
                    <span><c:out value="${sessionScope.recru.recru_firm_intro}"></c:out></span>
                </p>
            </td>
        </tr>
    </table>

</form>
<form action="recru/checkRecru?currentPage=1" method="post">
    <input type="submit" value="返回">
</form>
<h3 style="color: red">${requestScope.msg}</h3>
</body>
</html>
