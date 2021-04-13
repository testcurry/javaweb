<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<%--静态包含--%>
  <%--  头部信息</br>
    主题内容</br>
    <%@include file="/include/foot.jsp"%>--%>

<%--动态包含--%>
  头部信息</br>
  主题内容</br>
<jsp:include page="/include/foot.jsp">
  <jsp:param name="username" value="root"/>
  <jsp:param name="passwprd" value="123456"/>
</jsp:include>

</body>
</html>
