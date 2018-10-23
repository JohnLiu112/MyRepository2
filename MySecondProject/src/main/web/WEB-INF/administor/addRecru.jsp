<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/23
  Time: 10:10
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
    <script src="<%=request.getContextPath()%>/Resources/jquery-3.2.1.js"></script>
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
            <td><input class="tc1" type="text" name="recru_job_name" required onkeydown='if(event.keyCode==13) return false;'></td>
            <td>公司名称</td>
            <td><input type="text" name="recru_firm_name" required onkeydown='if(event.keyCode==13) return false;'></td>
            <td rowspan="4" width="200px"></td>
        </tr>
        <tr>
            <td>薪资</td>
            <td><input class="tc1" type="number" name="recru_salary" min="3000" required onkeydown='if(event.keyCode==13) return false;'></td>
            <td>工作地点</td>
            <td><input class="tc1" type="text" name="recru_workplace" required onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>招聘信息发布时间</td>
            <td><input class="tc1" type="text" name="recru_release_time" required onkeydown='if(event.keyCode==13) return false;'></td>
            <td>具体工作地点</td>
            <td><input class="tc1" type="text" name="recru_spec_wp" required onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>招聘信息状态（初始化为0）</td>
            <td colspan="4"><input class="tc1" type="text" name="recru_state" required onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>职位要求</td>
            <td colspan="4"><input class="tc1" type="text" name="recru_job_requirement" required onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>职位福利</td>
            <td colspan="4"><textarea name="recru_firm_bonus" class="ta1"></textarea></td>
        </tr>
        <tr>
            <td>工作任务</td>
            <td colspan="4"><textarea name="recru_job_duties" class="ta1"></textarea></td>
        </tr>
        <tr>
            <td>职位部门信息</td>
            <td colspan="4"><textarea name="recru_dep_info" class="ta1"></textarea></td>
        </tr>
        <tr>
            <td>公司简介</td>
            <td colspan="4"><textarea name="recru_firm_intro" class="ta1"></textarea></td>
        </tr>
    </table>
    <input type="submit" value="保存" onclick="this.form.action='recru/saveRecru'">


</form>

<form action="" method="post">
    <input type="submit" value="返回" onclick="this.form.action='user/adminMenu'">
</form>
<h3 style="color: red">
    ${requestScope.msg}
</h3>
</body>
</html>