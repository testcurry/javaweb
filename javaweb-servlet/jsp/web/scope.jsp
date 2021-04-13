<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/12
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP四个域对象</title>
</head>
<body>
<%--
作用相同，都可以存取数据，只是存取范围不一样
    pageContext(PageContextImpl类)存取范围当前页面有效
    request(HttpServletRequest类)存取范围一次请求有效
    session(HttpSession类)存取范围一次会话有效（浏览器未关闭的所有都市一次会话）
    application(ServletContext类)存取范围当前工程有效，重新部署后失效

--%>
<%
    pageContext.setAttribute("key1","value1");
    request.setAttribute("key1", "value1");
    session.setAttribute("key1","value2");
    application.setAttribute("key1","value3");


%>
request域对象：<%=request.getAttribute("key1")%></br>
session：<%=session.getAttribute("key1")%></br>
application：<%=application.getAttribute("key1")%></br>
<%--<%
    request.getRequestDispatcher("/scope1.jsp").forward(request,response);

%>--%>
<%--请求转发--%>
<jsp:forward page="/scope1.jsp"></jsp:forward>
</body>
</html>
