<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程信息详情</title>
    <style>
        .a{
            margin-top: 20px;
        }
        .b{
            font-size: 20px;
            width: 160px;
            color: white;
            background-color: greenyellow;
        }
        .tb, td {
            border: 0px solid black;
            font-size: 22px;
        }
    </style>
</head>

<body>

<div align="center">
    <h1 style="color: black;">课程详细信息</h1>
    <table class="tb">

        <tr>
            <td>课程编号</td>
            <td>课程名称</td>
            <td>课程容量</td>
            <td>课程选课人数</td>
            <td>任课教师</td>
        </tr>
        <tr>
            <td>${course.cpid}</td>
            <td>${course.cname}</td>
            <td>${course.num}</td>
            <td>${course.snum}</td>
            <td>${course.jiaoshi}</td>
        </tr>
    </table>

    <table align="center" border="0px" cellpadding="10px" cellspacing="10px">
        <form action="choose?method=xuanke"  method="post"  onsubmit="return check()">
            <tr>
                <td><input type="hidden" name="cpid" id="cpid" value="${course.cpid}"></td>
            </tr>

            <tr>
                <td><input type="hidden" name="snum" id="snum" value="${course.snum}"></td>
            </tr>

            <tr>
                <td><input type="hidden" name="jiaoshi" id="jiaoshi" value="${course.jiaoshi}"></td>
            </tr>

            <tr align="center">
                <th colspan="2">
                    <input type="submit" value="选课">
                </th>
            </tr>
        </form>
    </table>

</div>

</body>
</html>