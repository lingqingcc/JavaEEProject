<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/21 0021
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>机房用户信息管理页面</title>
</head>
<body>
    <h1>机房信息后台管理</h1>
    <p><a href="gain.html" methods="Get">获取用户信息</a></p>
    <p><a href="register.html" methods="GET">添加用户</a></p>
    <table style="width: 600px">
        <tr style="color:red">
            <th>Id：</th>
            <th>账户：</th>
            <th>用户名：</th>
            <th>性别：</th>
            <th>年龄：</th>
            <th>密码：</th>
            <th>积分：</th>
        </tr>
        <c:forEach items="${userList}" var="user">
        <tr>
            <td id="userId">${user.userId}</td>
            <td >${user.userNum}</td>
            <td >${user.userName}</td>
            <td >${user.userSex}</td>
            <td >${user.userAge}</td>
            <td >${user.password}</td>
            <td >${user.credits}</td>
            <td><a href="${pageContext.request.contextPath}/reviseuser.html?userNum=${user.userNum}">修改</a><td/>
            <td><a href="${pageContext.request.contextPath}/deleteuser.html?delId=${user.userId}">删除</a><td/>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
