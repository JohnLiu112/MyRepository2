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
            float: left;
            list-style: none;
        }
        div{
            float: left;
        }
        tr{
            border-width: thin;
        }
        td{
            border-width: thin;
        }

    </style>
</head>
<body id="bd">
<h1 id="title1" style="text-align: center">欢迎来到用户菜单</h1>
<h3 id="title2" style="text-align: left">
    用户：${sessionScope.u.u_name}
    用户id：${sessionScope.u.u_id}
</h3>


<c:if test="${sessionScope.itvInfos.size()!=0}">
<a href="recru/checkItvInfo1?currentPage=1"><c:out value="您有未查看的消息"></c:out></a>
</c:if>
<c:if test="${sessionScope.itvInfos.size()==0}">
    <a href="recru/checkItvInfo2?currentPage=1"><c:out value="查看所有消息"></c:out></a>
</c:if>

<form action="" method="post">
    <div>
        <ul id="u1">
            <li><input type="submit" value="编辑个人简历" onclick="this.form.action='resume/toAddResume'"></li>
            <li><input type="submit" value="更新个人简历" onclick="this.form.action='resume/toUpdateResume'"></li>
            <li><input type="submit" value="我的申请" onclick="this.form.action='recru/toJobApplied?currentPage=1'"></li>
        </ul>
    </div>
    <br/>
    <div>
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
                <a href="recru/checkRecru?currentPage=${i}">${i}</a>
            </c:forEach>
        </c:if>
    </div>
</form>

<h3 style="color: red">${requestScope.msg}</h3>
</body>
</html>
