<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/20
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a.jsp</title>
</head>
<body>
<%
    System.out.println("a.jsp执行了");
    Object user = session.getAttribute("loginUser");
    if (user==null){
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return;
    }
//    request.getRequestDispatcher("/admin/a.jsp").forward(request,response);
%>
<h3>a.jsp</h3>
</body>
</html>
