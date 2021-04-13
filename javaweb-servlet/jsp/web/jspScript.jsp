<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/12
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>jsp的脚本</title>
</head>
<body>
<%-- jsp的声明脚本格式<%!  %>   中间的内容为声明java代码--%>
<%--给jsp定义属性--%>
<%!
    private String username="Curry";
    private Integer id;
    private static Map<String, String> map;

%>
<%--声明静态代码块--%>
<%!
    static {
        map = new HashMap<String, String>();
        map.put("tset", "abc");
        map.put("tset21", "abc21");
        map.put("tset21", "abc123");
    }
%>
<%--声明方法--%>
<%!
    public Object test() {
        return null;
    }
%>
<%--声明内部类--%>
<%!
    public static class A {
        private String name;
        private Integer id;
        private static Map<String, String> map;
    }
%>

<%-- jsp的表达式脚本格式 <%=  %> ，作用是在页面上输出数据  --%>
    <%=12 %></br>
    <%=12.21 %></br>
    <%="java" %></br>
    <%=map %></br>
<%= request.getParameter("username")%>

<%--代码脚本：格式  <% java语句（if，for） %>             --%>
<%
    if (12 == 12) {
        System.out.println(true);
    } else {
        System.out.println(false);
    }
%>
<%
    for (int i = 0; i < 10; i++) {
        System.out.println(i);
    }
%>
<%
    String username = request.getParameter("username");
    System.out.println(username);
%>
</body>
</html>
