<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL其他的6个隐藏对象</title>
</head>
<body>
输出请求参数username的值：${param.username}<br>
输出请求参数hobby的多个值：${paramValues.hobby[0]}<br>
输出请求参数hobby的多个值：${paramValues.hobby[1]}<br>
<hr>
输出header的值：${header}<br>
<hr>
输出header的host值：${header.host}<br>
输出header的User-Agent值：${header["User-Agent"]}<br>
<hr>
输出请求参数多个header(headerValues)的值：${headerValues}<br>
输出headerValues中User-Agent的值：${headerValues["User-Agent"][0]}<br>
获取cookie：${cookie}<br>
获取cookie对象：${cookie.JSESSIONID}<br>
获取cookie的name值：${cookie.JSESSIONID.name}<br>
获取cookie的value值：${cookie.JSESSIONID.value}<br>
输出请求参数context-param的值：${initParam.url}<br>
</body>
</html>
