<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24 0024
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户信息修改</title>
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
                <div class="revise">
                    <div class="revise_re">
                        <h1 style="text-align: center">用户信息修改</h1>
                        <form action="revise.html" method="post">
                            用户Id：
                            <input  class="input_text" type="text" value="${user.userId}" name="userId" readonly>
                            <br>
                            账号：
                            <input  class="input_text" type="text" value="${user.userNum}" name="userNum" >
                            <br>
                            用户名：
                            <input  class="input_text" type="text" value="${user.userName}" name="userName" >
                            <br>
                            年龄：
                            <input  class="input_text" type="text" value="${user.userAge}" name="userAge" >
                            <br>
                            性别：
                            <input  class="input_text" type="text" value="${user.userSex}" name="userSex" >
                            <br>
                            密码：
                            <input  class="input_text" type="text" value="${user.password}" name="password">
                            <br>
                            积分：
                            <input  class="input_text" type="text" name="credits" value="${user.credits}">
                            <br>
                            <div style="text-align: center">
                                <input style="background: darkblue;color: white" type="submit" value="确定修改"/>
                            </div>
                        </form>
                    </div>
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
                <input style="background: darkblue;color: white" type="submit" value="添加" />
                <input style="background: darkblue;color: white" type="button" onclick="closeAdduser()" value="取消">
            </div>

        </form>
    </div>
</div>
<div id="fade" class="black_overlay"></div>
</body>
</html>