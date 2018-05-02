<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>登陆页面</title>
		<link href="/resources/css/index.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="height: 15%">
		</div>
		<div class="login_bg">
			<div style="width: 50%;height:100%;float: left">
			</div>
			<div style="width: 50%;height:100%;float: left;text-align: center">
				<div class="login_page">
					<div>
						<c:if test="${!empty error}">
							<font color="red"><c:out value="${error}" /></font>
						</c:if>
					</div>
					<h1>中心机房登陆系统</h1>
					<form action="<c:url value="loginCheck.html"/>" method="post">
						账号：
						<input class="input_text" type="text" name="userNum">
						<br><br>
						密码：
						<input class="input_text" type="password" name="password">
						<br><br>
						<input class="main_button" type="submit" value="登录" />
						<input class="main_button" type="reset" value="重置" />
					</form>
					<br>
					<a href="register.html" methods="GET">注册</a>
					<a href="manage.html" methods="GET">信息管理</a>
				</div>
			</div>
		</div>

	</body>
</html>
