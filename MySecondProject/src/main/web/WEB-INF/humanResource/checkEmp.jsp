<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/26
  Time: 22:06
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
    <script>
        $(function () {
            $("#dep_name").change(function () {
                if ($("#dep_name").val()=="--请选择--"){
                    document.getElementById("job_name").options.length=0;
                    var option = document.createElement("option");
                    option.text ="--请选择--";
                    document.getElementById("job_name").appendChild(option);
                }else {
                    $.ajax({
                        type:"post",
                        url:"admin/findJobsByDepId",
                        data:{"dep_id":$("#dep_name").val()},
                        dataType:"json",
                        success:function (jobs) {
                            document.getElementById("job_name").options.length=0;
                            var option = document.createElement("option");
                            option.text ="--请选择--";
                            document.getElementById("job_name").appendChild(option);
                            for (var i=0;i<jobs.length;i++){
                                var option1 = document.createElement("option");
                                option1.text =jobs[i].job_name;
                                option1.value =jobs[i].job_id;
                                document.getElementById("job_name").appendChild(option1);
                            }
                        }
                    });
                }
            });

            $("#job_name").change(function () {
                if ($("#job_name").val()=="--请选择--"){
                    document.getElementById("emp_name").options.length=0;
                    var option = document.createElement("option");
                    option.text ="--请选择--";
                    document.getElementById("emp_name").appendChild(option);
                }else {
                    $.ajax({
                        type:"post",
                        url:"admin/findEmpsByJobId",
                        data:{"job_id":$("#job_name").val()},
                        dataType:"json",
                        success:function (emps) {
                            document.getElementById("emp_name").options.length=0;
                            var option = document.createElement("option");
                            option.text ="--请选择--";
                            document.getElementById("emp_name").appendChild(option);
                            for (var i=0;i<emps.length;i++){
                                var option1 = document.createElement("option");
                                option1.text =emps[i].emp_name;
                                option1.value =emps[i].emp_id;
                                document.getElementById("emp_name").appendChild(option1);
                            }
                        }
                    })
                }
            })

        });
    </script>
</head>
<body>
<form action="admin/getEmpById" method="post">
    <fieldset>
        <legend>查看员工</legend>
        部门：<select id="dep_name" >
        <option>--请选择--</option>
        <c:forEach items="${sessionScope.deps}" var="d">
            <option  value="${d.dep_id}"><c:out value="${d.dep_name}"></c:out></option>
        </c:forEach>
    </select>
        </select>
        职位：<select id="job_name">
        <option>--请选择--</option>
    </select>
        职位：<select id="emp_name" name="emp_id">
        <option>--请选择--</option>
    </select>
        <input type="submit" value="查询">
    </fieldset>
</form>
<c:if test="${sessionScope.emp!=null}">
    <fieldset>
        <legend>员工信息</legend>
        <form action="jump/toChangeJob" method="post">
            <table>
                <tr>
                    <td>员工姓名</td>
                    <td>员工账号</td>
                    <td>员工密码</td>
                    <td>员工性别</td>
                    <td>员工年龄</td>
                    <td>员工家庭住址</td>
                    <td>员工薪水</td>
                    <td>员工所属职位</td>
                    <td>员工所属部门</td>
                    <td>员工状态</td>
                    <td>员工离职原因</td>
                    <td>员工联系方式</td>
                    <td>员工邮箱</td>
                    <td colspan="2">
                        <input type="submit" value="换岗">
                        <input type="hidden" name="emp_id" value="${sessionScope.emp.emp_id}">
                    </td>
                </tr>
                <tr>
                    <td>${sessionScope.emp.emp_name}</td>
                    <td>${sessionScope.emp.emp_account}</td>
                    <td>${sessionScope.emp.emp_pass}</td>
                    <td>${sessionScope.emp.emp_gender}</td>
                    <td>${sessionScope.emp.emp_age}</td>
                    <td>${sessionScope.emp.emp_hometown}</td>
                    <td>${sessionScope.emp.emp_salary}</td>
                    <td>${sessionScope.job.job_name}</td>
                    <td>${sessionScope.dep.dep_name}</td>
                    <td>
                        <c:if test="${sessionScope.emp.emp_on_off==0}">
                            <c:out value="实习"></c:out>
                        </c:if>
                        <c:if test="${sessionScope.emp.emp_on_off==1}">
                            <c:out value="在职"></c:out>
                        </c:if>
                        <c:if test="${sessionScope.emp.emp_on_off==2}">
                            <c:out value="离职"></c:out>
                        </c:if>
                    </td>
                    <td>${sessionScope.emp.emp_off_reason}</td>
                    <td>${sessionScope.emp.emp_phoneNum}</td>
                    <td>${sessionScope.emp.emp_email}</td>
                </tr>
            </table>
        </form>
    </fieldset>
</c:if>
</body>
</html>
