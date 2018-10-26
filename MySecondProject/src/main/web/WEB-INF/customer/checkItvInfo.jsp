<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/24
  Time: 11:14
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
    <c:forEach var="i" items="${sessionScope.itvInfos}">
        <span><c:out value="${i.itvInfo_info}"></c:out></span>
        <span><c:out value="${i.itvInfo_itv_time}"></c:out></span>
    </c:forEach>
    <input type="submit" value="确认面试" onclick="this.form.action='recru/confirmItv'">
    <input type="hidden" name="offer_id" value="${i.itvInfo_offer_id}">
    <br/>
    <c:if test="${sessionScope.totalPages!=0}">
        <c:forEach  begin="1" end="${sessionScope.totalPages}" var="i">
            <a href="recru/checkItvInfo1?currentPage=${i}">${i}</a>
        </c:forEach>
    </c:if>

</form>
<form action="" method="post">
    <input type="submit" value="返回" onclick="this.form.action='recru/checkRecru?currentPage=1'">
</form>

<h3 style="color:red;">${requestScope.msg}</h3>
</body>
</html>
