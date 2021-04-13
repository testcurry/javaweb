<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>三元运算</title>
</head>
<body>
    <hr>
   <%
       HashMap<String, String> map = new HashMap<>();
       map.put("key","value");
       map.put("k.e.y","value");
       map.put("k-e-y","value");
       request.setAttribute("map",map);
   %>
    ${map.key}<br>
    ${map["k.e.y"]}<br>
    ${map["k-e-y"]}<br>
</body>
</html>
