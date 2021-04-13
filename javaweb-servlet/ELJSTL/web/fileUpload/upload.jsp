<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传和下载</title>
</head>
<body>
    <form action="http://localhost:8080/ELJSTL/uploadServlet" enctype="multipart/form-data" method="post">
        用户名：<input type="text" name="username"><br>
        头像：<input type="file" name="file"><br>
        <input type="submit">
    </form>
</body>
</html>
