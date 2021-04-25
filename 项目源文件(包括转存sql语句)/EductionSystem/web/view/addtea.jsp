<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加教师信息</title>
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
    <form action="../add?method=addtea"  method="post"  onsubmit="return check()">

        <tr>
            <td>教师工号:</td>
            <td><input type="text" name="tpid" id="tpid"></td>
        </tr>
        <tr>
            <td>教师姓名：</td>
            <td><input type="text" name="teaname" id="teaname"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <select name="sex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>教师所在学院：</td>
            <td><input type="text" name="txueyuan" id="txueyuan"></td>
        </tr>
        <tr>
            <td>职称：</td>
            <td>
                <select name="zhicheng">
                    <option value="教授">教授</option>
                    <option value="副教授">副教授</option>
                    <option value="讲师">讲师</option>
                    <option value="助教">助教</option>
                </select>
            </td>
        </tr>

        <tr align="center">
            <th colspan="2">
                <input type="submit" value="提交">
            </th>
        </tr>
    </form>
</table>
</body>
</html>