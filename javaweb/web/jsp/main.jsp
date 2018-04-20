<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中心机房系统</title>
</head>
<body>
    <h2>欢迎您进入机房系统</h2>
    <table>
        <tr style="color:red">
            <th>账户：</th>
            <th>用户名：</th>
            <th>性别：</th>
            <th>年龄：</th>
            <th>积分：</th>
        </tr>
        <tr>
            <td>${user.userNum}</td>
            <td>${user.userName}</td>
            <td>${user.userSex}</td>
            <td>${user.userAge}</td>
            <td>${user.credits}</td>
        </tr>
    </table>
</body>
</html>