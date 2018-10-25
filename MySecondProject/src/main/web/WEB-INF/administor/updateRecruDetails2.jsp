<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/25
  Time: 10:50
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
        tr{
            border-width: thin;
        }
        td{
            border-width: thin;
        }
        #t1{
            width: 800px;
            height: 600px;
        }
        td> input{
            width: 100%;
            height: 100%;
        }
        textarea{
            width: 100%;
            height:100%;
            resize: none;
        }
    </style>
</head>
<body>

<form action="" method="post">
    <table border="1" cellspacing="0" id="t1">
        <tr>
            <td>职位名称</td>
            <td><input class="tc1" type="text" name="recru_job_name" value="${sessionScope.recru.recru_job_name}" onkeydown='if(event.keyCode==13) return false;'></td>
            <td>公司名称</td>
            <td><input class="tc1" type="text" name="recru_firm_name" value="${sessionScope.recru.recru_firm_name}" onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>薪资</td>
            <td><input class="tc1" type="text" name="recru_salary" value="${sessionScope.recru.recru_salary}"  onkeydown='if(event.keyCode==13) return false;'></td>
            <td>工作地点</td>
            <td><input class="tc1" type="text" name="recru_workplace" value="${sessionScope.recru.recru_workplace}"  onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>发布时间</td>
            <td colspan="3"><input class="tc1" type="text" name="recru_release_time" value="${sessionScope.recru.recru_release_time}"  onkeydown='if(event.keyCode==13) return false;'></td>

        </tr>
        <tr>
            <td>具体工作地点</td>
            <td colspan="3"><input class="tc1" type="text" name="recru_spec_wp" value="${sessionScope.recru.recru_spec_wp}"  onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>工作要求</td>
            <td colspan="3"><textarea name="recru_job_requirement" class="ta1"><c:out value="${sessionScope.recru.recru_job_requirement}"></c:out>
            </textarea></td>
        </tr>
        <tr>
            <td>工作任务</td>
            <td colspan="3"><textarea name="recru_job_duties" class="ta1"><c:out value="${sessionScope.recru.recru_job_duties}"></c:out>
            </textarea></td>
        </tr>
        <tr>
            <td>部门信息</td>
            <td colspan="3"><textarea name="recru_dep_info" class="ta1"><c:out value="${sessionScope.recru.recru_dep_info}"></c:out>
            </textarea></td>
        </tr>
        <tr>
            <td>公司介绍</td>
            <td colspan="3"><textarea name="recru_firm_intro" class="ta1"><c:out value="${sessionScope.recru.recru_firm_intro}"></c:out>
            </textarea></td>
        </tr>
        <tr>
            <td>公司福利</td>
            <td colspan="3"><textarea name="recru_firm_bonus" class="ta1"><c:out value="${sessionScope.recru.recru_firm_bonus}"></c:out>
            </textarea></td>
        </tr>
    </table>
    <td>
        <input type="submit" value="修改" onclick="this.form.action='recru/updateRecruDetails1'">
        <input type="hidden" name="recru_id" value="${sessionScope.recru.recru_id}">
        <input class="tc1" type="hidden" name="recru_state" value="${sessionScope.recru.recru_state}">
    </td>
</form>
<form action="" method="post">
    <input type="submit" value="返回" onclick="this.form.action='user/adminMenu'">
</form>
</body>
</html>
