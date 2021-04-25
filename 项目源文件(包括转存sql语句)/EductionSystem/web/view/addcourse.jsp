<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加学生信息</title>
    <script>
    </script>
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
<table align="center" border="0px" cellpadding="10px" cellspacing="10px">
    <form action="../add?method=addcou"  method="post"  onsubmit="return check()">

        <tr>
            <td>课程编号:</td>
            <td><input type="text" name="cpid" id="cpid"></td>
        </tr>
        <tr>
            <td>课程名称：</td>
            <td><input type="text" name="cname" id="cname"></td>
        </tr>

        <tr>
            <td>选课人数：</td>
            <td><input type="text" name="num" id="num"></td>
        </tr>
        <tr>

        <tr align="center">
            <th colspan="2">
                <input type="submit" value="提交">
            </th>
        </tr>
    </form>
</table>
</body>
</html>