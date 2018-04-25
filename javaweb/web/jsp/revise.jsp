<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24 0024
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改</title>
</head>
<body>
    <h1>用户信息修改</h1>
    <form action="revise.html" method="post">
        用户Id：<input type="text"name="userId" value="${user.userId}"><br>
         账号：<input type="text"name="userNum" value="${user.userNum}"><br>
        用户名：<input type="text"name="userName" value="${user.userName}"><br>
        年龄：<input type="text"name="userAge" value="${user.userAge}"><br>
        性别：<input type="text"name="userSex" value="${user.userSex}"><br>
        密码：<input type="text"name="password" value="${user.password}"><br>
        积分：<input type="text"name="credits" value="${user.credits}"><br>
        <input type="button" value="确定修改">
    </form>


</body>
</html>
