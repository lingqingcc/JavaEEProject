<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/21 0021
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>机房信息管理页面</title>
</head>
<body>
    <h1>机房信息后台管理</h1>
    <a href="gain.html" methods="Get">获取学生信息</a>
    <table style="width: 600px">
        <tr style="color:red">
            <th align="center">Id：</th>
            <th align="center">账户：</th>
            <th align="center">用户名：</th>
            <th align="center">性别：</th>
            <th align="center">年龄：</th>
            <th align="center">密码</th>
            <th align="center">积分：</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td align="center">${user.userId}</td>
                <td align="center">${user.userNum}</td>
                <td align="center">${user.userName}</td>
                <td align="center">${user.userSex}</td>
                <td align="center">${user.userAge}</td>
                <td align="center">${user.password}</td>
                <td align="center">${user.credits}</td>
                <td><a href="deleteuser?id=${user.userId}" methods="Get">删除</a></td>
                <td><a href="reviseuser?id=${user.userId}" methods="Get">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
