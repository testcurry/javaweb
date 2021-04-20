<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/21
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>target.jsp</title>
</head>
<body>
    <%
        System.out.println("target.jsp执行了！");
        System.out.println(Thread.currentThread().getName()+"target.jsp");
    %>
</body>
</html>
