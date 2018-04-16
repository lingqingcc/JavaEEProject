<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/13 0013
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}" /></font>
    </c:if>
    <form action="<c:url value="create.html"/>" method="post">
        用户名：
        <input type="text" name="userName">
        <br>
        密 码：
        <input type="password" name="password">
        <br>
        <input type="submit" value="注册" />
    </form>
</body>
</html>
