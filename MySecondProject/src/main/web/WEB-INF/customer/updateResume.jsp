<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/19
  Time: 14:48
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
            <td><input class="tc1" type="text" name="rsm_name" value="${sessionScope.MyResume.rsm_name}" onkeydown='if(event.keyCode==13) return false;'></td>
            <td>性别</td>
            <td><input type="text" name="rsm_gender" value="${sessionScope.MyResume.rsm_gender}" onkeydown='if(event.keyCode==13) return false;'></td>
            <td rowspan="4" width="200px"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input class="tc1" type="number" name="rsm_age" min="18" value="${sessionScope.MyResume.rsm_age}" onkeydown='if(event.keyCode==13) return false;'></td>
            <td>民族</td>
            <td><input class="tc1" type="text" name="rsm_nationality" value="${sessionScope.MyResume.rsm_nationality}" onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><input class="tc1" type="text" name="rsm_college" value="${sessionScope.MyResume.rsm_college}" onkeydown='if(event.keyCode==13) return false;'></td>
            <td>专业</td>
            <td><input class="tc1" type="text" name="rsm_major" value="${sessionScope.MyResume.rsm_major}" onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>学历</td>
            <td><input class="tc1" type="text" name="rsm_edu_bg" value="${sessionScope.MyResume.rsm_edu_bg}" onkeydown='if(event.keyCode==13) return false;'></td>
            <td>邮编</td>
            <td><input class="tc1" type="text" name="rsm_post" value="${sessionScope.MyResume.rsm_post}" onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td><input class="tc1" type="number" name="rsm_phone" value="${sessionScope.MyResume.rsm_phone}" onkeydown='if(event.keyCode==13) return false;'></td>
            <td>籍贯</td>
            <td colspan="2"><input class="tc1" type="text" name="rsm_hometown" value="${sessionScope.MyResume.rsm_hometown}" onkeydown='if(event.keyCode==13) return false;'></td>

        </tr>
        <tr>
            <td>电子邮件</td>
            <td colspan="4"><input class="tc1" type="text" name="rsm_email" value="${sessionScope.MyResume.rsm_email}" onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>地址</td>
            <td colspan="4"><input class="tc1" type="text" name="rsm_addr" value="${sessionScope.MyResume.rsm_addr}" onkeydown='if(event.keyCode==13) return false;'></td>
        </tr>
        <tr>
            <td>自我评价</td>
            <td colspan="4"><textarea name="rsm_self_eval" value="${sessionScope.MyResume.rsm_self_eval}" class="ta1"></textarea></td>
        </tr>
        <tr>
            <td>专业介绍</td>
            <td colspan="4"><textarea name="rsm_major_intro" value="${sessionScope.MyResume.rsm_major_intro}" class="ta1"></textarea></td>
        </tr>
        <tr>
            <td>英语水平</td>
            <td colspan="4"><textarea name="rsm_e_level" value="${sessionScope.MyResume.rsm_e_level}" class="ta1"></textarea></td>
        </tr>
        <tr>
            <td>计算机水平</td>
            <td colspan="4"><textarea name="rsm_comp_level" value="${sessionScope.MyResume.rsm_comp_level}" class="ta1"></textarea></td>
        </tr>
        <tr>
            <td>社会实践</td>
            <td colspan="4"><textarea name="rsm_social_prac" value="${sessionScope.MyResume.rsm_social_prac}" class="ta1"></textarea></td>
        </tr>
    </table>
    <input type="submit" value="修改" onclick="this.form.action='resume/updateResume'">

    <input type="submit" value="返回" onclick="this.form.action='user/checkUserMenu'">
</form>

<h3 style="color: red">
    ${requestScope.msg}
</h3>
</body>
</html>