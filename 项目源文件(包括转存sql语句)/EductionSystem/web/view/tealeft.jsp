<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">

        .leftMenu{
            background-color:#7986CB;
            width:250px;
            height:600px;
            position:relative;
            top:0px;
        }

        .menuParent{
            background-color:#BBDEFB;
        }



    </style>
</head>
<body>

<div class="leftMenu">
    <div class="menu">


        <div class="menuParent">
            <div class="ListTitlePanel">
                <div class="ListTitle">
                    <strong>教师菜单</strong>
                    <div class="leftbgbt"></div>
                </div>
            </div>

            <div class="menuList">
                <div><a target="main_right" href="addcourse.jsp">添加课程信息</a></div>
                <div><a target="main_right" href="updatet.jsp">修改个人信息</a></div>
                <div><a target="main_right" href="../bro">浏览选课学生信息</a></div>
            </div>
        </div>


    </div>
</div>

<script type="text/javascript">



</script>

</body>
</html>