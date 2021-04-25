<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
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
    <tr>
        <td><a href="choose?method=liulankecheng">返回选课</a></td>
    </tr>
</table>
</body>
</html>