<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/23
  Time: 15:11
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
    <script src="<%=request.getContextPath()%>/Resources/jquery-3.2.1.js"></script>
    <title>Title</title>

</head>
<body>
<form action="" method="post">
    <div>
        <table border="1">
            <c:forEach var="o" items="${sessionScope.offers}">

                <tr>
                    <td>
                        <c:forEach items="${sessionScope.recrus}" var="recrus">
                            <c:if test="${o.offer_recru_id==recrus.recru_id}">
                                <c:out value="${recrus.recru_job_name}"></c:out>
                            </c:if>
                        </c:forEach>
                    </td>
                    <form action="" method="post">
                        <td>
                            <input type="submit"  value="发送offer" onclick="this.form.action='recru/checkRecruDetails'">
                            <input type="hidden" name="recru_id" value="${o.offer_recru_id}">
                        </td>
                    </form>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${sessionScope.recrus}" var="recrus">
                            <c:if test="${o.offer_recru_id==recrus.recru_id}">
                                <c:out value="${recrus.recru_salary}"></c:out>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${sessionScope.recrus}" var="recrus">
                            <c:if test="${o.offer_recru_id==recrus.recru_id}">
                                <c:out value="${recrus.recru_firm_name}"></c:out>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${sessionScope.recrus}" var="recrus">
                            <c:if test="${o.offer_recru_id==recrus.recru_id}">
                                <c:out value="${recrus.recru_firm_bonus}"></c:out>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${sessionScope.recrus}" var="recrus">
                            <c:if test="${o.offer_recru_id==recrus.recru_id}">
                                <c:out value="${recrus.recru_workplace}"></c:out>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${sessionScope.totalPages!=0}">
            <c:forEach  begin="1" end="${sessionScope.totalPages}" var="i">
                <a href="recru/toJobApplied?currentPage=${i}">${i}</a>
            </c:forEach>
        </c:if>
    </div>
</form>
<form action="user/adminMenu" method="post">
    <input type="submit" value="返回">
</form>
</body>
</html>
