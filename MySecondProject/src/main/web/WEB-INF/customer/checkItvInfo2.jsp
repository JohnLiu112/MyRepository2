<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/24
  Time: 13:19
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


    <c:if test="${sessionScope.totalPages!=0}">
        <c:forEach  begin="1" end="${sessionScope.totalPages}" var="i">
            <a href="recru/checkItvInfo2?currentPage=${i}">${i}</a>
        </c:forEach>
    </c:if>
</form>
<form action="" method="post">
    <input type="submit" value="返回" onclick="this.form.action='recru/checkRecru?currentPage=1'">
</form>
</body>
</html>
