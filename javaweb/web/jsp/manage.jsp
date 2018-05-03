<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/28 0028
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中心机房后台管理系统</title>
    <link href="/resources/css/index.css" rel="stylesheet" type="text/css" />
    <script src="/resources/js/addUser.js"></script>
</head>
<body>
<div id="main">
    <div class="main_div">
        <div class="main_top">
            中心机房管理系统
        </div>
        <div class="main_body">
            <div class="main_menu">
                <ul>
                    <li class="menu_li">
                        <div menu_div>
                            <a >用户管理</a>
                        </div>
                    </li>
                    <li class="menu_li">
                        <div menu_div>
                            <a>添加用户</a>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="main_right">
                <div id="main_page" style="padding: 20px">
                    <div class="table_up">
                        <div class="table_up_text">
                                <form action="queryNum.html">
                                    按账号查询：
                                    <input type="text" name="queryNum" placeholder="请输入用户账户">
                                    <input type="submit" value="查询">
                                </form>
                            </div>
                        <div class="table_up_text">
                                <form action="queryName.html">
                                    按用户名查询：
                                    <input type="text" name="queryName" placeholder="请输入用户名">
                                    <input type="submit" value="查询">
                                </form>
                            </div>
                        <div class="table_up_bu">
                             <a href="gain.html" methods="Get"><span>获取用户信息</span></a>
                        </div>
                        <div class="table_up_bu">
                             <a href = "JavaScript:void(0)" onclick = "openAdduser()"><span>添加用户</span></a>
                        </div>
                    </div>
                </div>
                <div main_table>
                    <table class="main_table_tb" frame="below" border="1px" bordercolor="#DBDBDB" cellspacing="0px" style="border-collapse:collapse">
                        <tread>
                            <tr class="table-body" style="color: red">
                                <td>Id</td>
                                <td>账户</td>
                                <td>用户名</td>
                                <td>性别</td>
                                <th>年龄</th>
                                <td>密码</td>
                                <td>积分</td>
                                <td>修改</td>
                                <td>删除</td>
                            </tr>
                        </tread>
                        <tbody>
                            <c:forEach items="${userList}" var="user">
                                <tr class="table-body">
                                    <td class="user">${user.userId}</td>
                                    <td class="user">${user.userNum}</td>
                                    <td class="user">${user.userName}</td>
                                    <td class="user">${user.userSex}</td>
                                    <td class="user">${user.userAge}</td>
                                    <td class="user">${user.password}</td>
                                    <td class="user">${user.credits}</td>
                                    <td><a href ="${pageContext.request.contextPath}/reviseuser.html?userNum=${user.userNum}">修改</a></td>
                                    <td><a href="${pageContext.request.contextPath}/deleteuser.html?delId=${user.userId}"onclick="return deleteuser()">删除</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="adduser" class="adduser_content">
    <div>
        <h1 style="text-align: center">添加用户</h1>
        <form action="adduser.html" method="post">
            用户名:
            <input class="input_text" type="text" name="userName">
            <br><br>
            年龄：
            <input class="input_text" type="text" name="userAge">
            <br>
            <label>性别：</label>
            <label>男</label>
            <input type="radio" value="男"  name="userSex" />
            <label>女</label>
            <input type="radio" value="女"  name="userSex" />
            <br>
            账号：
            <input class="input_text" type="text" name="userNum">
            <br><br>
            密码：
            <input class="input_text" type="password" name="password">
            <br><br>
            <div style="text-align: right">
                <input class="main_button" type="submit" value="添加" />
                <input class="main_button" type="button" onclick="closeAdduser()" value="取消">
            </div>

        </form>
    </div>
</div>
<div id="fade" class="black_overlay"></div>
</body>
</html>
