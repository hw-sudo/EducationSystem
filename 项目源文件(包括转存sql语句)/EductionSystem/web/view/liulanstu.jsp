<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生选课信息</title>

</head>
<body>
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>
<div align="center">
    <h1 style="color: black;">课程信息列表</h1>
    <table class="tb">

        <tr>
            <td>课程编号</td>
            <td>学生学号</td>
            <td>&nbsp&nbsp姓名&nbsp</td>
            <td>性别</td>
            <td>班级</td>
            <td>&nbsp&nbsp&nbsp专业&nbsp</td>
            <td>成绩</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${jibens}" var="item">
            <tr>
                <td>${item.cpid}</td>
                <td>${item.spid}</td>
                <td>${item.stuname}</td>
                <td>${item.sex}</td>
                <td>${item.banji}</td>
                <td>${item.ye}</td>
                <td>${item.score}</td>
                <td><a href="del?&spid=${item.spid}&cpid=${item.cpid}">删除</a> | <a href="broinfo?&spid=${item.spid}&cpid=${item.cpid}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>