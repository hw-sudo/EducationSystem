<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
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
    <form action="login"  method="post"  onsubmit="return check()">
        <tr><td></td></tr>
        <tr><td></td></tr>
        <tr><td></td></tr>
        <tr><td></td></tr>
        <tr><td><h1>简易教务系统1.0</h1></td></tr>
        <tr>
            <td>用户名：<input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码：&nbsp&nbsp&nbsp&nbsp<input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>验证码：<input type="text" name="inputCode"><img src="validCode" marginTop='50' height='20' width='60'/><br></td>
        </tr>
        <tr align="center">
            <th colspan="2">
                <input type="submit" value="登录">
            </th>
        </tr>
    </form>
</table>
</body>
</html>