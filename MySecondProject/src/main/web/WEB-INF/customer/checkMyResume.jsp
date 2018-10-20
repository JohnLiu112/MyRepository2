<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/19
  Time: 22:20
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
<h2>个人简历</h2>
<form action="" method="post">
    <table border="1" cellspacing="0" id="t1">
        <tr>
            <td>姓名</td>
            <td>
                <span>${sessionScope.MyResume.rsm_name}</span>
            </td>
            <td>性别</td>
            <td><span>${sessionScope.MyResume.rsm_gender}</span></td>
            <td rowspan="4" width="200px"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><span>${sessionScope.MyResume.rsm_age}</span></td>
            <td>民族</td>
            <td><span>${sessionScope.MyResume.rsm_nationality}</span></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><span>${sessionScope.MyResume.rsm_college}</span></td>
            <td>专业</td>
            <td><span>${sessionScope.MyResume.rsm_major}</span></td>
        </tr>
        <tr>
            <td>学历</td>
            <td><span>${sessionScope.MyResume.rsm_edu_bg}</span></td>
            <td>邮编</td>
            <td><span>${sessionScope.MyResume.rsm_post}</span></td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td><span>${sessionScope.MyResume.rsm_phone}</span></td>
            <td>籍贯</td>
            <td colspan="2"><span>${sessionScope.MyResume.rsm_hometown}</span></td>

        </tr>
        <tr>
            <td>电子邮件</td>
            <td colspan="4"><span>${sessionScope.MyResume.rsm_email}</span></td>
        </tr>
        <tr>
            <td>地址</td>
            <td colspan="4"><span>${sessionScope.MyResume.rsm_addr}</span></td>
        </tr>
        <tr>
            <td>自我评价</td>
            <td colspan="4"><span>${sessionScope.MyResume.rsm_self_eval}</span></td>
        </tr>
        <tr>
            <td>专业介绍</td>
            <td colspan="4"><span>${sessionScope.MyResume.rsm_major_intro}</span></td>
        </tr>
        <tr>
            <td>英语水平</td>
            <td colspan="4"><span>${sessionScope.MyResume.rsm_e_level}</span></td>
        </tr>
        <tr>
            <td>计算机水平</td>
            <td colspan="4"><span>${sessionScope.MyResume.rsm_comp_level}</span></td>
        </tr>
        <tr>
            <td>社会实践</td>
            <td colspan="4"><span>${sessionScope.MyResume.rsm_social_prac}</span></td>
        </tr>
    </table>
    <input type="submit" value="修改" onclick="this.form.action='resume/toUpdateResume'">
</form>
<input type="submit" value="返回" onclick="this.form.action='user/checkUserMenu'">

</body>
</html>
