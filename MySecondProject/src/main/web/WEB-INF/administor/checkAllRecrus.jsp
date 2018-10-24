<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/24
  Time: 16:07
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

        <table border="1">
            <c:forEach var="r" items="${sessionScope.recrus}">
                <tr>
                    <td>
                        <c:out value="${r.recru_job_name}"></c:out>
                    </td>
                    <form action="" method="post">
                        <td>
                            <input type="submit" value="查看" onclick="this.form.action='recru/checkRecruDetails'">
                            <input type="hidden" name="recru_id" value="${r.recru_id}">
                        </td>
                    </form>
                </tr>
                <tr>
                    <td><c:out value="${r.recru_salary}"></c:out></td>
                    <td><c:out value="${r.recru_firm_name}"></c:out></td>
                </tr>
                <tr>
                    <td><c:out value="${r.recru_firm_bonus}"></c:out></td>
                    <td><c:out value="${r.recru_workplace}"></c:out></td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${sessionScope.totalPages!=0}">
            <c:forEach  begin="1" end="${sessionScope.totalPages}" var="i">
                <a href="recru/toCheckAllRecrus?currentPage=${i}">${i}</a>
            </c:forEach>
        </c:if>
    </div>
</form>
</body>
</html>
