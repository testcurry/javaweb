<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/20
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录首页</title>
</head>
<body>
    <form action="http://localhost:8080/filter/loginServlet" method="post">
        用户名称：<input type="text" name="username"/><br>
        用户密码:<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
