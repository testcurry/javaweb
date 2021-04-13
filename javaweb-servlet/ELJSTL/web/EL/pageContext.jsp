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
    <title>pageContext隐含对象</title>
</head>
<body>
<%=request.getScheme()%>
<%=request.getServerName()%>
<%=request.getServerPort()%>
<%=request.getServletPath()%>
<%=request.getRemoteHost()%>
<%=request.getMethod()%>
<%=session.getId()%>
<%--    //可以获取jsp的9大内置对象：--%>
    协议：${pageContext.request.scheme}<br>
    服务器ip:${pageContext.request.serverName}<br>
    服务器端口：${pageContext.request.serverPort}<br>
    工程路径：${pageContext.request.servletPath}<br>
    请求方式：${pageContext.request.method}<br>
    客户端IP：${pageContext.request.remoteHost}<br>
    会话id：${pageContext.session.id}<br>
    pageContext对象输出的值：${pageContext.servletConfig}<br>

</body>
</html>
