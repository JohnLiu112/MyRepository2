<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/25
  Time: 19:43
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
                            for (var i=0;i<jobs.length;i++){
                                var option = document.createElement("option");
                                option.text =jobs[i].job_name;
                                option.value =jobs[i].job_id;
                                document.getElementById("job_name").appendChild(option);
                            }
                        }
                    })
                }
            })
        });
    </script>
</head>
<body>
<form action="admin/createNewEmp" method="post">
    offer注意内容：<textarea name="oe_info"></textarea><br/>
    员工账号id：<input type="text" name="oe_emp_name" readonly value="${sessionScope.resume.rsm_email}">
    员工账号密码：<input type="text" name="oe_emp_pass" readonly value="${sessionScope.resume.rsm_phone}"><br/>
    部门：<select name="dep_id" id="dep_name" >
    <option id="op1">--请选择--</option>
    <c:forEach items="${sessionScope.deps}" var="d">
        <option class="opc1" name="dep_id" value="${d.dep_id}"><c:out value="${d.dep_name}"></c:out></option>
    </c:forEach>
</select>
    职位：<select name="job_id" id="job_name">
    <option>--请选择--</option>
</select>
    薪资：<input name="emp_salary" type="number" >
    <input name="rsm_id" type="hidden" value="${sessionScope.resume.rsm_id}" >
    <input type="submit" value="发送offer" >
</form>
</body>
</html>
