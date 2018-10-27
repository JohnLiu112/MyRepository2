<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/26
  Time: 9:44
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
                    $("#dep_name3").val("");
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
                            for (var i=0;i<jobs.length;i++){
                                var option = document.createElement("option");
                                option.text =jobs[i].job_name;
                                option.value =jobs[i].job_id;
                                document.getElementById("job_name").appendChild(option);
                            }
                        }
                    })
                    $.ajax({
                        type:"post",
                        url:"admin/findDepByDepId",
                        data:{"dep_id":$("#dep_name").val()},
                        dataType:"json",
                        success:function (dep) {
                            $("#dep_name3").val(dep.dep_name)
                            $("#dep_name4").val(dep.dep_name)
                        }
                    })
                }
            });

            $("#job_name").change(function () {
                if ($("#job_name").val()=="--请选择--"){
                    $("#job_name3").val("");
                    $("#job_name4").val("");
                    $("#job_emp_num3").val("");
                    $("#job_emp_num4").val("");
                }else {
                    $.ajax({
                        type:"post",
                        url:"admin/findJobByJobId",
                        data:{"job_id":$("#job_name").val()},
                        dataType:"json",
                        success:function (job) {
                            $("#job_name3").val(job.job_name);
                            $("#job_name4").val(job.job_name);
                            $("#job_emp_num3").val(job.job_emp_num);
                            $("#job_emp_num4").val(job.job_emp_num);
                        }
                    })

                }
            })
        });
    </script>
</head>
<body>

    <fieldset>
        <legend>查询职位</legend>

        部门：<select id="dep_name" >
        <option id="op1">--请选择--</option>
        <c:forEach items="${sessionScope.deps}" var="d">
            <option id="opc1" value="${d.dep_id}"><c:out value="${d.dep_name}"></c:out></option>
        </c:forEach>
    </select>
        职位：<select id="job_name">
        <option>--请选择--</option>
    </select>
    </fieldset>

    <fieldset>
        <legend>添加职位</legend>
        <form action="admin/addJob" method="post">
            职位名：<input type="text" name="job_name1" required>
            部门名：<input type="text" name="dep_name1" required>
            职位员工人数：<input type="text" name="job_emp_num1" required>
            <input type="submit" value="保存">
        </form>
    </fieldset>

    <fieldset>
        <legend>修改职位</legend>
        <form action="admin/updateJob" method="post">
            职位名：<input type="text" name="job_name2" id="job_name3" readonly>
            部门名：<input type="text" name="dep_name2" id="dep_name3" readonly>
            职位员工人数：<input type="text" name="job_emp_num" id="job_emp_num3" required><br/>
            职位名：<input type="text" name="job_name3" required>
            <input type="submit" value="修改">
        </form>
    </fieldset>

    <fieldset>
        <legend>删除职位</legend>
        <form action="admin/deleteJob" method="post">
            职位名：<input type="text" name="job_name2" id="job_name4" required>
            部门名：<input type="text" name="dep_name2" id="dep_name4" required>
            职位员工人数：<input type="text" name="job_emp_num" id="job_emp_num4" required>
            <input type="submit" value="删除">
        </form>
    </fieldset>

<form action="jump/toHRmanage" method="post">
    <input type="submit" value="返回">
</form>
<h3>${requestScope.msg}</h3>
</body>
</html>
