<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>
    jsp表达式request域中的值：<%=request.getAttribute("key")%></br>
    EL表达式request域中的值：${key}</br>
</body>
</html>
