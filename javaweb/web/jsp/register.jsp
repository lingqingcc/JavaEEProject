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
    <link href="/resources/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div style="width: 100%;height: auto">
        <div class="register_page">
            <c:if test="${!empty error}">
                <font color="red"><c:out value="${error}" /></font>
            </c:if>
            <h1 style="text-align: center">用户注册</h1>
            <form action="create.html" method="post">
                用户名:
                <input class="input_text" type="text" name="userName">
                <br><br>
                年龄：
                <input class="input_text" type="text" name="userAge">
                <br>
                <p><label>性别：</label>
                    <label>男</label>
                    <input type="radio" value="男"  name="userSex" />
                    <label>女</label>
                    <input type="radio" value="女"  name="userSex" />
                </p>
                账号：
                <input class="input_text" type="text" name="userNum">
                <br><br>
                密码：
                <input class="input_text" type="password" name="password">
                <br><br>
                <div style="text-align: center">
                    <input class="main_button" type="submit" value="注册" />
                </div>

            </form>
        </div>

    </div>
</body>
</html>
