<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/26
  Time: 9:44
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
<form action="admin/addJob" method="post">
    部门：<select id="dep_name" >
    <option id="op1">--请选择--</option>
    <c:forEach items="${sessionScope.deps}" var="d">
        <option class="opc1" value="${d.dep_id}"><c:out value="${d.dep_name}"></c:out></option>
    </c:forEach>
</select>
    职位名：<input type="text" name="job_name" required>
    <input type="submit" value="保存">
</form>
<form action="jump/toHRmanage" method="post">
    <input type="submit" value="返回">
</form>
</body>
</html>
