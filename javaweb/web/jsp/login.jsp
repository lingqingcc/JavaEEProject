<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>登陆页面</title>
	</head>
	<body>
		<c:if test="${!empty error}">
	        <font color="red"><c:out value="${error}" /></font>
		</c:if>
		<h1>中心机房登陆系统</h1>
		<form action="<c:url value="loginCheck.html"/>" method="post">
			账号：
			<input type="text" name="userNum">
			<br>
			密码：
			<input type="password" name="password">
			<br>
			<input type="submit" value="登录" />
			<input type="reset" value="重置" />
		</form>
		<a href="register.html" methods="GET">注册</a>
		<a href="manage.html" methods="GET">信息管理</a>
	</body>
</html>
