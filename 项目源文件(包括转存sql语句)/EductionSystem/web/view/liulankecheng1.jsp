<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

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
            <td>课程名称</td>
            <td>课程容量</td>
            <td>课程选课人数</td>
            <td>任课教师</td>
        </tr>
        <c:forEach items="${course}" var="item">
            <tr>
                <td>${item.cpid}</td>
                <td>${item.cname}</td>
                <td>${item.num}</td>
                <td>${item.snum}</td>
                <td>${item.jiaoshi}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>