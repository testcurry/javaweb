<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式的empty运算</title>
</head>
<body>
<%
    request.setAttribute("emptyNull",null);
    request.setAttribute("emptyStr","");
    request.setAttribute("emptyArray",new String[]{});
    request.setAttribute("emptyList",new ArrayList<String>());
    request.setAttribute("emptyMap",new HashMap<String,String>());
%>
${empty emptyNull}<br>
${empty emptyStr}<br>
${empty emptyArray}<br>
${empty emptyList}<br>
${empty emptyMap}<br>
</body>
</html>
