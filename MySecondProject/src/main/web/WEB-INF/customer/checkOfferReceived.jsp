<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/25
  Time: 16:57
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
<c:forEach var="i" items="${sessionScope.offerEmails1}">
    <span><c:out value="${i.oe_info}"></c:out></span><br/>
    <span><c:out value="${i.oe_emp_name}"></c:out></span><br/>
    <span><c:out value="${i.oe_emp_pass}"></c:out></span><br/>
</c:forEach>


<c:if test="${sessionScope.totalPages!=0}">
    <c:forEach  begin="1" end="${sessionScope.totalPages}" var="i">
        <a href="recru/checkOfferReceived?currentPage=${i}">${i}</a>
    </c:forEach>
</c:if>

<form action="" method="post">
    <input type="submit" value="返回" onclick="this.form.action='recru/checkRecru?currentPage=1'">
</form>
</body>
</html>
