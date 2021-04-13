<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式搜索4个域的顺序</title>
</head>
<body>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
<%--    EL表达式输出的顺序为从小到大（pageCOntext-request-session-application）的顺序优先输出--%>
    EL表达式输出的值${key}
</body>
</html>
