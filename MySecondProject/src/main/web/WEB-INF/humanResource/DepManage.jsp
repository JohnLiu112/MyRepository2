<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘俊杰
  Date: 2018/10/26
  Time: 9:04
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
                    $.ajax({
                        type:"post",
                        url:"admin/toCheckDep",
                        data:{"dep_id":$("#dep_name").val()},
                        dataType:"json",
                        success:function (dep) {
                            $("#depName1").val(dep.dep_name);
                            $("#depEmpNum1").val(dep.dep_emp_num);
                            $("#depId1").val(dep.dep_id);
                            $("#depName2").val(dep.dep_name);
                            $("#depEmpNum2").val(dep.dep_emp_num);
                            $("#depId2").val(dep.dep_id);
                        }
                    })
            })
        });
    </script>
</head>
<body>
<fieldset>
    <legend>查看部门</legend>
    部门：<select id="dep_name" >
    <c:forEach items="${sessionScope.deps}" var="d">
        <option  value="${d.dep_id}"><c:out value="${d.dep_name}"></c:out></option>
    </c:forEach>
</select>
</fieldset>
<fieldset>
    <legend>添加部门</legend>
    <form action="admin/addDep" method="post">
        <div class="layui-inline">
            部门名称：<input type="text" name="dep_name" required><br/>
            部门人数：<input type="number" name="dep_emp_num" required>
        </div>
        <input type="submit" value="保存">
    </form>
</fieldset>

<fieldset>
    <legend>修改部门</legend>
    <form action="" method="post">
        <div class="layui-inline">
            部门名称：<input id="depName1" type="text" name="dep_name1" readonly>
            &nbsp;&nbsp;部门人数：<input id="depEmpNum1" type="number" name="dep_emp_num1" readonly><br/>
            修改名称：<input type="text" name="dep_name2" required>
            &nbsp;&nbsp;修改人数：<input type="number" name="dep_emp_num2" required>
            <input type="hidden" id="depId1" name="dep_id">
            <input type="submit" value="修改" onclick="this.from.action='/admin/updateDep'">
            <input type="submit" value="删除" onclick="this.from.action='/admin/deleteDep'">
        </div>
    </form>
</fieldset>

<fieldset>
    <legend>删除部门</legend>
    <form action="/admin/deleteDep" method="post">
        <div class="layui-inline">
            部门名称：<input id="depName2" type="text" name="dep_name1" readonly>
            &nbsp;&nbsp;部门人数：<input id="depEmpNum2" type="number" name="dep_emp_num1" readonly><br/>
            <input type="hidden" id="depId2" name="dep_id">
            <input type="submit" value="删除">
        </div>
    </form>
</fieldset>


<form action="jump/toHRmanage" method="post">
    <input type="submit" value="返回">
</form>


</body>
</html>
